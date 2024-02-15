package it.epicode.w6d2esercizio.controller;

import it.epicode.w6d2esercizio.model.BlogPost;
import it.epicode.w6d2esercizio.model.BlogPostRequest;
import it.epicode.w6d2esercizio.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @GetMapping("/post")
    public Page<BlogPost> getAll(Pageable pageable){

        return blogPostService.cercaTuttiIBlogPosts(pageable);
    }
    @GetMapping("/post/{id}")
    public BlogPost getBlogPostById(@PathVariable int id){
        return blogPostService.cercaPostPerId(id);

    }
    @PostMapping("/post")
    public BlogPost saveBlogPost(@RequestBody BlogPostRequest blogPostRequest){
        return blogPostService.salvaBlogPost(blogPostRequest);
    }
    @PutMapping("/post/{id}")
    public BlogPost updateBlogPost(@PathVariable int id, @RequestBody BlogPostRequest blogPostRequest){
        return blogPostService.aggiornaBlogPost(id, blogPostRequest);
    }

    @DeleteMapping("/post/{id}")
    public void deleteBlogPost(@PathVariable int id){
        blogPostService.cancellaBlogPost(id);
    }
}
