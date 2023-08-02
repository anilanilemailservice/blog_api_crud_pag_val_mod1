package com.apipagvalmod.blog_api_crud_pag_val_mod1.service.impl;

import com.apipagvalmod.blog_api_crud_pag_val_mod1.entity.Post;
import com.apipagvalmod.blog_api_crud_pag_val_mod1.exceptions.PostNotFoundException;
import com.apipagvalmod.blog_api_crud_pag_val_mod1.payload.PostDTO;
import com.apipagvalmod.blog_api_crud_pag_val_mod1.repository.PostRepository;
import com.apipagvalmod.blog_api_crud_pag_val_mod1.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepo;
    private ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepo, ModelMapper modelMapper) {
        this.postRepo = postRepo;
        this.modelMapper = modelMapper;
    }

    Post mapToEntity(PostDTO dto) {
        Post post = modelMapper.map(dto, Post.class);
        return post;
    }

    PostDTO mapToDto(Post post) {
        PostDTO dto = modelMapper.map(post, PostDTO.class);
        return dto;
    }

    @Override
    public PostDTO createNewPost(PostDTO postDto) {
        Post post = mapToEntity(postDto);
        Post savedPost = postRepo.save(post);
        PostDTO dto = mapToDto(savedPost);
        return dto;
    }

    @Override
    public PostDTO findByPostId(long id) {
        Post post = postRepo.findById(id).orElseThrow(() -> new PostNotFoundException(id));
        PostDTO postDTO = mapToDto(post);
        return postDTO;
    }

    @Override

    public List<PostDTO> findAllPosts(){
        List<Post> post=postRepo.findAll();
       List<PostDTO> dto= post.stream().map(x->mapToDto(x)).collect(Collectors.toList());
        return dto;
}
    @Override
    public void deletePostById(long id) {
        Post post = postRepo.findById(id).orElseThrow(() -> new PostNotFoundException(id));
        postRepo.deleteById(id);
    }

    @Override
    public PostDTO updatePost(long id, PostDTO postDTO) {
        Post post = postRepo.findById(id).orElseThrow(() -> new PostNotFoundException(id));

        Post postSaved = mapToEntity(postDTO);
        postSaved.setId(post.getId());
        Post save = postRepo.save(postSaved);

        PostDTO dto = mapToDto(save);
        return dto;
    }
}
