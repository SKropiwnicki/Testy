package com.example.restservicedemo;

import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.path.json.JsonPath.from;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.example.restservicedemo.domain.Player;
import com.example.restservicedemo.domain.Weapon;
import com.google.common.reflect.TypeToken;
import com.jayway.restassured.mapper.ObjectMapper;
import com.jayway.restassured.path.json.JsonPath;
import org.codehaus.jackson.map.type.TypeFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;

import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

public class PlayerRESTServiceTest {

	private static Player p1;
	private static Player p2;
	private static Player p3;


	@BeforeClass
	public static void setUp(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/restservicedemo/api";

		p1 = new Player("Tomek", 5, "Mage", 1);
		p2 = new Player("ZabujcaPL", 70, "Rogue", 2);
		p3 = new Player("PolskiPolak", 20, "Warrior", 1);
	}

	@Before
	public void clearDB(){
		delete("/player/").then().assertThat().statusCode(200);
		delete("/weapon/").then().assertThat().statusCode(200);
	}


	@Test
	public void addPlayer(){

		given().
				contentType(MediaType.APPLICATION_JSON).
				body(p1).
				when().
				post("/player/").then().assertThat().statusCode(201);

		Player rPlayer = get("/player/1").as(Player.class);

		assertThat(p1.getNickname(), equalToIgnoringCase(rPlayer.getNickname()));

	}

	@Test
	public void getAllPlayers(){

		given().
				contentType(MediaType.APPLICATION_JSON).
				body(p1).
				when().
				post("/player/").then().assertThat().statusCode(201);
		given().
				contentType(MediaType.APPLICATION_JSON).
				body(p2).
				when().
				post("/player/").then().assertThat().statusCode(201);
		given().
				contentType(MediaType.APPLICATION_JSON).
				body(p3).
				when().
				post("/player/").then().assertThat().statusCode(201);


		List<Player> players = Arrays.asList(get("/player/all").as(Player[].class));

		System.out.print(players.get(0));

		assertNotNull(players);
		assertEquals(3, players.size());

	}


}
