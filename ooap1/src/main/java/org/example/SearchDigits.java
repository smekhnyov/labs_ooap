package org.example;

public class SearchDigits implements SearchInterface {
    public int search(String inputline, String input) {
        if (inputline.length() == 0) {
            throw new RuntimeException("Inputline is empty!");
        }
        if (input.length() == 0) {
            throw new RuntimeException("Input is empty!");
        }
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new RuntimeException("Input is not digit!");
            }
        }
        return inputline.indexOf(input);
    }
}

