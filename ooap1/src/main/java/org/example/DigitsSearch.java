package org.example;

public class DigitsSearch extends AbsSearch {
    public DigitsSearch(SearchInterface search) {
        super(search);
    }
    
    @Override
    protected void printAlgorithmName() {
        System.out.println("Поиск цифр");
    }
    
    @Override
    protected void printAlgorithmDescription() {
        System.out.println("Этот режим будет выводить только цифры");
    }
}
