package com.framgia.service;


import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.framgia.model.User;
import com.framgia.model.UserRole;

public class UserDetailServiceImpl extends BaseService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {   
		User user = userDAO.findByUserName(username);
		if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		for (UserRole userRole : user.getUserRoles()) {
			if(userRole != null){
				grantedAuthorities.add(new SimpleGrantedAuthority(userRole.getRole()));
			}
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
	}

}
