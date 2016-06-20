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
import com.example.restservicedemo.domain.Weapon;
import com.example.restservicedemo.service.PlayerManager;

import java.util.List;
import java.util.Map;

@Path("player")
public class PlayerRESTService {
	
	private PlayerManager pm = new PlayerManager();
	
	@GET
	@Path("/{playerId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Player getPlayer(@PathParam("playerId") Long id){
		Player p = pm.getPlayer(id);
		return p;
	}
	@GET
	@Path("/byNickname/{playerName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Player getPlayerByNickname(@PathParam("playerName") String nickname){
		Player p = pm.getPlayerByNickname(nickname);
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
	@Produces(MediaType.APPLICATION_JSON)
	public List<Player> getAllPersons() {
		return pm.getAllPlayers();
	}

	//Look into json here. Probably needs mapper.
	@GET
	@Path("/allWithWeapons")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<Player, List<Weapon>> getAllPersonsWithWeapons() {
		return pm.getPlayersWithWeapons();
	}


	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public String test(){
		return "REST API /player is running and ready to action";
	}
	
	@DELETE
	public Response clearPlayers(){
		pm.clearPlayers();
		return Response.status(200).build();
	}


	@DELETE
	@Path("/delete/{playerId}")
	public Response clearPlayers(@PathParam("playerId") Long id){
		pm.deletePlayer(id);
		return Response.status(200).build();
	}

}
