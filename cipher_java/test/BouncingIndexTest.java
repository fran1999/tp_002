package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import roo2.BouncingIndex;
import roo2.CesarCipher;

public class BouncingIndexTest {
	BouncingIndex bIndex;
	BouncingIndex bIndexNegative;


    @BeforeEach
    void setUp() {
        this.bIndex = new BouncingIndex(3);
        this.bIndexNegative = new BouncingIndex(-1);
    }

    @Test
    void testNext() {
    	assertEquals(bIndex.next(), 0);
    	assertEquals(bIndex.next(), 1);
    	assertEquals(bIndex.next(), 2);
    	assertEquals(bIndex.next(), 1);
        assertEquals(bIndex.next(), 0);
        assertEquals(bIndex.next(), 1);
    	
    }
    @Test
    void testNextNegative() {
    	assertEquals(bIndex.next(),0);
    }



}