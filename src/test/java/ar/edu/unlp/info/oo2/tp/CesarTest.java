package ar.edu.unlp.info.oo2.tp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.unlp.info.oo2.tp.roo2.CesarCipher;

public class CesarTest {
    CesarCipher cesar1;
    CesarCipher cesar2;



    @BeforeEach
    void setUp() {

        this.cesar1 = new CesarCipher(3);
        this.cesar2 = new CesarCipher(3,"123456789");

    }

    @Test
    void testCipherEquals() {
        assertEquals(cesar1.cipher("hola"), "krod");
        assertEquals(cesar1.cipher("xyz"), "abc");
        assertEquals(cesar2.cipher("1234"), "4567");
        assertEquals(cesar2.cipher("789"), "123");

    }
    @Test
    void testCipherNotEquals() {
        assertNotEquals(cesar1.cipher("hola"), "123");
        assertNotEquals(cesar2.cipher("789"), "hola");

    }
    @Test
    void testDecipherEquals() {
        assertEquals(cesar1.decipher("krod"), "hola");
        assertEquals(cesar1.decipher("abc"), "xyz");
        assertEquals(cesar2.decipher("4567"), "1234");
        assertEquals(cesar2.decipher("123"), "789");

    }
    @Test
    void testDecipherNotEquals() {
        assertNotEquals(cesar1.decipher("krod"), "assd");
        assertEquals(cesar1.decipher("abc"), "xyz");
        assertEquals(cesar2.decipher("4567"), "1234");
        assertEquals(cesar2.decipher("123"), "789");
    }


    @Test
    public void testCipherConDistintasDistancia(){
        CesarCipher cesar = new CesarCipher(5);
        CesarCipher cesar1 = new CesarCipher(10);

        assertEquals(cesar.cipher("abcd"),"fghi");
        assertEquals(cesar.cipher("xyz"),"cde");

        assertEquals(cesar1.cipher("abcd"),"klmn");
        assertEquals(cesar1.cipher("xyz"),"hij");

    }

    @Test
    void testCipherConCaracteresOutOfKeyboard(){

        assertEquals(cesar1.cipher("ab!c·d"),"de!f·g");
        assertEquals(cesar1.cipher("abcd"),"defg");

    }
    //test de borde
    @Test
    public void testCipherConNumeroNegativo(){

        CesarCipher cesar = new CesarCipher(-10);
        assertThrows(ArrayIndexOutOfBoundsException.class, ()->{cesar.cipher("abcd");} );
    }
    @Test
    public void testCipherFueraDeRango(){

        CesarCipher cesar = new CesarCipher(27);
        assertThrows(ArrayIndexOutOfBoundsException.class, ()->{cesar.cipher("xyz");} );
    }
    @Test
    public void testCipherConInputAlphabetVacio(){

        CesarCipher cesar= new CesarCipher(3,"");
        CesarCipher cesar1= new CesarCipher(4,"");
        CesarCipher cesar2= new CesarCipher(5,"");

        assertEquals(cesar.cipher("abcd"),"abcd");
        assertEquals(cesar1.cipher("abcd"),"abcd");
        assertEquals(cesar2.cipher("abcd"),"abcd");

    }
    @Test
    public void testCipherConNull(){
        assertThrows(NullPointerException.class,()->{
            cesar1.cipher(null);} );
    }


    @Test
    public void testDecipherConNull(){
        assertThrows(NullPointerException.class, ()->{
            cesar1.decipher(null);} );
    }
    /*@Test
    void testBad(){
        //este test falla por el parentecis
        CesarCipher cesar1 = new CesarCipher(1,"a!#$%&/(");
        assertEquals(cesar1.cipher("!#$%"),"%&/(");
        assertEquals(cesar1.decipher("%&/("),"!#$%");

    }*/

}