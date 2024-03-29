package org.example;

public class SearchLetters implements SearchInterface {
    public int search(String inputline, String input) {
        if (inputline.length() == 0) {
            throw new RuntimeException("Inputline is empty!");
        }
        if (input.length() == 0) {
            throw new RuntimeException("Input is empty!");
        }
        for (char c : input.toCharArray()) {
            if (!Character.isLetter(c)) {
                throw new RuntimeException("Input is not letter!");
            }
        }
        return inputline.indexOf(input);
    }
}

