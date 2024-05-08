package com.kidwiz.web.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kidwiz.web.DAO.LoginDAO;
import com.kidwiz.web.DTO.LoginDTO;

// 로그인 service 임
// UserDetailsService는 spring security에서 사용자 인증을 위해 사용자 데이터를 로드하는 핵심 인터페이스
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private LoginDAO loginDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	// logindao 로 사용자 정보 조회, spring security 가 사용할 수 있는 userdatails 로 변환
	@Override
	public UserDetails loadUserByUsername(String sid) throws UsernameNotFoundException {
		LoginDTO user = loginDAO.findUserBysid(sid); // 비번은 시큐리티가 알아서 처리해줌
		if (user == null) {
			throw new UsernameNotFoundException("User not found with SID: " + sid);
		}
		return new User(user.getSid(), user.getSpw(),
				Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
	}

}
