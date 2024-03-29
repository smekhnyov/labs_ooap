package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите источник ввода:");
        System.out.println("1. Ввести текст из файла;");
        System.out.println("2. Ввести текст с клавиатуры.");
        int inputChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        String inputline = "";

        if (inputChoice == 1) {
            System.out.print("Введите название файла: ");
            String filename = scanner.nextLine();
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                StringBuilder inputtext = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    inputtext.append(line);
                }

                inputline = inputtext.toString();
            } catch (IOException error) {
                error.printStackTrace();
            }
        } else if (inputChoice == 2) {
            System.out.print("Введите текст: ");
            inputline = scanner.nextLine();
        } else {
            System.out.println("Неправильный ввод");
            return;
        }

        if (!inputline.isEmpty()) {
            System.out.println("Выберите режим работы поиска:");
            System.out.println("1. Буквы;");
            System.out.println("2. Цифры;");
            System.out.println("3. Спецсимволы.");
            int choice = scanner.nextInt();
            System.out.println("Введите что надо найти:");
            String input = scanner.next();
            AbsSearch search;
            switch (choice) {
                case 1:
                    search = new LettersSearch(new SearchLetters());
                    break;
                case 2:
                    search = new DigitsSearch(new SearchDigits());
                    break;
                case 3:
                    search = new SpecialSearch(new SearchSpecial());
                    break;
                default:
                    System.out.println("Неправильный ввод");
                    return;
            }
            search.execute(inputline, input);
        }
    }
}