package pl.jprabucki.sages.akademia.newsapi;

public class NewsApi {

    public static void main(String[] args) {
        Configuration configuration = new CmdConfigurationParser(args);

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
