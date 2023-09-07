package com.root.blog.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserCotroller {

	// 1.회원가입 화면으로 이동
	@GetMapping("/user/joinForm")
	public String joinForm() {
		return "user/joinForm";//WEB-INF/views/까지가 기본주소
	}
	
	// 2. 로그인 화면으로 이동
	@GetMapping("/user/login")
	public String login() {
		return "user/loginForm";
	}
}
