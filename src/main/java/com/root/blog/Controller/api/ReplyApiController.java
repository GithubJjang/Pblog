package com.root.blog.Controller.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.root.blog.Controller.Service.BoardService;
import com.root.blog.Controller.Service.ReplyService;
import com.root.blog.Model.Board;
import com.root.blog.Model.Reply;
import com.root.blog.Model.User;


@RestController
public class ReplyApiController {
	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private BoardService boardService;
	//Ajax로 수정
	// $.ajax({ url: }) 반환을 자바스크립트.
	@PostMapping("/api/reply/save")
	public void saveReply(@RequestBody Reply getreply,HttpServletRequest request) {
		int boardId = getreply.getId();
		
		Board findBoard = boardService.boardDetail(boardId);
		HttpSession getSession = request.getSession();
		User findUser = (User)getSession.getAttribute("principal");
		
		Reply reply = new Reply();
		reply.setContent(getreply.getContent());
		reply.setUser(findUser);
		reply.setBoard(findBoard);
		
		replyService.saveReply(reply);
		
	}
	
	
}
