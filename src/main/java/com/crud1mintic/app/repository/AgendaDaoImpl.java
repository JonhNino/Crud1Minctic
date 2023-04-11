package com.crud1mintic.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crud1mintic.app.entity.Agenda;

@Repository
public class AgendaDaoImpl implements IAgendaDao {
 @PersistenceContext
	private EntityManager em;
	
	
	@Override
	@Transactional
	public void save(Agenda agenda) {
		
		if (agenda.getId() != null && agenda.getId() > 0) {
			em.merge(agenda);
		}else {
			em.persist(agenda);
		}
			
		
	}

	@Override
	@Transactional
	public void delete(Long id) {
		em.remove(findOne(id));
		
	}

	@Override
	@Transactional(readOnly = true)
	public Agenda findOne(Long id) {
		
		
		return em.find(Agenda.class,id);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Agenda> findAll() {
		
		return em.createQuery("from Agenda").getResultList();
	}

}
