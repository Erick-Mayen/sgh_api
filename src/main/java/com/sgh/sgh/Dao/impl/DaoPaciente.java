package com.sgh.sgh.Dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.sgh.sgh.Dao.IDaoPaciente;
import com.sgh.sgh.Entity.Paciente;
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

}