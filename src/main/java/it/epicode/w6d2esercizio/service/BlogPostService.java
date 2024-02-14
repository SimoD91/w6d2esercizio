package it.epicode.w6d2esercizio.service;

import it.epicode.w6d2esercizio.model.Autore;
import it.epicode.w6d2esercizio.model.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BlogPostService {
    @Autowired
    private AutoreService autoreService;
    private List<BlogPost> posts = new ArrayList<>();

    public List<BlogPost> cercaTuttiIBlogPosts(){
        return posts;
    }
    public BlogPost cercaPostPerId(int id) throws NoSuchElementException{
        return posts.stream().filter(blogPost -> blogPost.getId()==id).
                findAny().orElseThrow(()->new NoSuchElementException("BlogPost non trovato"));
    }
    public BlogPost salvaBlogPost(BlogPost blogPost, Autore autore) throws NoSuchElementException {
        try {
            Autore a = autoreService.cercaAutorePerId(autore.getId());
            blogPost.setAutore(a);
            posts.add(blogPost);
            return blogPost;
        }  catch (NoSuchElementException e){
           throw new NoSuchElementException("BlogPost non trovato");
        }
    }
    public BlogPost aggiornaBlogPost(int id, BlogPost blogPost) throws NoSuchElementException{
        BlogPost post = cercaPostPerId(id);
        post.setCategoria(blogPost.getCategoria());
        post.setContenuto(blogPost.getContenuto());
        post.setTitolo(blogPost.getTitolo());
        post.setTempoDiLettura(blogPost.getTempoDiLettura());

        return post;
    }
    public void cancellaBlogPost(int id) throws NoSuchElementException{
        BlogPost post = cercaPostPerId(id);
        posts.remove(post);
    }
}
