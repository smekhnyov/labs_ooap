package org.example;

public class SpecialSearch extends AbsSearch {

    public SpecialSearch(SearchInterface search) {
        super(search);
    }
    
    @Override
    protected void printAlgorithmName() {
        System.out.println("Поиск спецсимволов");
    }
    
    @Override
    protected void printAlgorithmDescription() {
        System.out.println("Этот режим будет выводить только спецсимволы");
    }
}
