package com.sgh.sgh.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sgh.sgh.Dao.IDaoUsuario;
import com.sgh.sgh.Entity.Usuario;


@RestController
@RequestMapping("/sgh")
public class UsuarioController {

	@Autowired
	private IDaoUsuario usuarioDao;

	@GetMapping("/usuario")
	public List<Usuario> listar() {
		return usuarioDao.listar();
	}

	@GetMapping("/usuario/obtener")
	public Usuario obtenerPorNombreYClave(@RequestParam String correo) {
		return usuarioDao.obtenerPorCorreo(correo);
	}

	@PostMapping("/usuario")
	public ResponseEntity<String> crear(@RequestBody Usuario usuario) {
		usuarioDao.crear(usuario);
		return ResponseEntity.ok("Usuario creado exitosamente");
	}

	@PutMapping("/usuario")
	public ResponseEntity<String> actualizar(@RequestBody Usuario usuario) {
		usuarioDao.actualizar(usuario);
		return ResponseEntity.ok("Usuario actualizado exitosamente");
	}
}