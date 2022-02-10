package pl.jprabucki.sages.akademia.newsapi;

import java.util.List;
import java.util.stream.Collectors;

public class NewsApiService {
    private final String fileName;

    private final NewsApiExecutor newsApiExecutor;
    private final ArticleFormatter articleFormatter;
    private final FileService fileService;

    public NewsApiService(String api, String fileName) {
        this.fileName = fileName;

        this.newsApiExecutor = new SimpleNewsApiExecutor(api);
        this.articleFormatter = new DefaultArticleFormatter();
        this.fileService = new SimpleFileService();
    }

    public void proceed() {
        List<Article> articleList = newsApiExecutor.execute("business", "pl");
        List<String> formattedArticles = articleList.stream().map(articleFormatter::format).collect(Collectors.toList());
        fileService.write(fileName, formattedArticles);
    }
}
