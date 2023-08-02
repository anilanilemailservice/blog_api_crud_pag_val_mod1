package com.apipagvalmod.blog_api_crud_pag_val_mod1.service;

import com.apipagvalmod.blog_api_crud_pag_val_mod1.payload.PostDTO;

import java.util.List;

public interface PostService {
    public PostDTO createNewPost(PostDTO postDto);

    PostDTO findByPostId(long id);


    List<PostDTO> findAllPosts();

    void deletePostById(long id);

    PostDTO updatePost(long id, PostDTO postDTO);
}
