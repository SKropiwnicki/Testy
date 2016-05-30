package com.example.restservicedemo.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.restservicedemo.domain.Weapon;
/*
@Path("Weapon")
public class WeaponRESTService {
	
	@GET
	@Path("/{weaponId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Weapon getWeapon(@PathParam("weaponId") Long id){
		return new Weapon(1L, "Opel", "Corsa", 2005);
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Weapon weapon) {
 
		String result = "Weapon saved: " + weapon;
		return Response.status(201).entity(result).build(); 
	}

}*/
