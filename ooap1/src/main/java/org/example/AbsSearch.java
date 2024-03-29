package org.example;

public abstract class AbsSearch {
    protected SearchInterface search;

    public AbsSearch(SearchInterface search) {
        this.search = search;
    }

    public void execute(String inputline, String input) {
        long startTime = System.currentTimeMillis();
        int result = search(inputline, input);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        printAlgorithmName();
        printAlgorithmDescription();
        printExecutionTime(executionTime);
        System.out.println("Результат поиска: " + result);
    }

    public int search(String inputline, String input) {
        return search.search(inputline, input);
    }

    protected abstract void printAlgorithmName();

    protected abstract void printAlgorithmDescription();

    protected void printExecutionTime(long time) {
        System.out.println("Время выполнения алгоритма: " + time + " миллисекунд.");
    }
}
