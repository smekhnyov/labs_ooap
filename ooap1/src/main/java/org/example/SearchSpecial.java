package org.example;

public class SearchSpecial implements SearchInterface {

    public int search(String inputline, String input) {
        if (inputline.length() == 0) {
            throw new RuntimeException("Inputline is empty!");
        }
        if (input.length() == 0) {
            throw new RuntimeException("Input is empty!");
        }
        for (char c : input.toCharArray()) {
            if (Character.isLetterOrDigit(c) || Character.isWhitespace(c)) {
                throw new RuntimeException("Input is not special character!");
            }
        }
        return inputline.indexOf(input);
    }
}

