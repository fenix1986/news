package pl.jprabucki.sages.akademia.newsapi;

import pl.jprabucki.sages.akademia.newsapi.articles.external.NewsApiService;
import pl.jprabucki.sages.akademia.newsapi.configuration.CmdConfiguration;
import pl.jprabucki.sages.akademia.newsapi.configuration.Configuration;
import pl.jprabucki.sages.akademia.newsapi.configuration.NoRequiredArgumentException;

public class News {

    public static void main(String[] args) {
        Configuration configuration = new CmdConfiguration(args);

        try {
            NewsApiService newsApiService = new NewsApiService(configuration.getApiKey(), configuration.getFileName());
            newsApiService.proceed();

        } catch (NoRequiredArgumentException e) {
            // do nothing

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
