package pl.jprabucki.sages.akademia.newsapi;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class SimpleFileService implements FileService {
    @Override
    public void write(String fileName, List<String> data) {
        String allData = String.join("\n", data);

        try {
            FileUtils.writeStringToFile(new File(fileName), allData, StandardCharsets.UTF_8, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
