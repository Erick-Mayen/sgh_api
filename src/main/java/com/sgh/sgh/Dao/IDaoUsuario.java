package com.sgh.sgh.Dao;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgh.sgh.Entity.Usuario;

@Repository("usuarioRepository")
public interface IDaoUsuario extends JpaRepository<Usuario, Serializable>{

	Optional<Usuario> findBynombreUsuarioAndClave(String nombre_usuario, String clave);	
	//public List<Usuario> findAll();
	//public Optional<Usuario> findById(Long id);
	//public Usuario save(Usuario usuario);
    //public void deleteById(Long id);
	
	
}
