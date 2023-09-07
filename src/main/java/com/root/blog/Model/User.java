package com.root.blog.Model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;


@Entity// User클래스가 MySQL에 테이블이 생성이 된다

public class User {
	// User의 정보를 담고 있음. id(auto_increment) ,username ,password ,email ,createDate
	@Id//Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)//프로젝트(blog)에 연결된 DB의 넘버링 전략을 따라간다.
	private int id;// 시퀀스, auto_increment, 비워놓는다.

	@	Column(unique = true, nullable = false, length = 30)// unique를 true로 설정을 해서 중복되는 값이 발생하면, 에러를 띄운다.
	private String username;//아이디
	  
	@	Column(nullable = false, length = 100)
	private String password;// 패스워드를 해쉬로 변경해서 암호화 시킬 예정.
	
	@	Column(nullable = false, length = 50)
	private String email;
	

	@Enumerated(EnumType.STRING)
	private Roletype role;//Enum을 쓰는게 좋다. -> 도메인(어떤범위가 정해짐)설정 (admin,user,manager등급으로 분류해서 권한부여)
	
	@CreationTimestamp //시간이 자동으로 입력, 비워놓는다.
	private Timestamp createDate; //Java에서 현재시간을 알아서 넣어준다.
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Roletype getRole() {
		return role;
	}

	public void setRole(Roletype role) {
		this.role = role;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

}
