package pl.jprabucki.sages.akademia.newsapi;

public class Article {
    private final String title;
    private final String description;
    private final String author;

    public Article(String title, String description, String author) {
        this.title = title;
        this.description = description;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }
}
