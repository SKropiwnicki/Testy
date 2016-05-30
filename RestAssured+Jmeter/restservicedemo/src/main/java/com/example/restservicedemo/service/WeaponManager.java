package com.example.restservicedemo.service;

import com.example.restservicedemo.domain.Weapon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WeaponManager {
/*
	private Connection connection;

	private static final String URL = "jdbc:hsqldb:hsql://localhost/workdb";
	private static final String CREATE_TABLE_PERSON = "CREATE TABLE Weapon(id bigint GENERATED BY DEFAULT AS IDENTITY," +
			" nickname varchar(20), level integer, profession varchar(20), weaponID integer)";

	private PreparedStatement addWeaponStmt;
	private PreparedStatement deleteAllWeaponsStmt;
	private PreparedStatement getAllWeaponsStmt;
	private PreparedStatement getWeaponByIdStmt;
	private PreparedStatement deleteByIdStmt;

	private Statement statement;

	public WeaponManager() {
		try {
			connection = DriverManager.getConnection(URL);
			statement = connection.createStatement();

			ResultSet rs = connection.getMetaData().getTables(null, null, null,
					null);
			boolean tableExists = false;
			while (rs.next()) {
				if ("Weapon".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tableExists = true;
					break;
				}
			}

			if (!tableExists)
				statement.executeUpdate(CREATE_TABLE_PERSON);

			addWeaponStmt = connection
					.prepareStatement("INSERT INTO Weapon (id, nickname, level, profession, weaponID) VALUES (?, ?, ?, ?, ?)");
			deleteAllWeaponsStmt = connection
					.prepareStatement("DELETE  FROM Weapon");
			getAllWeaponsStmt = connection
					.prepareStatement("SELECT id, nickname, level, profession, weaponID FROM Weapon");
			getWeaponByIdStmt = connection
					.prepareStatement("SELECT id, nickname, level, profession, weaponID FROM Weapon where id = ?");
			deleteByIdStmt = connection
					.prepareStatement("DELETE FROM Weapon where id = ?");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	Connection getConnection() {
		return connection;
	}

	public void clearWeapons() {
		try {
			deleteAllWeaponsStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int addWeapon(Weapon weapon) {
		int count = 0;
		try {
			addWeaponStmt.setLong(1, weapon.getId());
			addWeaponStmt.setString(2, weapon.getNickname());
			addWeaponStmt.setInt(3, weapon.getLevel());
			addWeaponStmt.setString(4, weapon.getProfessionStr());
			addWeaponStmt.setLong(5, weapon.getWeaponId());

			count = addWeaponStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<Weapon> getAllWeapons() {
		List<Weapon> weapons = new ArrayList<Weapon>();

		try {
			ResultSet rs = getAllWeaponsStmt.executeQuery();

			while (rs.next()) {
				Weapon p = new Weapon();
				p.setId(rs.getInt("id"));
				p.setNickname(rs.getString("nickname"));
				p.setLevel(rs.getInt("level"));
				p.setProfession(rs.getString("profession"));
				p.setWeaponId(rs.getLong("weaponID"));
				weapons.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return weapons;
	}

	public Weapon getWeapon(Long id) {
		Weapon p = new Weapon();
		try {
			getWeaponByIdStmt.setLong(1, id);
			ResultSet rs = getWeaponByIdStmt.executeQuery();

			while (rs.next()) {
				p.setId(rs.getInt("id"));
				p.setNickname(rs.getString("nickname"));
				p.setLevel(rs.getInt("level"));
				p.setProfession(rs.getString("profession"));
				p.setWeaponId(rs.getLong("weaponID"));

				break;
			}
			return p;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}
	public void deleteWeapon(Long id) {
		try {
			deleteByIdStmt.setLong(1, id);
			deleteByIdStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

*/
}
