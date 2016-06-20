package com.example.restservicedemo;

import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.path.json.JsonPath.from;
import static org.hamcrest.CoreMatchers.is;
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
				post("/player/").
		then().
				assertThat().
				statusCode(201);

		given().
				contentType(MediaType.APPLICATION_JSON).
		when().
				get("/player/1").
		then().
				assertThat().
				statusCode(200);



		//Alternatywne sprawdzanie
		Player rPlayer = get("/player/1").as(Player.class);

		assertThat(p1.getNickname(), equalToIgnoringCase(rPlayer.getNickname()));

	}

	@Test
	public void getPlayerByNickname(){

		Player player = p1;

		given().
				contentType(MediaType.APPLICATION_JSON).
				body(player).
		when().
				post("/player/").
		then().
				assertThat().
				statusCode(201);

		given().
				contentType(MediaType.APPLICATION_JSON).
		when().
				get("/player/byNickname/"+player.getNickname()).
		then().
				body("id",equalTo("1")).
				body("nickname",equalTo(player.getNickname())).
				body("level",equalTo(""+player.getLevel())).
				body("professionStr",equalTo(player.getProfessionStr())).
				statusCode(200);



		//Alternatywne sprawdzanie
	//	Player rPlayer = get("/player/1").as(Player.class);

//		assertThat(p2.getNickname(), equalToIgnoringCase(rPlayer.getNickname()));

	}


	@Test
	public void getPlayer(){

		Player player = p2;

		given().
				contentType(MediaType.APPLICATION_JSON).
				body(player).
				when().
				post("/player/").
				then().
				assertThat().
				statusCode(201);

		given().
				contentType(MediaType.APPLICATION_JSON).
				when().
				get("/player/1").
				then().
				body("id",equalTo("1")).
				body("nickname",equalTo(player.getNickname())).
				body("level",equalTo(""+player.getLevel())).
				body("professionStr",equalTo(player.getProfessionStr())).
				statusCode(200);



		//Alternatywne sprawdzanie
		Player rPlayer = get("/player/1").as(Player.class);

		assertThat(p2.getNickname(), equalToIgnoringCase(rPlayer.getNickname()));

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

		given().
				contentType(MediaType.APPLICATION_JSON).
		when().
				get("/player/all").
		then().
				body("player.size()", equalTo(3)).
				body("player[0].id",equalTo("1")).
				body("player[0].nickname",equalTo(p1.getNickname())).
				body("player[0].level",equalTo(""+p1.getLevel())).
				body("player[0].professionStr",equalTo(p1.getProfessionStr())).
				body("player[1].id",equalTo("2")).
				body("player[1].nickname",equalTo(p2.getNickname())).
				body("player[1].level",equalTo(""+p2.getLevel())).
				body("player[1].professionStr",equalTo(p2.getProfessionStr())).
				body("player[2].id",equalTo("3")).
				body("player[2].nickname",equalTo(p3.getNickname())).
				body("player[2].level",equalTo(""+p3.getLevel())).
				body("player[2].professionStr",equalTo(p3.getProfessionStr())).
				statusCode(200);

	}

	@Test
	public void deletePlayerById(){

		//add 3 players
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


		//delete second.
		given().
				contentType(MediaType.APPLICATION_JSON).
				when().
				delete("/player/delete/2").
				then().
				statusCode(200);

		//check size
		given().
				contentType(MediaType.APPLICATION_JSON).
				when().
				get("/player/all").
				then().
				body("player.size()", equalTo(2)).
				statusCode(200);

	}


}
