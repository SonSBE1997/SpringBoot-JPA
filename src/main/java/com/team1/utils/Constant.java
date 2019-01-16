/**
 * Project name: News
 * Package name: dev.sanero.utils
 * File name: Constant.java
 * Author: Sanero.
 * Created date: Jan 10, 2019
 * Created time: 2:15:32 PM
 */

package com.team1.utils;

/*
 * @author Sanero.
 * Created date: Jan 10, 2019
 * Created time: 2:15:32 PM
 * Description: TODO - interface for constant purpose.
 */
public interface Constant {
  /*
   * @author Sanero.
   * Created date: Jan 14, 2019
   * Created time: 2:17:43 PM
   * Description: TODO - constant for news.
   */
  interface News {
    public static final int PAGE_SIZE = 2;
    public static final String QUERY_FILTER = "from news where title like :filter1 "
        + "or url like :filter2 or content like :filter3 "
        + "or description like :filter4 or status  like :filter5";
  }

  interface Menu_URL {
    public static final String URL_ADD_MENU = "/add-menu";
    public static final String URL_UPDATE_MENU = "/update-menu";
    public static final String URL_DELETE_MENU = "/delete-menu";
    public static final String URL_DETAIL_MENU = "/detail-menu";
    public static final String URL_LIST_MENU = "/list-menu";
  }

  interface Role_URL {
    public static final String URL_ADD_ROLE = "/add-role";
    public static final String URL_UPDATE_ROLE = "/update-role";
    public static final String URL_DELETE_ROLE = "/delete-role";
    public static final String URL_DETAIL_ROLE = "/detail-role";
    public static final String URL_LIST_ROLE = "/list-role";
  }

  interface MenuRole_URL {
    public static final String URL_ADD_MENUROLE = "/add-menuRole";
    public static final String URL_UPDATE_MENUROLE = "/update-menuRole";
    public static final String URL_DELETE_MENUROLE = "/delete-menuRole";
    public static final String URL_DETAIL_MENUROLE = "/detail-menuRole";
    public static final String URL_LIST_MENUROLE = "/list-menuRole";
  }
}
