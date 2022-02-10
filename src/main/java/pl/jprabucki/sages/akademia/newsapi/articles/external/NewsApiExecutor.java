package pl.jprabucki.sages.akademia.newsapi.articles.external;

import pl.jprabucki.sages.akademia.newsapi.articles.Article;

import java.util.List;

public interface NewsApiExecutor {

    List<Article> execute(String category, String country);
}
