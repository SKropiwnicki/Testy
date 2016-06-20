package com.example.restservicedemo;

import com.example.restservicedemo.domain.Player;
import com.example.restservicedemo.domain.Weapon;
import com.example.restservicedemo.domain.Weapon;
import com.jayway.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.path.json.JsonPath.from;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class WeaponRESTServiceTest {

	private static Weapon w1;
	private static Weapon w2;
	private static Weapon w3;

	private static Player p1;
	private static Player p2;
	private static Player p3;


	@BeforeClass
	public static void setUp(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/restservicedemo/api";

		w1 = new Weapon("Sword", "Sword desc", 20);
		w2 = new Weapon("Bow", "Deadly ranged weapon", 11);
		w3 = new Weapon("Staff of Magi", "Magical staff from far east", 32);

		p1 = new Player("Tomek", 5, "Mage");
		p2 = new Player("ZabujcaPL", 70, "Rogue");
		p3 = new Player("PolskiPolak", 20, "Warrior");
	}

	@Before
	public void clearDB(){
		delete("/player/").then().assertThat().statusCode(200);
		delete("/weapon/").then().assertThat().statusCode(200);
	}


	@Test
	public void addWeapon(){

		Weapon weapon = w1;
		given().
				contentType(MediaType.APPLICATION_JSON).
				body(weapon).
		when().
				post("/weapon/").
		then().assertThat().statusCode(201);

		given().
				contentType(MediaType.APPLICATION_JSON).
				when().
				get("/weapon/1").
				then().
				assertThat().
				body("id", equalTo("1")).
				body("name", equalTo(weapon.getName())).
				body("damage", equalTo(""+weapon.getDamage())).
				body("description", equalTo(weapon.getDescription())).
				statusCode(200);

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


		given().
				contentType(MediaType.APPLICATION_JSON).
		when().
				get("/weapon/all").
		then().
				body("weapon.size()", Matchers.equalTo(3)).
				body("weapon[0].id", Matchers.equalTo("1")).
				body("weapon[0].name", Matchers.equalTo(w1.getName())).
				body("weapon[0].damage", Matchers.equalTo(""+w1.getDamage())).
				body("weapon[0].description", Matchers.equalTo(w1.getDescription())).
				body("weapon[1].id", Matchers.equalTo("2")).
				body("weapon[1].name", Matchers.equalTo(w2.getName())).
				body("weapon[1].damage", Matchers.equalTo(""+w2.getDamage())).
				body("weapon[1].description", Matchers.equalTo(w2.getDescription())).
				body("weapon[2].id", Matchers.equalTo("3")).
				body("weapon[2].name", Matchers.equalTo(w3.getName())).
				body("weapon[2].damage", Matchers.equalTo(""+w3.getDamage())).
				body("weapon[2].description", Matchers.equalTo(w3.getDescription())).
				statusCode(200);

	}

	@Test
	public void sellWeaponAndWeaponWithOwner(){
		given().
				contentType(MediaType.APPLICATION_JSON).
				body(w1).
				when().
				post("/weapon/").then().assertThat().statusCode(201);
		given().
				contentType(MediaType.APPLICATION_JSON).
				body(p1).
				when().
				post("/player/").then().assertThat().statusCode(201);

		Weapon weapon = get("/weapon/1").as(Weapon.class);
		Player player = get("/player/1").as(Player.class);


		given().
				contentType(MediaType.APPLICATION_JSON).
				when().
				post("/weapon/sell/"+weapon.getId()+"/"+player.getId()).then().assertThat().statusCode(201);

		given().
				contentType(MediaType.APPLICATION_JSON).
				when().
				get("/weapon/withOwner/"+weapon.getId()).
				then().
				assertThat().
				body("id", equalTo(""+weapon.getId())).
				body("name", equalTo(weapon.getName())).
				body("damage", equalTo(""+weapon.getDamage())).
				body("description", equalTo(weapon.getDescription())).
				body("owner.id", equalTo(""+player.getId())).
				body("owner.nickname", equalTo(player.getNickname())).
				body("owner.level", equalTo(""+player.getLevel())).
				body("owner.professionStr", equalTo(player.getProfessionStr())).
				statusCode(200);
	}

}
