package com.sgh.sgh.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


import com.sgh.sgh.Dao.IDaoUsuario;
import com.sgh.sgh.Entity.Usuario;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	//IDaoUsuario idaoUsuario;
	IDaoUsuario usuarioRepository;
	
	 @GetMapping(value= "/buscar")
	    public List<Usuario> getAllUsuarios() {
	        return usuarioRepository.findAll();
	    }
	 
	 @GetMapping("/{id}")
	    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
	        Optional<Usuario> usuario = usuarioRepository.findById(id);
	        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PostMapping(value = "/guardar")
	    public Usuario createUsuario(@RequestBody Usuario usuario) {
	        return usuarioRepository.save(usuario);
	    }
	
	    @PutMapping("/{id}")
	    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioDetails) {
	        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
	        if (usuarioOptional.isPresent()) {
	            Usuario usuario = usuarioOptional.get();
	            usuario.setNombre_usuario(usuarioDetails.getNombre_usuario());
	            usuario.setCorreo_electronico(usuarioDetails.getCorreo_electronico());
	            usuario.setClave(usuarioDetails.getClave());
	            usuario.setActivo(usuarioDetails.getActivo());
	            usuario.setRol_id(usuarioDetails.getActivo());
	            usuario.setUsuario_modificacion(usuarioDetails.getUsuario_modificacion());
	            usuario.setFecha_modificacion(usuarioDetails.getFecha_modificacion());
	            return ResponseEntity.ok(usuarioRepository.save(usuario));
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    
	    //cambiar a activo o inactivo
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> inactivateUsuario(@PathVariable Long id) {
	        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
	        if (usuarioOptional.isPresent()) {
	            Usuario usuario = usuarioOptional.get();
	            usuario.setActivo(0);
	            usuarioRepository.save(usuario);
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	   
	    
	    // Nuevo endpoint para buscar usuario por nombre de usuario y clave
	    
	    @GetMapping(value = "/login")
	    public ResponseEntity<Usuario> getUsuarioByNombre_UsuarioAndClave(@RequestParam String nombreUsuario, @RequestParam String clave) {
	            
            if (nombreUsuario == null || nombreUsuario.isEmpty() || clave == null || clave.isEmpty()) {
                return ResponseEntity.status(400).build();
            }

            try {
                Optional<Usuario> usuario = usuarioRepository.findBynombreUsuarioAndClave(nombreUsuario, clave);
                return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(401).build());
            } catch (Exception e) {
                return ResponseEntity.status(500).build(); 
            }
        }
	    


	    
}
