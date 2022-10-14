package test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import roo2.RailFenceCipher;

import static org.junit.jupiter.api.Assertions.*;

public class RailsFenceCipherTest {

    RailFenceCipher railFence1;
    RailFenceCipher railFence2;
    RailFenceCipher railFence3;

    @BeforeEach
    void setUp(){
        this.railFence1 = new RailFenceCipher(1);
        this.railFence2 = new RailFenceCipher(2);
        this.railFence3 = new RailFenceCipher(3);
    }
    @Test
    void testCipherEquals(){
        assertEquals(this.railFence1.cipher("hola"),"hola");
        assertEquals(this.railFence2.cipher("hola"),"hloa");
        assertEquals(this.railFence3.cipher("hola"),"haol");

    }
    @Test
    void testCipherNotEquals(){
        assertNotEquals(this.railFence1.cipher("hola"),"hlaa");
        assertNotEquals(this.railFence2.cipher("hola"),"hola");
        assertNotEquals(this.railFence3.cipher("hola"),"hola");
    }
    @Test
    void testDecipher(){
        //aca devuelde el mismo string
        assertEquals(this.railFence1.decipher("hola"),"hola");
        assertEquals(this.railFence2.decipher("hola"),"hola");
        assertEquals(this.railFence3.decipher("hola"),"hola");
    }
    @Test
    void testDecipherNotEquals(){
        //aca devuelde el mismo string
        assertNotEquals(this.railFence1.decipher("aaa"),"aas");
        assertNotEquals(this.railFence2.decipher("aaa"),"aas");
        assertNotEquals(this.railFence3.decipher("aaa"),"aas");
    }

    @Test
    void testRailsNegativos(){
        assertThrows(NegativeArraySizeException.class,()->{new RailFenceCipher(-1);});
    }

}
