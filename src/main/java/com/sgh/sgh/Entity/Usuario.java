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
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer id;

	@Column(name = "nombre_usuario")
	public String nombre_usuario;

	@Column(name = "correo_electronico")
	public String correo_electronico;

	@Column(name = "clave")
	public String clave;

	@Column(name = "activo")
	public Integer activo;

	@Column(name = "rol_id")
	public Integer rol_id;

	@Column(name = "usuario_creador", nullable = true)
	public Integer usuario_creador;

	@Column(name = "fecha_creacion", nullable = true)
	public Date fecha_creacion;

	@Column(name = "usuario_modificacion", nullable = true)
	public Integer usuario_modificacion;

	@Column(name = "fecha_modificacion", nullable = true)
	public Date fecha_modificacion;

}
