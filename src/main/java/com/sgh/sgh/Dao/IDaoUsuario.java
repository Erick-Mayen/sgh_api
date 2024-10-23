package com.sgh.sgh.Dao;

import java.util.List;

import com.sgh.sgh.Entity.Usuario;

public interface IDaoUsuario {
    List<Usuario> listar();
    Usuario obtenerPorCorreo(String correo);
    Usuario crear(Usuario usuario);
    Usuario actualizar(Usuario usuario);
}
