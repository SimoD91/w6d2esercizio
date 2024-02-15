package it.epicode.w6d2esercizio.repository;

import it.epicode.w6d2esercizio.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost, Integer>, PagingAndSortingRepository<BlogPost, Integer> {
}
