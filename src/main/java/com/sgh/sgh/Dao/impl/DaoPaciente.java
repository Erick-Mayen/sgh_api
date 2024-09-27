package com.sgh.sgh.Dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.sgh.sgh.Dao.IDaoPaciente;
import com.sgh.sgh.Entity.Paciente;
import com.sgh.sgh.Entity.PersonalMedico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class DaoPaciente implements IDaoPaciente {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Paciente> findAll() {
        return em.createQuery("FROM Paciente", Paciente.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Paciente findById(int id) {
        return em.find(Paciente.class, id);
    }

    @Override
    @Transactional
    public Paciente agregarRegistro(Paciente paciente) {
        em.persist(paciente);  // Insertar un nuevo registro
        return paciente;
    }
    
    @Override
    @Transactional
    public Paciente actualizarRegistro(Paciente paciente) {
        return em.merge(paciente);
    }

	@Override
	public void eliminarRegistro(int id) {
		// TODO Auto-generated method stub
		
	}

}