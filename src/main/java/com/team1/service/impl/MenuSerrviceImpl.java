/*package com.team1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team1.entity.Menu;
import com.team1.repository.MenuRepository;
import com.team1.service.MenuService;
@Service
@Transactional
public class MenuSerrviceImpl implements MenuService {
    @Autowired
    MenuRepository menuRepository;
	@Override
	public List<Menu> fillAll() {
		return menuRepository.findAll();
	}

}
*/