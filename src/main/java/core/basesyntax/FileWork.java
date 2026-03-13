package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public boolean startWithLetter(String word) {
        return word.startsWith(SPECIFIED_CHARACTER);
    }

    public String[] readFromFile(String fileName) {
        try {
            String text = Files.readString(Path.of(fileName)).toLowerCase();
            String[] words = text.split("[\\s\\p{Punct}]+");

            ArrayList<String> filteredWords = new ArrayList<>();

            for (String word : words) {
                if (startWithLetter(word)) {
                    filteredWords.add(word);
                }
            }

            String[] result = filteredWords.toArray(new String[0]);
            Arrays.sort(result);

            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
