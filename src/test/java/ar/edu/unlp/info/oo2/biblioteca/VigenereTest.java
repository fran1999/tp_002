package ar.edu.unlp.info.oo2.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.unlp.info.oo2.biblioteca.roo2.VigenereCipher;

import static org.junit.jupiter.api.Assertions.*;

public class VigenereTest {
    VigenereCipher vigenere;
    VigenereCipher vigenere1;
    VigenereCipher vigenere2;

    @BeforeEach
    void setUp() {
        this.vigenere = new VigenereCipher();
        this.vigenere1 = new VigenereCipher("abcdefghijklmnopqrstuvwxyz", "cristianoronaldo");
        this.vigenere2 = new VigenereCipher("123456789", "467");
    }

    @Test
    void testCipherEquals() {
        this.vigenere.setKeyword("cifrando");
        assertEquals(this.vigenere.cipher("cifrar"), "eqkiae");
        assertEquals(this.vigenere1.cipher("cifrar"), "eznjtz");
        assertEquals(this.vigenere2.cipher("123"), "479");
    }
    @Test
    void testCipherDosVecesEquals() {

        assertEquals(this.vigenere1.cipher("cifrar"), "eznjtz");
        assertEquals(this.vigenere1.cipher("cifrar"), "cvtioe");
    }
    @Test
    void testCipherDosVecesNotEquals() {

        this.vigenere1.cipher("cifrar");
        assertNotEquals(this.vigenere1.cipher("cifrar"), "eznjtz");
    }


    @Test
    void testCipherConUnaLetraEnKeyword() {
        this.vigenere.setKeyword("c");
        assertEquals(this.vigenere.cipher("cifrar"), "ekhtct");
    }

    @Test
    void testCipherConNumero() {

        this.vigenere.setKeyword("cifrando");
        assertEquals(this.vigenere.cipher("1234"), "1234");
        assertEquals(this.vigenere1.cipher("1234"), "1234");
        assertEquals(this.vigenere2.cipher("1234"), "4797");
    }

    @Test
    void testCipherConUnaLetraEnContructor() {
        VigenereCipher vigenere = new VigenereCipher("a", "c");

        assertEquals(vigenere.cipher("d"), "d");
        assertEquals(vigenere.cipher("f"), "f");
        assertEquals(vigenere.cipher("k"), "k");
    }


    @Test
    void testDecipherEquals() {
        this.vigenere.setKeyword("cifrando");
        assertEquals(this.vigenere.decipher("eqkiae"), "cifrar");
        assertEquals(this.vigenere1.decipher("eznjtz"), "cifrar");
        assertEquals(this.vigenere2.decipher("479"), "123");
    }


    @Test
    void testDecipherConUnaLetraEnKeyword() {
        this.vigenere.setKeyword("c");
        assertEquals(this.vigenere.decipher("ekhtct"), "cifrar");
    }

    @Test
    void testDecipherSinDatos() {
        this.vigenere.setKeyword("cifrando");
        assertEquals(this.vigenere.decipher(""), "");
        assertEquals(this.vigenere1.decipher(""), "");
        assertEquals(this.vigenere2.decipher(""), "");
    }



    @Test
    void testDecipherConNumero() {

        this.vigenere.setKeyword("cifrando");
        assertEquals(this.vigenere.decipher("1234"), "1234");
        assertEquals(this.vigenere1.decipher("1234"), "1234");
        assertEquals(this.vigenere2.decipher("4797"), "1234");
    }
    //test border
    @Test
    void testDecipherSinKeywork() {
        assertEquals(this.vigenere.decipher("cifrar"), "cifrar");
    }

    @Test
    void testCipherSinKeywork() {
        assertEquals(this.vigenere.cipher("cifrar"), "cifrar");
    }
    @Test
    void testDecipherConNull() {
        assertThrows(NullPointerException.class, () -> {
            this.vigenere.decipher(null);
        });
    }
    @Test
    void testCipherConNull() {
        assertThrows(NullPointerException.class, () -> {
            this.vigenere.cipher(null);
        });
    }
    @Test
    void testCipherSinDatos() {
        this.vigenere.setKeyword("cifrando");
        assertEquals(this.vigenere.cipher(""), "");
        assertEquals(this.vigenere1.cipher(""), "");
        assertEquals(this.vigenere2.cipher(""), "");
    }
    @Test
    void testCipherConAlfabetoVacio() {
        VigenereCipher vigenere = new VigenereCipher("", "");
        vigenere.setKeyword("hola");

        assertEquals(vigenere.cipher("d"), "d");
        assertEquals(vigenere.cipher("f"), "f");
        assertEquals(vigenere.cipher("k"), "k");
    }

}
