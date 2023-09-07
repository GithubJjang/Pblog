package com.root.blog.Controller.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.root.blog.Model.Board;
import com.root.blog.Repository.BoardRepository;

@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;
	
	// 1. 새로운 글등록
	@Transactional
	public void saveForm(Board board) {
		boardRepository.save(board);
	}
	
	// 2. BoardService에서 Board목록들 한번에 가져온다 -> Controller에서 페이지네이션해서 보여준다.
	@Transactional
	public Page<Board> boardList(Pageable pageable){
		return boardRepository.findAll(pageable);
	}
	
	// 3. 해당 board에 대한 정보를 반환한다.
	@Transactional
	public Board boardDetail(int id) {
		Optional<Board> findBoard = boardRepository.findById(id);// BoardRepository에서 발견못하는 경우 -> null이 발생한다.
		Board returnBoard = findBoard.get();// 만약 해당 데이터를 못찾은 경우 NoSuchElementException이 발생
		return returnBoard;
		
	}
	
	// 4. 기존 글 업데이트하기(Dirty-Checking)
	@Transactional
	public void boardUpdate(Board board) {
		Optional<Board> findBoard = boardRepository.findById(board.getId());// BoardRepository에서 발견못하는 경우 -> null이 발생한다.
		Board returnBoard = findBoard.get();// 만약 해당 데이터를 못찾은 경우 NoSuchElementException이 발생
		if(!board.getTitle().equals("")) {
			returnBoard.setTitle(board.getTitle());
		}
		if(!board.getContent().equals("")) {
			returnBoard.setContent(board.getContent());
		}
	}
	
	// 5. 글 삭제하기
	@Transactional
	public void boardDelete(int id) {
		boardRepository.deleteById(id);
	}
}
