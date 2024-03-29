package org.example;

public class LettersSearch extends AbsSearch {
    public LettersSearch(SearchInterface search) {
        super(search);
    }

    @Override
    protected void printAlgorithmName() {
        System.out.println("Поиск букв");
    }

    @Override
    protected void printAlgorithmDescription() {
        System.out.println("Этот режим будет выводить только буквы");
    }

}
