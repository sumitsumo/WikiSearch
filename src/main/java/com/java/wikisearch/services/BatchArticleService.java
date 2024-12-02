package com.java.wikisearch.services;


import com.java.wikisearch.models.Article;
import com.java.wikisearch.repos.ArticleRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchArticleService {

    private final ArticleRepo articleRepository;

    public BatchArticleService(ArticleRepo articleRepository) {
        this.articleRepository = articleRepository;
    }

    public void saveArticlesInBatch(List<Article> articles) {
        for (Article article : articles) {
            if (!articleRepository.existsByTitle(article.getTitle())) {
                articleRepository.save(article);
            }
        }
    }

}

