package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InputReader {
    public static String readInput(String inputFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }
        reader.close();
        return content.toString();
    }
}