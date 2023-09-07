package com.root.blog.Controller.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.root.blog.Controller.Service.BoardService;

import com.root.blog.Model.Board;
import com.root.blog.Model.User;



@RestController
public class BoardApiController {

	@Autowired
	private BoardService boardService;
	
	// 1. 새로운 글 등록하기
	@PostMapping("/api/board")
	public void saveForm(@RequestBody Board board, HttpServletRequest request) {
		HttpSession session = request.getSession();
		//
		User user = (User)session.getAttribute("principal");
		board.setCount(0);
		board.setUser(user);
		// DB에 데이터를 집어넣는다.
		boardService.saveForm(board);
	
	}
	
	// 2. 글 수정하기
	@PostMapping("/api/board/update")
	public void updateBoard(@RequestBody Board board) {
		boardService.boardUpdate(board);// 내가 수정한 Board를 넘긴다.
	}
	
	// 3. 글 삭제하기
	@PostMapping("/api/board/delete/{id}")
	public void deleteBoard(@PathVariable int id) {
		boardService.boardDelete(id);// board의 PK를 이용해서 삭제를 한다.
	}
}
