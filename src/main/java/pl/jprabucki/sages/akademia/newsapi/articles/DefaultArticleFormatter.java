package pl.jprabucki.sages.akademia.newsapi.articles;

public class DefaultArticleFormatter implements ArticleFormatter {
    @Override
    public String format(Article article) {
        return String.format("%s:%s:%s", article.getTitle(), article.getDescription(), article.getAuthor());
    }
}
