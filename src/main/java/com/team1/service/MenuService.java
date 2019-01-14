package com.team1.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team1.entity.Menu;
import com.team1.repository.MenuRepository;

@Service
@Transactional
public class MenuService {
	
	@Autowired
	MenuRepository menuRepository;
	
	@Autowired
	EntityManager entityManager;
	
	public List<Menu> getAll() {
		return menuRepository.findAll();
	}
	
	public Menu getOne(int id) {
		return entityManager.find(Menu.class, id);
	}
	
	public void insert(Menu menu) {
		entityManager.persist(menu);
	}
	
	public void update(Menu menu) {
		entityManager.merge(menu);
	}
	
	public void delete(int id) {
		menuRepository.deleteById(id);
	}
	
	public List<Menu> filterName(String name) {
		return menuRepository.findByName(name);
	}
}
