package com.apipagvalmod.blog_api_crud_pag_val_mod1.controller;

import com.apipagvalmod.blog_api_crud_pag_val_mod1.payload.CommentDto;
import com.apipagvalmod.blog_api_crud_pag_val_mod1.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class CommentController {

    private CommentService commentService;
    public CommentController(CommentService commentService){
        this. commentService=commentService;;
    }

    //http://localhost:8080/api/post/2/comments

@PostMapping("/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable("postId") long postId, @RequestBody CommentDto commentDto){
       CommentDto dto= commentService.createComment(postId,commentDto);
       return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/post/2/comments
    @GetMapping("/{postId}/comments")
    public List<CommentDto> findCommentByPostId(@PathVariable("postId") long postId){
        List<CommentDto> dto=commentService.findCommentByPostId(postId);
        return dto;
    }

    //http://localhost:8080/api/post/1/comments/3
    @GetMapping("/{postId}/comments/{id}")
 public ResponseEntity<CommentDto> getCommentById(@PathVariable("postId") long postId,@PathVariable("id") long id){
        CommentDto dto= commentService.getCommentById(postId,id);
       return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    //http://localhost:8080/api/post/2/comments/3
    @DeleteMapping("/{postId}/comments/{id}")
    public ResponseEntity<String> deleteCommentByPostId
    (@PathVariable("postId") long postId,@PathVariable("id") long id){
       commentService.deleteCommentByPostId(postId,id);
      return new ResponseEntity<>("deleted",HttpStatus.OK);
  }

    //http://localhost:8080/api/post/2/comments/1
     @PutMapping("/{postId}/comments/{id}")
   public ResponseEntity<CommentDto> updateComment
    (@PathVariable("postId") long postId,@PathVariable("id") long id,@RequestBody CommentDto commentDto){
       CommentDto dto= commentService.updatePost(postId,id,commentDto);
     return new ResponseEntity<>(dto,HttpStatus.OK);
   }

}
