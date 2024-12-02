package com.java.wikisearch.models;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WikiParser {

    public static List<Article> parseXML(String filePath) throws Exception {
        File xmlFile = new File(filePath);
        List<Article> articles = new ArrayList<>();
        Document doc = Jsoup.parse(xmlFile, "UTF-8");

        for (Element page : doc.select("page")) {
            String title = page.selectFirst("title").text();
            String content = page.selectFirst("revision text").text();

            Article article = new Article();
            article.setTitle(title);
            article.setContent(content);
            articles.add(article);
        }
        return articles;
    }
}

