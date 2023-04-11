package com.crud1mintic.app.repository;

import java.util.List;

import com.crud1mintic.app.entity.*;



public interface IAgendaDao  {

	public void save(Agenda agenda);
	
	public void delete(Long id);
	
	public Agenda findOne(Long id);
	
	public List<Agenda> findAll();
	
	
}
