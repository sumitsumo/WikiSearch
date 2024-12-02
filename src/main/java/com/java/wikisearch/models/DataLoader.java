package com.java.wikisearch.models;

import com.java.wikisearch.services.BatchArticleService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final BatchArticleService batchArticleService;

    @Value("${file.path}")
    private String filePath;

    public DataLoader(BatchArticleService batchArticleService) {
        this.batchArticleService = batchArticleService;
    }

    @Override
    public void run(String... args) throws Exception {
        String xmlFilePath = new ClassPathResource(filePath).getFile().getAbsolutePath();
        List<Article> articles = WikiParser.parseXML(xmlFilePath);
        batchArticleService.saveArticlesInBatch(articles);
    }
}
