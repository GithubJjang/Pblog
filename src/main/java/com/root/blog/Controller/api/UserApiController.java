package com.root.blog.Controller.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.root.blog.Controller.Service.UserService;
import com.root.blog.Model.Roletype;
import com.root.blog.Model.User;



@RestController
public class UserApiController {
	@Autowired
	private UserService userService;
	
	// 1. 회원가입
	@PostMapping("/user/joinProc")
	public void getJoindata(@RequestBody User user) {
		user.setRole(Roletype.User);
		userService.signUp(user);
	}
	
	// 2. 로그인
	@PostMapping("/user/loginProc")
	public void getLogindata(@RequestBody User user,HttpServletRequest request) {
		// 일치하는 데이터를 찾으면 세션을 생성해서 반환을 한다.
		User getUser = userService.login(user);
		System.out.println(getUser.getUsername());// NullPointException을 의도
		// 세션을 만들어서 "index"와 함께 이동을 한다.
		HttpSession session = request.getSession();
		session.setAttribute("principal", getUser);
		
	}
}
