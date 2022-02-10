package pl.jprabucki.sages.akademia.newsapi.articles.formatters;

import org.junit.jupiter.api.Test;
import pl.jprabucki.sages.akademia.newsapi.articles.Article;

import static org.junit.jupiter.api.Assertions.*;

class DefaultArticleFormatterTest {

    @Test
    void should_format_article() {
        // Given
        Article article = new Article("Title", "Description", "Author");
        DefaultArticleFormatter defaultArticleFormatter = new DefaultArticleFormatter();

        // When
        String formatted = defaultArticleFormatter.format(article);

        // Then
        assertEquals("Title:Description:Author", formatted);
    }
}