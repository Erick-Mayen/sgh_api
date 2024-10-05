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
@Table(name = "bitacora")
public class Bitacora {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;
	public String accion;
	public String descripcion;
	@Column(name = "modulo_id")
	public Integer modulo;
	@Column(name = "usuario_id")
	public Integer usuario;
	public String ip;
	public Date fecha;
}
