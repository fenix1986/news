package pl.jprabucki.sages.akademia.newsapi;

import java.util.List;

public interface NewsApiExecutor {

    List<Article> execute(String category, String country);
}
