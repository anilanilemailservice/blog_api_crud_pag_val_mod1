package com.apipagvalmod.blog_api_crud_pag_val_mod1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PostNotFoundException extends RuntimeException{

    public PostNotFoundException(long postId ){
        super("post not found for this id:"+postId);
    }
}
