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
    public static final int PAGE_SIZE = 1;
    public static final String QUERY_FILTER = "from news where title like :filter1 "
        + "or url like :filter2 or content like :filter3 "
        + "or description like :filter4 or status  like :filter5";
  }
}
