package com.team1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@ServletComponentScan
@SpringBootApplication
@EnableWebSecurity
public class Team1SpringBootJpaApplication
    extends WebSecurityConfigurerAdapter {
  @Autowired
  UserDetailsService userDetailsService;
  @Autowired
  BCryptPasswordEncoder passwordEncoder;

  public static void main(String[] args) {
    SpringApplication.run(Team1SpringBootJpaApplication.class, args);
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  /* (non-Javadoc)
   * @see org.springframework.security.config.annotation.web.configuration
   *  .WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation
   *  .authentication.builders.AuthenticationManagerBuilder)
   * Author: Sanero.
   * Created date: Jan 14, 2019
   * Created time: 2:54:52 PM
   */
  @Autowired
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService)
        .passwordEncoder(passwordEncoder);

  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
    http.csrf().disable().authorizeRequests()
        .antMatchers("/", "/admin/add-user/**").permitAll()
        .antMatchers("/admin/**").hasRole("ADMIN").antMatchers("/user/**")
        .hasAnyRole("ADMIN", "USER").anyRequest().authenticated().and()
        .formLogin().loginPage("/login").defaultSuccessUrl("/")
        .failureUrl("/login?e=error").permitAll().and().logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .logoutSuccessUrl("/login").and().exceptionHandling()
        .accessDeniedPage("/login?e=deny");

  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/css/**", "/image/**", "/fonts/**", "/js/**",
        "/common/**", "/user/**");
  }
}
