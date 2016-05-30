package com.example.restservicedemo.rest;

import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.restservicedemo.domain.Player;
import com.example.restservicedemo.service.PlayerManager;

import java.util.List;

@Path("player")
public class PlayerRESTService {
	
	private PlayerManager pm = new PlayerManager();
	
	@GET
	@Path("/{playerId}")
	//@Produces(MediaType.APPLICATION_JSON)
	public Player getPlayer(@PathParam("playerId") Long id){
		Player p = pm.getPlayer(id);
		return p;
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPlayer(Player player){
		pm.addPlayer(player);
		return Response.status(201).entity("Player").build();
	}

	@GET
	@Path("/all")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Player> getAllPersons() {
		return pm.getAllPlayers();
	}
	
	
	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public String test(){
		return "REST API /player is running";
	}
	
	@DELETE
	public Response clearPlayers(){
		pm.clearPlayers();
		return Response.status(200).build();
	}

}
