import org.junit.jupiter.api.Test;

import org.example.AbsSearch;
import org.example.DigitsSearch;
import org.example.LettersSearch;
import org.example.SpecialSearch;
import org.example.SearchDigits;
import org.example.SearchLetters;
import org.example.SearchSpecial;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Tests {
    @Test
    public void LettersTestWithLetters()
    {
        AbsSearch parser = new LettersSearch(new SearchLetters());
        assertEquals(1, parser.search("текст!", "ек"));
    }


    @Test
    public void LettersTestWithNull() throws RuntimeException
    {
        AbsSearch parser = new LettersSearch(new SearchLetters());
        RuntimeException exception = assertThrows(RuntimeException.class, () -> parser.search("", ""));
    }

    @Test
    public void LettersTestWithWhiteSpace() throws RuntimeException
    {
        AbsSearch parser = new LettersSearch(new SearchLetters());
        RuntimeException exception = assertThrows(RuntimeException.class, () -> parser.search(" ", " "));
    }

    @Test
    public void LettersTestWithDigits() throws RuntimeException
    {
        AbsSearch parser = new LettersSearch(new SearchLetters());
        RuntimeException exception = assertThrows(RuntimeException.class, () -> parser.search("текст1", "1"));
    }



    @Test
    public void DigitsTestWithDigits()
    {
        AbsSearch parser = new DigitsSearch(new SearchDigits());
        assertEquals(5, parser.search("текст1", "1"));
    }

    @Test
    public void DigitsTestWithNull() throws RuntimeException
    {
        AbsSearch parser = new DigitsSearch(new SearchDigits());
        RuntimeException exception = assertThrows(RuntimeException.class, () -> parser.search("", ""));
    }

    @Test
    public void DigitsTestWithWhitespace() throws RuntimeException
    {
        AbsSearch parser = new DigitsSearch(new SearchDigits());
        RuntimeException exception = assertThrows(RuntimeException.class, () -> parser.search(" ", " "));
    }

    @Test
    public void DigitsTestWithLetters() throws RuntimeException
    {
        AbsSearch parser = new DigitsSearch(new SearchDigits());
        RuntimeException exception = assertThrows(RuntimeException.class, () -> parser.search("текст1!", "текст"));
    }



    @Test
    public void SpecialTestWithSpecial()
    {
        AbsSearch parser = new SpecialSearch(new SearchSpecial());
        assertEquals(6, parser.search("Текст!@#", "@"));
    }


    @Test
    public void SpecialTestWithNull() throws RuntimeException
    {
        AbsSearch parser = new SpecialSearch(new SearchSpecial());
        RuntimeException exception = assertThrows(RuntimeException.class, () -> parser.search("", ""));
    }

    @Test
    public void SpecialTestWithWhitespace() throws RuntimeException
    {
        AbsSearch parser = new SpecialSearch(new SearchSpecial());
        RuntimeException exception = assertThrows(RuntimeException.class, () -> parser.search(" ", " "));
    }

    @Test
    public void SpecialTestWithDigits() throws RuntimeException
    {
        AbsSearch parser = new SpecialSearch(new SearchSpecial());
        RuntimeException exception = assertThrows(RuntimeException.class, () -> parser.search("текст1!", "1"));
    }
}
