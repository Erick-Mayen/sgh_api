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
	public String nombreUsuario;
	
	@Column(name = "correo_electronico")
	public String correo_electronico;
	
	@Column(name = "clave")
	public String clave;
	
	@Column(name = "activo")
	public Integer activo;
	
	@Column(name = "rol_id")
	public Integer rol_id;
	
	@Column(name = "usuario_creador")
	public Integer usuario_creador;
	
	@Column(name = "fecha_creacion")
	public Date fecha_creacion;
	
	@Column(name = "usuario_modificacion")
	public Integer usuario_modificacion;
	
	@Column(name = "fecha_modificacion")
	public Date fecha_modificacion;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre_usuario() {
		return nombreUsuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombreUsuario = nombre_usuario;
	}
	public String getCorreo_electronico() {
		return correo_electronico;
	}
	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	public int getRol_id() {
		return rol_id;
	}
	public void setRol_id(int rol_id) {
		this.rol_id = rol_id;
	}
	public int getUsuario_creador() {
		return usuario_creador;
	}
	public void setUsuario_creador(int usuario_creador) {
		this.usuario_creador = usuario_creador;
	}
	public Date getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public int getUsuario_modificacion() {
		return usuario_modificacion;
	}
	public void setUsuario_modificacion(int usuario_modificacion) {
		this.usuario_modificacion = usuario_modificacion;
	}
	public Date getFecha_modificacion() {
		return fecha_modificacion;
	}
	public void setFecha_modificacion(Date fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}
	
	

}
