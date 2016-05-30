package com.example.restservicedemo;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import com.example.restservicedemo.domain.Weapon;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;

public class WeaponServiceTest {
	/*
	@BeforeClass
	public static void setUp(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/restservicedemo/api";
	}
	
	@Test
	public void getCar(){
		get("/car/0").then().assertThat().body("model", equalTo("Corsa"));
		
		Weapon aWeapon = get("/car/0").as(Weapon.class);
		assertThat(aWeapon.getMake(), equalToIgnoringCase("Opel"));
	}
	
	@Test
	public void addCar(){
		
		Weapon aWeapon = new Weapon(2, "Ford", "Fiesta", 2011);
		given().
		       contentType("application/json").
		       body(aWeapon).
		when().	     
		post("/car/").then().assertThat().statusCode(201).body(containsString("Weapon saved:"));
	}
	
*/
}
