package ar.edu.unlp.info.oo2.tp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo2.tp.roo2.Cipher;
import ar.edu.unlp.info.oo2.tp.roo2.ComplexCipher;
import ar.edu.unlp.info.oo2.tp.roo2.InterfaceFramework;

public class ComplexCipherTest {
	
	    Cipher cipher1;
	    InterfaceFramework f;
	    Cipher cipher2;
	    ComplexCipher complex;

	    @BeforeEach
	    void setUp() {
	    	f = new InterfaceFramework();
	    	cipher1 = f.crearCesar("ABCDEFGHIJKLMNOPQRSTUVWXYZ",2);
	    	cipher2 = f.crearRailFence(3);
	    	complex = f.crearComplexCipher();
	    }

	    @Test
	    void testCipherEquals() {
	    	complex.addCipher(cipher1);
	    	complex.addCipher(cipher2);
	    	System.out.println(cipher1.cipher("DIEGOAGUILAR"));
	        assertEquals(complex.cipher("DIEGOAGUILAR"), "FQKKICWNTGIC");
	        assertEquals(complex.decipher("FQKKICWNTGIC"), "DIEGOAGUILAR");

	    }
	    
	    @Test
	    void testRemoveCipher() {
	    	complex.addCipher(cipher1);
	    	complex.addCipher(cipher2);
	    	complex.removeCipher();
	    	assertEquals(complex.cipher("DIEGO"), "FKGIQ");
	    }
	    
}
