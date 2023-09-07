package com.root.blog.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.root.blog.Controller.Service.BoardService;
import com.root.blog.Controller.Service.ReplyService;
import com.root.blog.Model.Board;
import com.root.blog.Model.Reply;

import org.springframework.data.domain.Sort;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private ReplyService replyService;
	
	// 1.인덱스 화면으로 이동
	@GetMapping("/")
	public String Home(Model model, @PageableDefault(size=3,sort="id",direction=Sort.Direction.DESC) Pageable pageable) {
		Page<Board> pages = boardService.boardList(pageable);
		model.addAttribute("boards", pages);// model에 담아서 Boardlist를 보낸다.
		return "index";
	}

	@GetMapping("/board/write")
	// 2. 글쓰기 페이지 불러오기
	public String boardWrite() {
		return "board/boardwrite";
	}
	
	// 3. 로그아웃시 "/"로 이동
	@GetMapping("/user/logout")
	public String logout(HttpServletRequest request,Model model, @PageableDefault(size=3,sort="id",direction=Sort.Direction.DESC) Pageable pageable) {
		HttpSession getSession = request.getSession();
		getSession.invalidate();// 생성된 세션을 만료시킨다.
		Page<Board> pages = boardService.boardList(pageable);
		model.addAttribute("boards", pages);// model에 담아서 Boardlist를 보낸다.
		// 등록된 세션을 해제한다.
		return "index";
	}
	
	// 4. 글 상세보기 API url.
	// http url을 통해서 해당 자원을 명시 + 해당 자원을 통해서 CRUD
	// URL변수 {id}는 @PathVariable을 이용해서 받는다.
	
	@GetMapping("/board/{id}")
	public String boardDetail(Model model,@PathVariable int id,@PageableDefault(sort="createDate",direction=Sort.Direction.DESC) Pageable pageable) {
		//System.out.println("id:"+id);// id는 Board의 PK
		Board getBoard = boardService.boardDetail(id);
		Page<Reply> getReply = replyService.getBoardreply(id,pageable);
		model.addAttribute("board",getBoard);
		model.addAttribute("reply",getReply);
		return "board/detail";
		
	}
	
	// 5. 글 수정하기
	@GetMapping("/board/update/{id}") // 수정해야함 REST API가 아님.
	public String boardUpdate(@PathVariable int id,Model model) {
		// id에 해당하는 board를 가져온 후, 뿌린다.
		Board getBoard = boardService.boardDetail(id);
		model.addAttribute("board", getBoard);
		return "board/update";
	}
	
}
