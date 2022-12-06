package ar.edu.unlp.info.oo2.tp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo2.tp.roo2.Cipher;
import ar.edu.unlp.info.oo2.tp.roo2.ColumnarTranspositionCipher;
import ar.edu.unlp.info.oo2.tp.roo2.InterfaceFramework;


public class ColumnarTranspositionTest {
    ColumnarTranspositionCipher colTrans1;
    InterfaceFramework f;
    Cipher columnar;

    @BeforeEach
    void setUp() {
    	f = new InterfaceFramework();
    	colTrans1 = new ColumnarTranspositionCipher("CAT");
    	columnar = f.crearColumnar("CAT");
    }

    @Test
    void testCipherEquals() {
        assertEquals(colTrans1.cipher("THE DOG IS ALIVE"), "HTEODGSIAILV*E*");
        assertEquals(columnar.cipher("THE DOG IS ALIVE"), "HTEODGSIAILV*E*");
        assertEquals(colTrans1.cipher("THE SKY IS BLUE"), "HTEKSYSIBULE");
        assertEquals(columnar.cipher("THE SKY IS BLUE"), "HTEKSYSIBULE");
    }
    
    @Test
    void testDecipherEquals() {
        assertEquals(colTrans1.decipher("HTEODGSIAILV*E*"), "THE DOG IS ALIVE");
//        assertEquals(colTrans1.decipher("HTEKSYSIBULE"), "THE SKY IS BLUE");
    }
}

