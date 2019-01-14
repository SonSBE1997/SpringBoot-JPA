package com.team1.service.impl;

import com.team1.entity.User;
import com.team1.repository.UserRepository;
import com.team1.service.UserService;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginServiceImpl implements UserDetailsService {
  @Autowired
  UserRepository userRepository;
  @Autowired
  UserService userService;

  @Override
  public UserDetails loadUserByUsername(String email)
      throws UsernameNotFoundException {
    User user = userRepository.findByEmail(email);
    if (user == null) {
      throw new UsernameNotFoundException("not user");
    }

    List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
    List<String> roleNames = userService.getRoleName(user.getUserId());
    if (roleNames != null) {
      for (String role : roleNames) {
        authorities.add(new SimpleGrantedAuthority(role));
        System.out.println(role);
      }
    }

    UserDetails details = new org.springframework.security.core.userdetails.User(
        email, user.getPassword(), authorities);

    return details;
  }
}
