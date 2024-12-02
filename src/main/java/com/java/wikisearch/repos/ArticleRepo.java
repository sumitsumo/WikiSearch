package com.java.wikisearch.repos;

import com.java.wikisearch.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepo extends JpaRepository<Article, Long>
{
    List<Article> findByTitleContaining(String keyword);
    boolean existsByTitle(String title);
}
