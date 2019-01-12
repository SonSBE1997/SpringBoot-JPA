package com.team1;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@ServletComponentScan
@SpringBootApplication
public class Team1SpringBootJpaApplication extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	private DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(Team1SpringBootJpaApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
		http.csrf().disable().authorizeRequests().antMatchers("/","/list-user","/add-user").permitAll().antMatchers("/delete-user/**","/edit-user/**")
				.hasRole("ADMIN").antMatchers("/user/**").hasAnyRole("ADMIN", "USER").antMatchers("/delete-user/**").hasAnyRole("DELETE").anyRequest().authenticated().and()
				.formLogin().loginPage("/login").defaultSuccessUrl("/").failureUrl("/login?e=error").permitAll()
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful").permitAll().and()
				.exceptionHandling().accessDeniedPage("/login?e=deny");

		http.authorizeRequests().and().rememberMe().tokenRepository(this.persistentTokenRepository())
				.tokenValiditySeconds(1 * 24 * 60 * 60);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/image/**", "/fonts/**", "/js/**","/common/**");
	}

	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
		db.setDataSource(dataSource);
		return db;
	}
}

