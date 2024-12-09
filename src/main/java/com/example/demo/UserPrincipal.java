package com.example.demo;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails {

	@Autowired
	private Person p;

     public UserPrincipal(Person p){
		this.p=p;
	 }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO: Implement this method
		return Collections.singleton(new SimpleGrantedAuthority("User"));
	}

	@Override
	public String getPassword() {
		// TODO: Implement this method
		return p.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO: Implement this method
		return p.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO: Implement this method
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO: Implement this method
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO: Implement this method
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO: Implement this method
		return true;
	}
}
