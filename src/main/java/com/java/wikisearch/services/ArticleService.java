package com.java.wikisearch.services;

import com.java.wikisearch.models.Article;
import com.java.wikisearch.repos.ArticleRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArticleService
{
    private final ArticleRepo articleRepo;

    public List<Article> searchArticles(String keyword)
    {
        return articleRepo.findByTitleContaining(keyword);
    }

    public Article saveArticle(Article article)
    {
        return articleRepo.save(article);
    }
}
