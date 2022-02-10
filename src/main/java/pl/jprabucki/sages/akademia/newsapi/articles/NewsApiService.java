package pl.jprabucki.sages.akademia.newsapi.articles;

import pl.jprabucki.sages.akademia.newsapi.articles.external.NewsApiExecutor;
import pl.jprabucki.sages.akademia.newsapi.articles.external.SimpleNewsApiExecutor;
import pl.jprabucki.sages.akademia.newsapi.articles.formatters.ArticleFormatter;
import pl.jprabucki.sages.akademia.newsapi.articles.formatters.DefaultArticleFormatter;
import pl.jprabucki.sages.akademia.newsapi.files.FileService;
import pl.jprabucki.sages.akademia.newsapi.files.SimpleFileService;

import java.util.List;
import java.util.stream.Collectors;

public class NewsApiService {
    private final NewsApiExecutor newsApiExecutor;
    private final ArticleFormatter articleFormatter;
    private final FileService fileService;

    public NewsApiService(NewsApiExecutor newsApiExecutor, ArticleFormatter articleFormatter, FileService fileService) {
        this.newsApiExecutor = newsApiExecutor;
        this.articleFormatter = articleFormatter;
        this.fileService = fileService;
    }

    public void proceed(String fileName) {
        List<Article> articleList = newsApiExecutor.execute("business", "pl");
        List<String> formattedArticles = articleList.stream().map(articleFormatter::format).collect(Collectors.toList());
        fileService.write(fileName, formattedArticles);
    }
}
