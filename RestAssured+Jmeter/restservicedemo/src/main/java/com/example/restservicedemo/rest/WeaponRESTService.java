package com.example.restservicedemo.rest;

import javax.ws.rs.*;
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
    @Path("/withOwner")
    //@Produces(MediaType.APPLICATION_JSON)
    public Weapon getPlayer(@PathParam("weaponId") Weapon weapon){
        Weapon w = pm.getWeaponWithOwner(weapon);
        return w;
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
    @Consumes(MediaType.APPLICATION_JSON)
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
