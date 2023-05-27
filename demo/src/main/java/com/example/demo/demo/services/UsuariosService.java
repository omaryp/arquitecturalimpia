package com.example.demo.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.demo.entities.Usuario;
import com.example.demo.demo.repositories.UsuariosBD;
import com.example.demo.demo.repositories.UsuariosBDMemoria;

@Service
public class UsuariosService{

    private final UsuariosBD bd ;

    public UsuariosService(UsuariosBDMemoria bd){
        this.bd = bd;
    }

    public List<Usuario> listar() {
        return bd.obtener();
    }

    public Usuario obtener(String username) {
        Usuario usuario = new Usuario();
        usuario.nombreUsuario = username;
        return bd.buscar(usuario);
    }

    public void insertar(Usuario usuario) {
        if (bd.buscar(usuario)!= null) {
            return;
        }
        bd.insertar(usuario);
    }

    public void borrar(String username) {
        Usuario usuario = new Usuario();
        usuario.nombreUsuario = username;

        bd.borrar(usuario);
        
    }


}
