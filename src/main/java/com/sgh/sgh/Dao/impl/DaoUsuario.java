package com.sgh.sgh.Dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sgh.sgh.Dao.IDaoUsuario;
import com.sgh.sgh.Entity.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class DaoUsuario implements IDaoUsuario {
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public List<Usuario> listar() {
		TypedQuery<Usuario> query = em.createQuery("from Usuario", Usuario.class);

		try {
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public Usuario obtenerPorCorreo(String correo) {
		TypedQuery<Usuario> query = em.createQuery("from Usuario where correo_electronico = :correo", Usuario.class);
		query.setParameter("correo", correo);

		try {
			List<Usuario> resultados = query.getResultList();
		    return resultados.isEmpty() ? null : resultados.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	@Transactional
	public Usuario crear(Usuario usuario) {
		try {
			em.persist(usuario);
			return usuario;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public Usuario actualizar(Usuario usuario) {
		try {
			em.merge(usuario);
			return usuario;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
