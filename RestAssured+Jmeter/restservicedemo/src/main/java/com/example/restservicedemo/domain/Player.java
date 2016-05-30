package com.example.restservicedemo.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Player {
	
	private long id;
	
	private String nickname;
	private int level;
	private Professions profession;
	private String professionStr;
	private long weaponId;
	
	public Player() {
	}

	public Player(long id, String nickname, int level, Professions profession , long weaponId ) {
		this.id = id;
		this.nickname = nickname;
		this.level = level;
		this.profession = profession;
		this.professionStr = profession.toString();
		this.weaponId = weaponId;
	}

	public String getNickname() {return nickname;}

	public void setNickname(String nickname) {this.nickname = nickname;}

	public int getLevel() {return level;}

	public void setLevel(int level) {this.level = level;}

//public enum Professions {WARRIOR, MAGE, ROGUE, CLERIC, ERROR}
	public Professions getProfession() {return profession;}

	public void setProfession(String profession) {
		Professions actualProfession = Professions.ERROR;
		switch (profession) {
			case "WARRIOR":
				actualProfession = Professions.WARRIOR;
				break;
			case "MAGE":
				actualProfession = Professions.MAGE;
				break;
			case "ROGUE":
				actualProfession = Professions.ROGUE;
				break;
			case "CLERIC":
				actualProfession = Professions.CLERIC;
				break;
			default:
				actualProfession = Professions.ERROR;
		}

		this.profession = actualProfession;
	}

	public long getWeaponId() {return weaponId;}

	public void setWeaponId(long weaponId) {this.weaponId = weaponId;}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProfessionStr() {return professionStr;}

	public void setProfessionStr(String professionStr) {this.professionStr = professionStr;}
}
