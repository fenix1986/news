package pl.jprabucki.sages.akademia.newsapi.articles.formatters;

import pl.jprabucki.sages.akademia.newsapi.articles.Article;

public interface ArticleFormatter {
    String format(Article article);
}
