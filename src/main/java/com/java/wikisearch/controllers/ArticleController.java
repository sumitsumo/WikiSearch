package com.java.wikisearch.controllers;

import com.java.wikisearch.models.Article;
import com.java.wikisearch.services.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
@AllArgsConstructor
public class ArticleController
{
    private final ArticleService articleService;

    @GetMapping("/search")
    public List<Article> search(@RequestParam String keyword)
    {
        return articleService.searchArticles(keyword);
    }

    @PostMapping
    public Article save(@RequestBody Article article)
    {
        return articleService.saveArticle(article);
    }
}
