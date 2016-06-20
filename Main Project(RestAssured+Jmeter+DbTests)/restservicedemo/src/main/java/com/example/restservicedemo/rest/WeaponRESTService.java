package com.example.restservicedemo.rest;

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

@Path("weapon")
public class WeaponRESTService {


    private PlayerManager pm = new PlayerManager();

    @GET
    @Path("/{weaponId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Weapon getWeapon(@PathParam("weaponId") Long id){
        Weapon w = pm.getWeapon(id);
        return w;
    }
    @GET
    @Path("/withOwner/{weaponId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Weapon getWeaponWithOwner(@PathParam("weaponId") Long id){
        Weapon w = pm.getWeaponWithOwner(id);
        return w;
    }

    @POST
    @Path("/sell/{weaponId}/{playerId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response sellWeapon(@PathParam("weaponId") long w_id,
                               @PathParam("playerId") long p_id)
    {
        Weapon weapon = pm.getWeapon(w_id);
        Player player = pm.getPlayer(p_id);
        pm.sellWeapon(weapon, player);
        return Response.status(201).entity("Weapon").build();
    }


    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addWeapon(Weapon weapon){
        pm.addWeapon(weapon);
        return Response.status(201).entity("Weapon").build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Weapon> getAllWeapons() {
        return pm.getAllWeapons();
    }



    @DELETE
    public Response clearWeapons(){
        pm.clearWeapons();
        return Response.status(200).build();
    }

}
