package com.apipagvalmod.blog_api_crud_pag_val_mod1.service;

import com.apipagvalmod.blog_api_crud_pag_val_mod1.payload.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);
    List<CommentDto> findCommentByPostId(long postId);
CommentDto getCommentById(long postId,long id);
    public void deleteCommentByPostId(long id,long postId);
    public CommentDto updatePost(long postId,long id,CommentDto commentDto);
}
