package com.root.blog.Model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Reply {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//auto_increment
	private int id;
	
	@Column(nullable=false,length=200)
	private String content;
	
	// 어느 게시글의 답변인가? 연관관계중요
	@ManyToOne// 여러개의 답변(Reply)은 하나의 게시글(Board)과 연결
	@JoinColumn(name="boardId")
	private Board board;
	//해당 게시글에 어떤 댓글이 달렸는지 알기 위해서
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	//user가 어떤 댓글을 달았는지 알기 위해서.
	
	@CreationTimestamp
	private Timestamp createDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
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