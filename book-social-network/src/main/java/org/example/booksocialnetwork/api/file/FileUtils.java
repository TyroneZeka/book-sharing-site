package org.example.booksocialnetwork.api.file;

import ch.qos.logback.core.util.StringUtil;
import io.jsonwebtoken.io.IOException;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
public class FileUtils {
    public static byte[] readFileFromLocation(String fileUrl) {
        if(StringUtil.isNullOrEmpty(fileUrl)) {
            return null;
        }
        try{
            Path filePath = new File(fileUrl).toPath();
            return Files.readAllBytes(filePath);
        } catch (java.io.IOException e) {
            log.warn("Error reading file: " + fileUrl);
        }
        return null;
    }
}
