package com.example.restservicedemo.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Weapon {
	
	private long id;

	private String name;
	private String description;
	private int damage;

	private Player owner;

	public Weapon (){}

	public Weapon( String name, String description, int damage) {
		super();
		this.name = name;
		this.description = description;
		this.damage = damage;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Weapon)) return false;

		Weapon weapon = (Weapon) o;

		if (id != weapon.id) return false;
		if (damage != weapon.damage) return false;
		if (name != null ? !name.equals(weapon.name) : weapon.name != null) return false;
		if (description != null ? !description.equals(weapon.description) : weapon.description != null) return false;
		return owner != null ? owner.equals(weapon.owner) : weapon.owner == null;

	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + damage;
		result = 31 * result + (owner != null ? owner.hashCode() : 0);
		return result;
	}
}
