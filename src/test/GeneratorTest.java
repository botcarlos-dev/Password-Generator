package test;

import static org.junit.jupiter.api.Assertions.*;

import model.*;
import org.junit.jupiter.api.Test;

class GeneratorTest {

    private final Password password= new Password("Secret");
    private final Alphabet firstAlphabet = new Alphabet(true,false,false,false);
    private final Alphabet secondAlphabet = new Alphabet(false,true,true,true);
    private final Generator generator = new Generator(true,false,false,false);
//	private final Password generatedPassword = generator.GeneratePassword(4);

    @Test
    void test1() {
        assertEquals("Secret", password.toString());
    }

    @Test
    void test2() {
        assertEquals(firstAlphabet.getAlphabet(), Alphabet.UPPER_CASE);
    }

    @Test
    void test3() {
        assertEquals(secondAlphabet.getAlphabet(), Alphabet.LOWER_CASE + Alphabet.DIGITS + Alphabet.SYMBOLS);
    }

    @Test
    void test4() {
        assertEquals(generator.alphabet.getAlphabet(), Alphabet.UPPER_CASE);
    }

    @Test
    void test5() {
        assertEquals(generator.alphabet.getAlphabet().length(), 26);
    }

}