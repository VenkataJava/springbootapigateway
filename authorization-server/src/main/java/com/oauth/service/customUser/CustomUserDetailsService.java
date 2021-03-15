package com.oauth.service.customUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.oauth.service.repository.AccountRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return accountRepository.findByUsername(userName)
				.map(account -> new User(account.getUsername(), passwordEncoder.encode(account.getPassworkd()), true,
						true, true, true, AuthorityUtils.createAuthorityList("write", "read")))
				.orElseThrow(() -> new UsernameNotFoundException("UserName donesn't exist"));
	}

}
