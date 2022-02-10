package pl.jprabucki.sages.akademia.newsapi;

import pl.jprabucki.sages.akademia.newsapi.articles.NewsApiService;
import pl.jprabucki.sages.akademia.newsapi.articles.external.SimpleNewsApiExecutor;
import pl.jprabucki.sages.akademia.newsapi.articles.formatters.DefaultArticleFormatter;
import pl.jprabucki.sages.akademia.newsapi.configuration.CmdConfiguration;
import pl.jprabucki.sages.akademia.newsapi.configuration.Configuration;
import pl.jprabucki.sages.akademia.newsapi.configuration.NoRequiredArgumentException;
import pl.jprabucki.sages.akademia.newsapi.files.SimpleFileService;

public class News {

    public static void main(String[] args) {
        Configuration configuration = new CmdConfiguration(args);

        try {
            NewsApiService newsApiService = new NewsApiService(
                new SimpleNewsApiExecutor(configuration.getApiKey()),
                new DefaultArticleFormatter(),
                new SimpleFileService()
            );
            newsApiService.proceed(configuration.getFileName());

        } catch (NoRequiredArgumentException e) {
            // do nothing

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
