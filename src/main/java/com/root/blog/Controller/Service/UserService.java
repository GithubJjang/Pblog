package com.root.blog.Controller.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.root.blog.Model.User;
import com.root.blog.Repository.UserRepository;


// UserRepository 외 관련된 기능 모음.
@Service
public class UserService {

	// Service에 userRepository를 등록한다.
	@Autowired
	private UserRepository userRepository;
	
	// 회원가입을 하는 기능
	@Transactional
	public void signUp(User user) {
		userRepository.save(user); //User 테이블에 저장이 된다.
	}
	
	// 로그인을 하는 기증
	@Transactional
	public User login(User user) {
		// JPA에서 user를 탐색한다. -> 있으면 반환, 없으면 반환x
		User findUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		return findUser;
	}

}
