package com.example.restservicedemo;

import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.path.json.JsonPath.from;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.MediaType;

import com.example.restservicedemo.domain.Player;
import com.example.restservicedemo.domain.Professions;
import com.example.restservicedemo.service.PlayerManager;
import com.jayway.restassured.path.json.JsonPath;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;

import java.util.List;

public class PlayerRESTTest {


	private static Player p1;
	private static Player p2;
	private static Player p3;
	private static Player wrongp;
	private static PlayerManager pm = new PlayerManager();

	@BeforeClass
    public static void setUp(){

		p1 = new Player(1, "Tomek", 5, Professions.MAGE, 1);
		p2 = new Player(2, "ZabujcaPL", 70, Professions.ROGUE, 2);
		p3 = new Player(3, "PolskiPolak", 20, Professions.WARRIOR, 1);
		wrongp = new Player(4, "Eldoka", 10, Professions.ERROR, 5);
		wrongp.setProfession("Errorowo");
    }

	@Before
	public void cleanTable(){
		pm.clearPlayers();
	}
	
	@Test
	public void getPlayerById(){
		pm.addPlayer(p1);
		assertEquals(p1.getNickname(), pm.getPlayer(p1.getId()).getNickname());
		assertEquals(p1.getProfession(), pm.getPlayer(p1.getId()).getProfession());
	}

	@Test
	public void wrongProfession(){
		pm.addPlayer(wrongp);
		assertEquals(p1.getNickname(), pm.getPlayer(p1.getId()).getNickname());
		assertEquals(Professions.ERROR, pm.getPlayer(p1.getId()).getProfession());
	}
	

}
