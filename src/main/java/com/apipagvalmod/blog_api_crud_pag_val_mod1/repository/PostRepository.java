package com.apipagvalmod.blog_api_crud_pag_val_mod1.repository;

import com.apipagvalmod.blog_api_crud_pag_val_mod1.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
