package com.example.restservicedemo;

import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.path.json.JsonPath.from;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import javax.ws.rs.core.MediaType;

import com.example.restservicedemo.domain.Player;
import com.example.restservicedemo.domain.Professions;
import com.example.restservicedemo.domain.Weapon;
import com.example.restservicedemo.service.PlayerManager;
import com.jayway.restassured.path.json.JsonPath;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;

import java.util.ArrayList;
import java.util.List;

public class PlayerManagerTest {


	private static Player p1;
	private static Player p2;
	private static Player p3;
	private static Weapon w1;
	private static Weapon w2;
	private static Weapon w3;
	private static PlayerManager pm = new PlayerManager();

	@BeforeClass
    public static void setUp(){
		//Must be three different players and weapons for test purpose.
		p1 = new Player( "Tomek", 5, "Mage", 1);
		p2 = new Player( "ZabujcaPL", 70, "Rogue", 2);
		p3 = new Player( "PolskiPolak", 20, "Warrior", 1);
		w1 = new Weapon( "Sword", "Simple iron Sword", 20);
		w2 = new Weapon( "Bow", "Deadly ranged weapon", 11);
		w3 = new Weapon( "Staff of Magi", "Magical staff from far east", 32);


    }

	@Before
	public void cleanTables(){
		//It's important to always clear Weapons first, cause of foreign key violation
		pm.clearWeapons();
		pm.clearPlayers();
	}


	@Test
	public void addPlayer(){
		assertEquals("Count didn't change", 1, pm.addPlayer(p1));
	}

	@Test
	public void getAllPlayers(){

		pm.addPlayer(p1);
		pm.addPlayer(p2);
		pm.addPlayer(p3);

		List<Player> players = new ArrayList<>();

		players = pm.getAllPlayers();

		assertEquals(3, players.size());
		assertNotEquals("Elements on the list are equals! Detected duplicate", players.get(0), players.get(1));
		assertNotEquals("Elements on the list are equals! Detected duplicate", players.get(1), players.get(2));

		assertEquals(p1.getNickname(), players.get(0).getNickname());
		assertEquals(p2.getNickname(), players.get(1).getNickname());
		assertEquals(p3.getNickname(), players.get(2).getNickname());
	}
	@Test
	public void getPlayerByNickname(){
		pm.addPlayer(p1);
		Player answer = pm.getPlayerByNickname(p1.getNickname());
		assertEquals("Object didn't get id from database", true, answer.hasId());
		assertEquals("Nicknames are different", p1.getNickname(), answer.getNickname());
		assertEquals("Levels are different", p1.getLevel(), answer.getLevel());
		assertEquals("Professions are different", p1.getProfessionStr(), answer.getProfessionStr());
	}

	@Test
	public void getPlayerById(){
		pm.addPlayer(p1);
		Player answer2 = pm.getPlayerByNickname(p1.getNickname());
		assertEquals("Object didn't get id from database", true, answer2.hasId());

		Player answer = pm.getPlayer(answer2.getId());

		assertEquals("Nicknames are different", p1.getNickname(), answer.getNickname());
		assertEquals("Levels are different", p1.getLevel(), answer.getLevel());
		assertEquals("Professions are different", p1.getProfessionStr(), answer.getProfessionStr());
	}

	@Test
	public void deletePlayer(){
		pm.addPlayer(p1);
		Player answer = pm.getPlayerByNickname(p1.getNickname());
		assertEquals("Object didn't get id from database", true, answer.hasId());

		List<Player> players;
		players = pm.getAllPlayers();
		assertEquals("Should be  1 object in DB", 1, players.size());

		pm.deletePlayer(answer.getId());
		players = pm.getAllPlayers();
		assertEquals("DB is not empty!",0, players.size());

		pm.addPlayer(p1);
		pm.addPlayer(p2);
		pm.addPlayer(p3);
		players = pm.getAllPlayers();
		assertEquals("Should be  3 objects in DB", 3, players.size());

		answer = pm.getPlayerByNickname(p1.getNickname());
		pm.deletePlayer(answer.getId());
		players = pm.getAllPlayers();
		assertEquals("Number of objects in DB is wrong",2, players.size());
	}
	@Test
	public void addWeapon(){
		assertEquals("Count didn't change", 1, pm.addWeapon(w1));
	}

	@Test
	public void getAllWeapons(){

		pm.addWeapon(w1);
		pm.addWeapon(w2);
		pm.addWeapon(w3);

		List<Weapon> weapons;

		weapons = pm.getAllWeapons();

		assertEquals(3, weapons.size());
		assertNotEquals("Elements on the list are equals! Detected duplicate", weapons.get(0), weapons.get(1));
		assertNotEquals("Elements on the list are equals! Detected duplicate", weapons.get(1), weapons.get(2));

		assertEquals(w1.getName(), weapons.get(0).getName());
		assertEquals(w2.getName(), weapons.get(1).getName());
		assertEquals(w3.getName(), weapons.get(2).getName());
	}

	@Test
	public void getWeaponWithOwner() {
		//add
	}

	@Test
	public void sellWeapon(){

		assertEquals("Should return -1, because of no ID",-1, pm.sellWeapon(w1, p1));


		pm.addPlayer(p1);
		pm.addPlayer(p2);
		pm.addPlayer(p3);
		pm.addWeapon(w1);
		pm.addWeapon(w2);

		List<Player> players = pm.getAllPlayers();
		assertEquals("Object didn't get id from database", true, players.get(0).hasId());
		assertEquals("Object didn't get id from database", true, players.get(1).hasId());
		assertEquals("Object didn't get id from database", true, players.get(2).hasId());

		List<Weapon> weapons = pm.getAllWeapons();
		assertEquals("Object didn't get id from database", true, weapons.get(0).hasId());
		assertEquals("Object didn't get id from database", true, weapons.get(1).hasId());


		assertEquals(1, pm.sellWeapon( weapons.get(0), players.get(0)));

		Weapon answer = pm.getWeaponWithOwner(weapons.get(0));

		assertEquals(players.get(0).getNickname(), answer.getOwner().getNickname());
		assertEquals(players.get(0).getId(), answer.getOwner().getId());

		//pm.getWeaponWithOwner(w1.getId());
	}


}
