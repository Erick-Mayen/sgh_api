package com.sgh.sgh.Dao;

import java.util.List;
import com.sgh.sgh.Entity.Paciente;
public interface IDaoPaciente {
	
	 List<Paciente>findAll();
	 public Paciente findById(int id) ;
	 public Paciente agregarRegistro(Paciente paciente);
	 public Paciente actualizarRegistro(Paciente paciente);
	 void eliminarRegistro(int id);


}