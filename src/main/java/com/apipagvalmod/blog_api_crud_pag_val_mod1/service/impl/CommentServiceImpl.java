package com.apipagvalmod.blog_api_crud_pag_val_mod1.service.impl;

import com.apipagvalmod.blog_api_crud_pag_val_mod1.entity.Comment;
import com.apipagvalmod.blog_api_crud_pag_val_mod1.entity.Post;
import com.apipagvalmod.blog_api_crud_pag_val_mod1.exceptions.PostNotFoundException;
import com.apipagvalmod.blog_api_crud_pag_val_mod1.payload.CommentDto;
import com.apipagvalmod.blog_api_crud_pag_val_mod1.repository.CommentRepository;
import com.apipagvalmod.blog_api_crud_pag_val_mod1.repository.PostRepository;
import com.apipagvalmod.blog_api_crud_pag_val_mod1.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepo;


    private PostRepository postRepo;

    public CommentServiceImpl(CommentRepository commentRepo,PostRepository postRepo){
        this.commentRepo=commentRepo;
        this.postRepo=postRepo;
    }

    CommentDto mapToDto(Comment comment){
        CommentDto dto=new CommentDto();
        dto.setId(comment.getId());
        dto.setName(comment.getName());
        dto.setBody(comment.getBody());
        dto.setEmail(comment.getEmail());
        return dto;
    }




    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
        Post post=postRepo.findById(postId).orElseThrow(()->new PostNotFoundException(postId));
      Comment comment=new Comment();
        comment.setName(commentDto.getName());
        comment.setBody(commentDto.getBody());
        comment.setEmail(commentDto.getEmail());
        comment.setPost(post);
        Comment commentSaved=commentRepo.save(comment);
       CommentDto dto= mapToDto(commentSaved);
      return dto;


    }

    @Override
    public List<CommentDto> findCommentByPostId(long postId) {
        Post post=postRepo.findById(postId).orElseThrow(()->new PostNotFoundException(postId));
        List<Comment> byPostId = commentRepo.findByPostId(postId);
        List<CommentDto> collect = byPostId.stream().map(x -> mapToDto(x)).collect(Collectors.toList());

        return collect;
    }

    @Override
    public CommentDto getCommentById(long postId, long id) {
        Post post=postRepo.findById(postId).orElseThrow(()->new PostNotFoundException(postId));
        Comment comment = commentRepo.findById(id).orElseThrow(() -> new PostNotFoundException(id));
        CommentDto dto=mapToDto(comment);
        return dto;
    }


    @Override
    public void deleteCommentByPostId(long id, long postId) {
        Post post=postRepo.findById(postId).orElseThrow(()->new PostNotFoundException(postId));
        Comment comment = commentRepo.findById(id).orElseThrow(() -> new PostNotFoundException(id));
        commentRepo.deleteById(id);
    }

    @Override
    public CommentDto updatePost(long postId,long id, CommentDto commentDto) {
        Post post=postRepo.findById(postId).orElseThrow(()->new PostNotFoundException(postId));
        Comment comment = commentRepo.findById(id).orElseThrow(() -> new PostNotFoundException(id));


        comment.setName(commentDto.getName());
        comment.setBody(commentDto.getBody());
        comment.setEmail(commentDto.getEmail());
        Comment commentSaved=commentRepo.save(comment);
        CommentDto dto= mapToDto(commentSaved);

        return dto;
    }
}
