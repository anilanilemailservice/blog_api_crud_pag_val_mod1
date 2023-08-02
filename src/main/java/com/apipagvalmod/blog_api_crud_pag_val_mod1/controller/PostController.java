package com.apipagvalmod.blog_api_crud_pag_val_mod1.controller;

import com.apipagvalmod.blog_api_crud_pag_val_mod1.payload.PostDTO;
import com.apipagvalmod.blog_api_crud_pag_val_mod1.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/apiblog")
public class PostController{

    public PostController(PostService postService) {
        this.postService = postService;
    }

    private PostService postService;

//http://localhost:8080/apiblog
//@PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
public ResponseEntity<?> createNewPost(@Valid @RequestBody PostDTO postDto, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    PostDTO dto=postService.createNewPost(postDto);
    return new ResponseEntity<>(dto, HttpStatus.CREATED);

}
//http://localhost:8080/apiblog/1

@GetMapping("/{id}")
public ResponseEntity<PostDTO> findByPostId(@PathVariable("id") long id){
        PostDTO dto=postService.findByPostId(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
}

       //http://localhost:8080/apiblog/1
      @GetMapping()
      public List<PostDTO> findAllPosts(){
        List<PostDTO> dto=postService.findAllPosts();
        return dto;
    }
    //http://localhost:8080/apiblog/2
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable("id") long id){
        postService.deletePostById(id);
        return new ResponseEntity<>("post has been deleted",HttpStatus.OK);
    }

    //http://localhost:8080/apiblog/5
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> updatePost(@PathVariable("id") long id,@RequestBody PostDTO postDTO) {
        PostDTO dto=postService.updatePost(id,postDTO);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}

