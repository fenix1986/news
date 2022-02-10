package pl.jprabucki.sages.akademia.newsapi;

public interface Configuration {
    String getApiKey() throws NoRequiredArgumentException;
    String getFileName() throws NoRequiredArgumentException;
}
