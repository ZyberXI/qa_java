package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline;

    @Test
    public void eatMeat() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFamily() {
        String actual = feline.getFamily();
        Mockito.verify(feline, Mockito.times(1)).getFamily();
        String expected = "Кошачьи";

        assertEquals(expected,actual);

    }

    @Test
    public void getKittens() {
        int actual = feline.getKittens();
        int expected = 1;
        Mockito.verify(feline).getKittens(expected);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetKittens() {
      int expected = 10;
      int actual = feline.getKittens(expected);
      Mockito.verify(feline).getKittens(Mockito.anyInt());

      assertEquals(expected, actual);
    }
}