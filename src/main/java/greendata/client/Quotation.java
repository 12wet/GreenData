package greendata.client;

import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Quotation {

    @Value("${spring.appdata.directory}")
    private String appDataDirectory;

    private File quotation;

    public Quotation(String originalPath) throws IOException {
        Files.copy(Path.of(originalPath), Path.of(System.getenv("APPDATA") + appDataDirectory));
    }
}
