package com.example.restservicedemo.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Weapon {
	
	private long id;

	private String name;
	private String description;
	private int damage;

	private Player owner;
	
	public Weapon( String make, String model, int yop) {
		super();
		this.name = make;
		this.description = model;
		this.damage = yop;
	}
	
	public Weapon() {
	}

	public boolean hasId()
	{
		if (id!=0) return true;
		else return false;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int yop) {
		this.damage = yop;
	}
	public String getName() {return name;}

	public void setName(String name) {this.name = name;}

	public String getDescription() {return description;}

	public void setDescription(String description) {this.description = description;}

	public Player getOwner() {return owner;}

	public void setOwner(Player owner) {this.owner = owner;}
	
}
