package com.apipagvalmod.blog_api_crud_pag_val_mod1.repository;

import com.apipagvalmod.blog_api_crud_pag_val_mod1.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    public List<Comment> findByPostId(long id);
}
