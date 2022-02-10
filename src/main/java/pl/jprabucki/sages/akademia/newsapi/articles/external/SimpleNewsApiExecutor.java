package pl.jprabucki.sages.akademia.newsapi.articles.external;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import pl.jprabucki.sages.akademia.newsapi.articles.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleNewsApiExecutor implements NewsApiExecutor {
    private final NewsApiClient newsApiClient;

    public SimpleNewsApiExecutor(String api) {
        this.newsApiClient = new NewsApiClient(api);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Article> execute(String category, String country) {
        final List<Article>[] result = new List[]{new ArrayList<>()};

        newsApiClient.getTopHeadlines(
            new TopHeadlinesRequest.Builder()
                .category(category)
                .country(country)
                .build(),
            new NewsApiClient.ArticlesResponseCallback() {
                @Override
                public void onSuccess(ArticleResponse articleResponse) {
                    result[0] = articleResponse.getArticles().stream().map(a -> fromClientArticle(a)).collect(Collectors.toList());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.exit(0);
                }

                @Override
                public void onFailure(Throwable throwable) {
                    throwable.printStackTrace();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.exit(0);
                }
            }
        );

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result[0];
    }

    private Article fromClientArticle(com.kwabenaberko.newsapilib.models.Article article) {
        return new Article(article.getTitle(), article.getDescription(), article.getAuthor());
    }
}
