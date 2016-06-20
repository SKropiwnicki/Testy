package com.example.restservicedemo;

import com.example.restservicedemo.domain.Player;
import com.example.restservicedemo.domain.Weapon;
import com.example.restservicedemo.service.PlayerManager;
import com.jayway.restassured.RestAssured;
import org.dbunit.Assertion;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DBUnitTest {
	
	private static IDatabaseConnection connection ;
	private static IDatabaseTester databaseTester;
	
	private static PlayerManager pm = new PlayerManager();
	

	@BeforeClass
	public static void setUp() throws Exception{
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/restservicedemo/api";
		
		Connection jdbcConnection;
		jdbcConnection = DriverManager.getConnection(
				"jdbc:hsqldb:hsql://localhost/workdb", "sa", "");
		connection = new DatabaseConnection(jdbcConnection);
		
		databaseTester = new JdbcDatabaseTester(
				"org.hsqldb.jdbcDriver", "jdbc:hsqldb:hsql://localhost/workdb", "sa", "");
		IDataSet dataSet = new FlatXmlDataSetBuilder().build(
				new FileInputStream(new File("src/test/resources/fullData.xml")));
		databaseTester.setDataSet(dataSet);
		databaseTester.onSetup();
	}

	@Before
	public void cleanTables() {
		//It's important to always clear Weapons first, because of foreign key violation
		pm.clearWeapons();
		pm.clearPlayers();
	}

	@Test
	public void addPlayer() throws Exception{
	
		Player aPlayer = new Player("TestName",20,"Warrior");
		//aPlayer.setId(1);
		given().
				contentType(MediaType.APPLICATION_JSON).
				body(aPlayer).
				when().post("/player/").
				then().assertThat().statusCode(201);
		
		IDataSet dbDataSet = connection.createDataSet();
		ITable actualTable = dbDataSet.getTable("PLAYER");
		ITable filteredTable = DefaultColumnFilter.excludedColumnsTable
				(actualTable, new String[]{"P_ID"});
		
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(
				new File("src/test/resources/playerData.xml"));
		ITable expectedTable = expectedDataSet.getTable("PLAYER");
		
		Assertion.assertEquals(expectedTable, filteredTable);
	}

	@Test
	public void addWeapon() throws Exception{

		Weapon aWeapon = new Weapon("TestWeapon","Epic Sword",13);
		given().
				contentType(MediaType.APPLICATION_JSON).
				body(aWeapon).
				when().post("/weapon/").
				then().assertThat().statusCode(201);


		IDataSet dbDataSet = connection.createDataSet();
		ITable actualTable = dbDataSet.getTable("WEAPON");
		ITable filteredTable = DefaultColumnFilter.excludedColumnsTable
				(actualTable, new String[]{"W_ID"});

		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(
				new File("src/test/resources/weaponData.xml"));
		ITable expectedTable = expectedDataSet.getTable("WEAPON");

		Assertion.assertEquals(expectedTable, filteredTable);
	}

	@Test
	public void sellWeapon() throws Exception{

		Weapon aWeapon = new Weapon("TestWeapon","Epic Sword",13);
		given().
				contentType(MediaType.APPLICATION_JSON).
				body(aWeapon).
				when().post("/weapon/").
				then().assertThat().statusCode(201);
		Player aPlayer = new Player("TestName",20,"Warrior");
		//aPlayer.setId(1);
		given().
				contentType(MediaType.APPLICATION_JSON).
				body(aPlayer).
				when().post("/player/").
				then().assertThat().statusCode(201);

		given().
				contentType(MediaType.APPLICATION_JSON).
				when().
				post("/weapon/sell/1/1").then().assertThat().statusCode(201);

		IDataSet dbDataSet = connection.createDataSet();
		ITable actualTable = dbDataSet.getTable("WEAPON");
		ITable filteredTable = DefaultColumnFilter.excludedColumnsTable
				(actualTable, new String[]{"W_ID"});

		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(
				new File("src/test/resources/soldWeaponData.xml"));
		ITable expectedTable = expectedDataSet.getTable("WEAPON");

		Assertion.assertEquals(expectedTable, filteredTable);
	}
	
	@AfterClass
	public static void tearDown() throws Exception{
		databaseTester.onTearDown();
	}

}
