package com.team1.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team1.entity.Menu;
import com.team1.entity.MenuRole;
import com.team1.repository.MenuRoleRepository;

@Service
@Transactional
public class MenuRoleService {
	
	@Autowired
	MenuRoleRepository menuRoleRepository;
	
	@Autowired
	EntityManager entityManager;
	
	public List<MenuRole> getAll() {
		return menuRoleRepository.findAll();
	}
	
	public MenuRole getOne(Menu menu) {
		return menuRoleRepository.findByMenuId(menu);
	}

	public void insert(MenuRole menuRole) {
		entityManager.persist(menuRole);
	}
	
	public void update(MenuRole menuRole) {
		entityManager.merge(menuRole);
	}
	
	public void delete(int id) {
		menuRoleRepository.deleteById(id);
	}
	
	public List<MenuRole> filterStatus(String stus) {
		return menuRoleRepository.findByStatus(stus);
	}
}
