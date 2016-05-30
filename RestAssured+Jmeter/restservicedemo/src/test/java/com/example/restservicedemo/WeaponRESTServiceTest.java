package com.example.restservicedemo;

import com.example.restservicedemo.domain.Weapon;
import com.example.restservicedemo.domain.Weapon;
import com.jayway.restassured.RestAssured;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import java.util.List;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.path.json.JsonPath.from;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class WeaponRESTServiceTest {

	private static Weapon w1;
	private static Weapon w2;
	private static Weapon w3;


	@BeforeClass
	public static void setUp(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/restservicedemo/api";

		w1 = new Weapon("Sword", "Simple iron Sword", 20);
		w2 = new Weapon("Bow", "Deadly ranged weapon", 11);
		w3 = new Weapon("Staff of Magi", "Magical staff from far east", 32);
	}

	@Before
	public void clearDB(){
		delete("/player/").then().assertThat().statusCode(200);
		delete("/weapon/").then().assertThat().statusCode(200);
	}


	@Test
	public void addWeapon(){

		given().
				contentType(MediaType.APPLICATION_JSON).
				body(w1).
				when().
				post("/weapon/").then().assertThat().statusCode(201);

//		String result = get("/weapon/all/").asString();

//		List<Weapon> weapons = from(result).get("weapon");

//		assertNotNull(weapons);
	//	assertEquals(1, weapons.size());
		//assertThat(w1.getName(), equalToIgnoringCase(rWeapon.getName()));

	}

	@Test
	public void getAllWeapons(){

		given().
				contentType(MediaType.APPLICATION_JSON).
				body(w1).
				when().
				post("/weapon/").then().assertThat().statusCode(201);
		given().
				contentType(MediaType.APPLICATION_JSON).
				body(w2).
				when().
				post("/weapon/").then().assertThat().statusCode(201);
		given().
				contentType(MediaType.APPLICATION_JSON).
				body(w3).
				when().
				post("/weapon/").then().assertThat().statusCode(201);

		String result = get("/weapon/all/").asString();

		List<Weapon> weapons = from(result).get("weapon");


		System.out.print(weapons.get(0));

		assertNotNull(weapons);
		assertEquals(3, weapons.size());

	}


}
