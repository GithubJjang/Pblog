package com.root.blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.root.blog.Model.User;

// 자동으로 스프링 빈에 등록이 된다.
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByUsernameAndPassword(String username,String password);
	
}
