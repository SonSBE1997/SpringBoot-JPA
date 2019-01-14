package com.team1.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team1.entity.Menu;
import com.team1.repository.MenuRepository;

/*
 * @author Hung.
 * Created date: Jan 11, 2019
 * Created time: 10:39:19 AM
 * Description: handle menu service
 */
@Service
@Transactional
public class MenuService {
  @Autowired
  MenuRepository menuResposiory;
  @Autowired
  private EntityManager entityManager;
  /**
   * Author: Hung.
   * Created date: Jan 11, 2019
   * Created time: 10:42:37 AM
   * Description: return all info menu
   * @return List<Menu>
   */
  public List<Menu> getListAllMenu() {
    return menuResposiory.findAll();
  }

  /**
   * Author: Hung.
   * Created date: Jan 11, 2019
   * Created time: 10:51:40 AM
   * Description: return  info menu by menuid
   * @param menuID
   * @return Menu
   */
  public Menu findMenuByID(int menuID) {
    return menuResposiory.getOne(menuID);
  }

  /**
   * Author: Hung.
   * Created date: Jan 11, 2019
   * Created time: 11:00:39 AM
   * Description: delete menu by id
   * @param menuID
   * @return
   */
  public boolean deleteMenuByID(int menuID) {
    boolean isSuccess = false;

    Menu menu = menuResposiory.getOne(menuID);
    try {
      menuResposiory.delete(menu);
      isSuccess = true;
    } catch (Exception e) {
      isSuccess = false;
    }
    return isSuccess;
  }

  /**
   * Author: Hung.
   * Created date: Jan 11, 2019
   * Created time: 10:56:05 AM
   * Description: insert one menu
   * @param menu
   * @return
   */
  public boolean insertMenu(Menu menu) {
    boolean isSuccess = false;

    Menu insertedMenu = menuResposiory.save(menu);

    if (insertedMenu != null) {
      isSuccess = true;
    } else {
      isSuccess = false;
    }
    return isSuccess;
  }

  /**
   * Author: Hung.
   * Created date: Jan 11, 2019
   * Created time: 11:03:00 AM
   * Description: TODO - .
   * @param menu
   * @return
   */
  public void updateMenu(Menu menu) {
    entityManager.merge(menu);
  }
  
  
 /**
 * Author: Hung.
 * Created date: Jan 14, 2019
 * Created time: 11:22:04 AM
 * Description: TODO - .
 * @param Name
 * @return
 */
public List<Menu> findNameContaining(String Name){
    return  menuResposiory.findByNameContaining(Name);
  }
}
