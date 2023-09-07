package com.root.blog.Model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;


@Entity
public class Board {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//auto_increment
	private int id;
	
	@Column(nullable=false,length=100)
	private String title;
	
	@Lob// 대용량 데이터
	private String content;//섬머노트 라이브러리(<html>태그가 섞여서 디자인이 됨.)
	
	@ColumnDefault("0")
	private int count;//조회수
	 
	 //Many는 Board, One은 User. 게시글은 여러개이나, 그 유저는 한명이다.
	@ManyToOne(fetch=FetchType.EAGER)//Board테이블 select시, user정보 하나를 가져온다.
	@JoinColumn(name="userid")// JPA를 사용하면 저장이 가능하다. 필드값은 userid. 그리고 이 필드값에 User의 PK값이 저장이 된다.
	private User user;//DB는 오브젝트를 저장할 수 없다. FK,자바는 오브젝트를 저장할 수 있다.
	
	// 기본은 fetch가 EAGER전략이라서 "무조건" 가져온다.
	// reply는 있으면 가져오고, 없으면 안가져옴. -> LAZY
	@OneToMany(mappedBy="board",fetch=FetchType.EAGER) // 연간관계의 주인이 아님, FK만들지 마라. 주인은 reply에 있는 board이다.
	private List<Reply> reply;// Join 할 필요가 없다. 데이터 요청시 가져오기만 할 뿐임. ArrayList를 사용시 에러가 발생!!!ㄴ
	@CreationTimestamp //insert,update시 현재시간이 삽입
	private Timestamp createDate;
	
	public int getId() {
		return id;
	}


	public List<Reply> getReply() {
		return reply;
	}


	public void setReply(List<Reply> reply) {
		this.reply = reply;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Timestamp getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
}
