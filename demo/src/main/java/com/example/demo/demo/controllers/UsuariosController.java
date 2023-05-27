package com.example.demo.demo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.demo.entities.Usuario;
import com.example.demo.demo.services.UsuariosService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Component
@Path("/")
public class UsuariosController {

    private final UsuariosService usuariosService;

    public UsuariosController(UsuariosService usuariosService){
        this.usuariosService = usuariosService;
    }

    @GET
    @Path("/usuarios")
    @Produces("application/json")
    public List<Usuario> listarTodos(){
        return usuariosService.listar();
    }

    @GET
    @Path("/usuarios/{nombre}")
    @Produces("application/json")
    public Usuario listarUser(@PathParam("nombre") String nombre){
        return usuariosService.obtener(nombre);
    }

    @POST 
    @Path("/usuarios")
    @Produces("application/json")
    @Consumes("application/json")
    public Response addUser(Usuario usuario){
        this.usuariosService.insertar(usuario);
        return Response.created(URI.create("/usuarios/"+ usuario.nombreUsuario)).build();
    }

    @DELETE
    @Path("/usuarios/{nombre}")
    @Consumes("application/json")
    public Response borrarUser(@PathParam("nombre") String nombre){
        usuariosService.borrar(nombre);
        return Response.ok().build();
    }
    
}
