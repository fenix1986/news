package pl.jprabucki.sages.akademia.newsapi.configuration;

public interface Configuration {
    String getApiKey() throws NoRequiredArgumentException;
    String getFileName() throws NoRequiredArgumentException;
}
