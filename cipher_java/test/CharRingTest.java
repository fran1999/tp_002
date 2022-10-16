package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import roo2.CharRing;

import static org.junit.jupiter.api.Assertions.*;

public class CharRingTest {
    private CharRing charRing;
    private CharRing charRing1;



    @BeforeEach
    public void setupTest(){
        this.charRing = new CharRing("abcdefghijklmnopqrstuvwxyz");
        this.charRing1 = new CharRing("123456789");

    }

    @Test
    public void testCharRingEquals(){
        //setupTest();
        for (int i=0; i<8;i++){
            this.charRing.next();
            this.charRing1.next();
        }
        assertEquals('i',this.charRing.next());
        assertEquals('9',this.charRing1.next());

        for (int i=0; i<70;i++){
            this.charRing.next();
            this.charRing1.next();
        }
        assertEquals('b',this.charRing.next());
        assertEquals('8',this.charRing1.next());
    }
    @Test
    public void testCharRingNotEquals() {
        for (int i=0; i<8;i++){
            this.charRing.next();
            this.charRing1.next();
        }
        assertNotEquals('k',this.charRing.next());
        assertNotEquals('7',this.charRing1.next());
    }

    @Test
    public void testCharRingConCadenaVacia() {
        CharRing charRing = new CharRing("");

        assertThrows(ArrayIndexOutOfBoundsException.class,()->{charRing.next();});
    }

    @Test
    void testCharRingConNull(){
        assertThrows(NullPointerException.class,()->{new CharRing(null);});
    }
}
