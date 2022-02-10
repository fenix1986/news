package pl.jprabucki.sages.akademia.newsapi.articles;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.jprabucki.sages.akademia.newsapi.articles.external.NewsApiExecutor;
import pl.jprabucki.sages.akademia.newsapi.articles.formatters.DefaultArticleFormatter;
import pl.jprabucki.sages.akademia.newsapi.files.FileService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class NewsApiServiceTest {
    @Test
    void should_write_to_file_when_api_return_articles() {
        // Given
        NewsApiExecutor newsApiExecutor = Mockito.mock(NewsApiExecutor.class);
        doReturn(prepareArticles()).when(newsApiExecutor).execute(anyString(), anyString());
        FileService fileService = Mockito.mock(FileService.class);
        NewsApiService newsApiService = new NewsApiService(newsApiExecutor, new DefaultArticleFormatter(), fileService);

        // When
        newsApiService.proceed("file");

        // Then
        verify(newsApiExecutor, times(1)).execute("business", "pl");
        verify(fileService, times(1)).write("file", prepareResult());
    }

    private List<Article> prepareArticles() {
        List<Article> articleList = new ArrayList<>();
        articleList.add(new Article("Title", "Desc", "Author"));
        return articleList;
    }

    private List<String> prepareResult() {
        List<String> result = new ArrayList<>();
        result.add("Title:Desc:Author");
        return result;
    }
}