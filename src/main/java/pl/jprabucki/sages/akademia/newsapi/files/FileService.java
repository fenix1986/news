package pl.jprabucki.sages.akademia.newsapi.files;

import java.util.List;

public interface FileService {
    void write(String fileName, List<String> data);
}
