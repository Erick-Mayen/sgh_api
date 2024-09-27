package com.sgh.sgh.Entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="paciente")
public class Paciente {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 45)
    private String apellido;

    @Column(name = "genero", nullable = false, length = 45)
    private String genero;

    @Column(name = "dpi", length = 13)
    private String dpi;

    @Column(name = "correo", length = 45)
    private String correo;

    @Column(name = "estado", length = 50)
    private String estado;

    @Column(name = "telefono", length = 8)
    private String telefono;

    @Column(name = "direccion", columnDefinition = "TEXT")
    private String direccion;

    @Column(name = "fecha_registro", nullable = false)
    private Date fechaRegistro;

    @Column(name = "usuario_creacion")
    private Integer usuarioCreacion;

    @Column(name = "fecha_creacion", nullable = false)
    private Date fechaCreacion;

    @Column(name = "usuario_modificacion")
    private Integer usuarioModificacion; // Puede ser nulo

    @Column(name = "fecha_modificacion")
    private Date fechaModificacion; // Puede ser nula
	
}