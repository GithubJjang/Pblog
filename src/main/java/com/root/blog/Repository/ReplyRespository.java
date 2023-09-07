package com.root.blog.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.root.blog.Model.Reply;


public interface ReplyRespository extends JpaRepository<Reply, Integer> {

	Page<Reply> findByboardId(Integer boardId,Pageable pageable);
}
