package com.team1.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Project name: Team1-SpringBoot-JPA
 * Package name: com.team1.controller
 * File name: ABCZ.java
 * Author: ...Hai95
 * Created date: Jan 11, 2019
 * Created time: 8:49:43 AM
 */
public class Validation {
	private Pattern pattern1;  //... pattern2, pattern3;
	private Matcher matcher1;  //... matcher2, matcher3;
	
	public static final String Role_Name = "^[A-Za-z-]{0,}$";
//	public static final String Email = "^[A-Za-z0-9+_.-]+@(.+)$";
//	public static final String Phone = "^\\d{7,}$";
//	public static final String BirthDate = "^\\d{4}-\\d{2}-\\d{2}$";
	
	public Validation() {
		pattern1 = Pattern.compile(Role_Name);
//		pattern2 = Pattern.compile(Phone);
//		pattern3 = Pattern.compile(BirthDate);
	}
	
	/**
	 * Create by: Hai - CMC
	 * Create date: Jan 12, 2019
	 * Modifier: Hai
	 * Modified date: 2019
	 * Description: ....
	 * Version 1.0
	 */
	public boolean validateRolename(final String s) {
		matcher1 = pattern1.matcher(s);
		return matcher1.matches();
	}
	
//	/**
//	 * Create by: Hai - CMC
//	 * Create date: Jan 12, 2019
//	 * Modifier: Hai
//	 * Modified date: 2019
//	 * Description: ....
//	 * Version 1.0
//	 */
//	public boolean validateEmail(final String s) {
//		matcher1 = pattern1.matcher(s);
//		return matcher1.matches();
//	}
//	
//	/**
//	 * Create by: Hai - CMC
//	 * Create date: Jan 12, 2019
//	 * Modifier: Hai
//	 * Modified date: 2019
//	 * Description: ....
//	 * Version 1.0
//	 */
//	public boolean validatePhone(final String s) {
//		matcher2 = pattern2.matcher(s);
//		return matcher2.matches();
//	}
//	
//	/**
//	 * Create by: Hai - CMC
//	 * Create date: Jan 12, 2019
//	 * Modifier: Hai
//	 * Modified date: 2019
//	 * Description: ....
//	 * Version 1.0
//	 */
//	public boolean validateBirthDate(final String s) {
//		matcher3 = pattern3.matcher(s);
//		return matcher3.matches();
//	}
	
}