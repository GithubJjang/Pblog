package com.root.blog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.root.blog.Controller.Service.BoardService;
import com.root.blog.Controller.Service.ReplyService;
import com.root.blog.Model.Board;
import com.root.blog.Model.Reply;

@Controller
public class ReplyController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private ReplyService replyService;
	
	@GetMapping("board/{id}/Id")
	public String replyById(Model model,@PathVariable int id,@PageableDefault(sort="userId",direction=Sort.Direction.ASC) Pageable pageable) {
		//System.out.println("id:"+id);// id는 Board의 PK
		Board getBoard = boardService.boardDetail(id);
		Page<Reply> getReply = replyService.getBoardreply(id,pageable);
		model.addAttribute("board",getBoard);
		model.addAttribute("reply", getReply);
		return "board/detail";
		
	}
}
