package com.serenitydojo.exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileLoader {
    public String readHelloWorld() throws IOException {
        //String fileContents;
        return Files.readString(Paths.get("src/main/resources/hello.txt"));
        //return fileContents ;
    }

    public Boolean fileContainsText(String filename, String expectedText) {
        String path = "src/main/resources/" + filename;
        //Does the file exist?
        //Does the file contain the expected text - Hello World?
        try {
            return Files.readString(Paths.get(path)).contains(expectedText);
        } catch (IOException fileDoesNotExist) {
            return false;
        }
    }

    public Boolean fileHasText(String filename, String expectedText )  {
        String path = "src/main/resources/" + filename;
        try {
            return Files.readString(Paths.get(path)).contains(expectedText);
        } catch (IOException fileDoesNotExist) {
            //catch the built-in IO Exception but throw the custom exception instead to caller
            throw new  MissingWelcomeFileException("This file does not exist: " + filename , fileDoesNotExist);
        }
    }
}
