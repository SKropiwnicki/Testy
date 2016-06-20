package com.example.restservicedemo.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Player {
	
	private long id;
	
	private String nickname;
	private int level;
	private String professionStr;
	
	public Player() {
	}

	public Player( String nickname, int level, String professionStr ) {
		this.nickname = nickname;
		this.level = level;
		this.professionStr = professionStr;
	}

	public boolean hasId()
	{
		if (id!=0) return true;
		else return false;
	}

	public String getNickname() {return nickname;}

	public void setNickname(String nickname) {this.nickname = nickname;}

	public int getLevel() {return level;}

	public void setLevel(int level) {this.level = level;}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProfessionStr() {return professionStr;}

	public void setProfessionStr(String professionStr) {this.professionStr = professionStr;}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Player player = (Player) o;

		if (id != player.id) return false;
		if (level != player.level) return false;
		if (nickname != null ? !nickname.equals(player.nickname) : player.nickname != null) return false;
		return professionStr != null ? professionStr.equals(player.professionStr) : player.professionStr == null;

	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
		result = 31 * result + level;
		result = 31 * result + (professionStr != null ? professionStr.hashCode() : 0);
		return result;
	}
}
