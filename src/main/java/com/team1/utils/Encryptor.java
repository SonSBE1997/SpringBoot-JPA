/**
 * Project name: Team1-SpringBoot-JPA
 * Package name: com.team1.utils
 * File name: Encryptor.java
 * Author: Sanero.
 * Created date: Jan 15, 2019
 * Created time: 8:19:25 AM
 */

package com.team1.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * @author Sanero.
 * Created date: Jan 15, 2019
 * Created time: 8:19:25 AM
 * Description: TODO - 
 */
public class Encryptor {
  /**
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 8:19:51 AM
   * Description: TODO - .
   * @param input - string wanna encrypt.
   * @return
   */
  public static String getMd5(String input) {
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");

      byte[] messageDigest = md.digest(input.getBytes());

      BigInteger no = new BigInteger(1, messageDigest);

      String hashtext = no.toString(16);
      while (hashtext.length() < 32) {
        hashtext = "0" + hashtext;
      }
      return hashtext;
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }
}
