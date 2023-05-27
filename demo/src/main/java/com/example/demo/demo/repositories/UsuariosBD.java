package com.example.demo.demo.repositories;

import java.util.List;

import com.example.demo.demo.entities.Usuario;

public interface UsuariosBD {

    void insertar(Usuario usuario);
    List<Usuario> obtener();
    void borrar(Usuario usuario);
    Usuario buscar(Usuario usuario);

}
