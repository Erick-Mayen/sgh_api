package com.sgh.sgh.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.sgh.sgh.Dao.IDaoPaciente;
import com.sgh.sgh.Entity.Paciente;
import com.sgh.sgh.Entity.PersonalMedico;

@RestController
@RequestMapping(value = ("/sgh"))
public class PacienteController {

    @Autowired
    private IDaoPaciente daoPaciente;

    // Obtener todos los pacientes
    @GetMapping(value = "/paciente", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Paciente> getPacientes() {
        return daoPaciente.findAll();
    }

    // Buscar paciente por ID
    @GetMapping(value = "/paciente/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Paciente> getPacienteById(@PathVariable("id") int id) {
        Paciente paciente = daoPaciente.findById(id);
        if (paciente != null) {
            return new ResponseEntity<>(paciente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Agregar nuevo paciente
    @PostMapping(value = "/paciente", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Paciente> agregarPaciente(@RequestBody Paciente paciente) {
        try {
            Paciente nuevoPaciente = daoPaciente.agregarRegistro(paciente);
            return new ResponseEntity<>(nuevoPaciente, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/paciente/{id}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable int id, @RequestBody Paciente paciente) {
        Paciente existente = daoPaciente.findById(id);
        if (existente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // Asegurar que el ID del objeto enviado coincide con el ID de la ruta
        paciente.setId(id);
        Paciente actualizado = daoPaciente.actualizarRegistro(paciente);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }
    
    
}