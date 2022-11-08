package org;

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
        bIndex.CalcularlistaConPosiciones(9);

    	assertEquals(bIndex.nextCipher(0), 0);
    	assertEquals(bIndex.nextCipher(1), 4);
    	assertEquals(bIndex.nextCipher(2), 8);
    	assertEquals(bIndex.nextCipher(3), 1);
        assertEquals(bIndex.nextCipher(4), 3);
        assertEquals(bIndex.nextCipher(5), 5);
    	
    }
    @Test
    void testNextNegative() {
        bIndex.CalcularlistaConPosiciones(9);
    	assertEquals(bIndex.nextCipher(0),0);
    }


}