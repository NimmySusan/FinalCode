package com.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter
{
	@Bean
	@Override
	protected UserDetailsService userDetailsService()
	{
	List<UserDetails> user=new ArrayList<>();
	user.add(User.withDefaultPasswordEncoder().username("Nimmy").password("Nimmy@123").roles("USER").build());
	user.add(User.withDefaultPasswordEncoder().username("Pooja").password("Pooja@123").roles("USER").build());
	user.add(User.withDefaultPasswordEncoder().username("Malavika").password("Malavika@123").roles("USER").build());
	user.add(User.withDefaultPasswordEncoder().username("Lakshmi Durga").password("durga@123").roles("USER").build());
	return new InMemoryUserDetailsManager(user);
	}
}

