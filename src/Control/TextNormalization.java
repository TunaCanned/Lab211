package Control;

import java.io.IOException;
import Model.OutputWriter;
import Model.InputReader;

public class TextNormalization {
    public static void main(String[] args) {
        String inputFile = "Input.txt";
        String outputFile = "Output.txt";

        try {
            String inputText = InputReader.readInput(inputFile);
            String normalizedText = normalizeText(inputText);
            OutputWriter.writeOutput(outputFile, normalizedText);

            System.out.println("Text normalization completed successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static String normalizeText(String text) {
        text = text.replaceAll("\\s+", " ");
        text = text.replaceAll("\\s+\"\\s+", "\"");

        // Normalize sentence capitalization
        String[] sentences = text.split("\\.\\s+");
        StringBuilder normalizedText = new StringBuilder();
        for (String sentence : sentences) {
            String[] words = sentence.split("\\s+");
            for (int i = 0; i < words.length; i++) {
                if (i == 0) {

                    words[i] = capitalizeWord(words[i]);
                } else {

                    words[i] = words[i].toLowerCase();
                }
            }
            normalizedText.append(String.join(" ", words)).append(". ");
        }


        normalizedText = new StringBuilder(normalizedText.toString().replaceAll("\\s+,", ",").replaceAll("\\s+:", ":"));

        if (!normalizedText.toString().endsWith(".")) {
            normalizedText.append(".");
        }

        return normalizedText.toString();
    }

    private static String capitalizeWord(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}