package com.team1.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.team1.entity.Menu;

public class MenuValidator {
  private Pattern pattern1;
  private Matcher matcher1;
  public static final String regex = "^[A-Za-z-]{3,}$";

  public MenuValidator() {
    pattern1 = Pattern.compile(regex);
  }
  
  public boolean validatorMenu(Menu menu) {
    matcher1 = pattern1.matcher(menu.getName());
    if (!matcher1.matches()) {
      return true;
    }
    return false;
  }
}
