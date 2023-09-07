package com.root.blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.root.blog.Model.Board;

// 스프링 빈에 등록
public interface BoardRepository extends JpaRepository<Board, Integer>  {

}
