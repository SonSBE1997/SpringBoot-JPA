package com.team1.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team1.entity.Role;
import com.team1.repository.RoleRepository;

/*
 * @author Hai95.
 * Created date: Jan 11, 2019
 * Created time: 8:49:43 AM
 * Description: TODO - 
 */

@Service
@Transactional
public class RoleService {
	
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	EntityManager entityManager;
	
	
	public List<Role> getAll() {
		return roleRepository.findAll();
	}
	
	public Role getOne(int id) {
		return entityManager.find(Role.class, id);
	}
	
	public void insert(Role role) {
		entityManager.persist(role);
	}
	
	public void update(Role role) {
		entityManager.merge(role);
	}
	
	public void delete(int id) {
		roleRepository.deleteById(id);
	}
}
