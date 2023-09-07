package com.root.blog.Controller.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.root.blog.Model.Reply;

import com.root.blog.Repository.ReplyRespository;

@Service
public class ReplyService {
		
	@Autowired
	private ReplyRespository replyRespository;
	
	// 1. 댓글 등록하기
	@Transactional
	public void saveReply(Reply reply) {
		replyRespository.save(reply);
	}
	
	// 2. 해당 게시글과 관련된 모든 댓글 가져오기
	@Transactional
	public Page<Reply> getBoardreply(int boardId,Pageable pageable) {
		Page<Reply> allReply = replyRespository.findByboardId(boardId,pageable);
		return allReply;
	}
}
