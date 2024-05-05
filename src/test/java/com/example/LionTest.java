package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    private static final String SEX = "Самец";

    private Lion lion;

    @Mock
    private Feline feline;

    @Test
    public void sexThrowsException() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Оно", feline));
        assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }

    @Test
    public void getKittens() throws Exception {
        lion = new Lion(SEX, feline);
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void getFood() throws Exception {
        lion = new Lion(SEX, feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        List<String> actual = lion.getFood();

        assertEquals(expected, actual);
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }
}