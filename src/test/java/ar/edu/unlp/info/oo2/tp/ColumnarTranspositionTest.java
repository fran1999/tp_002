package ar.edu.unlp.info.oo2.tp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo2.tp.roo2.ColumnarTranspositionCipher;


public class ColumnarTranspositionTest {
    ColumnarTranspositionCipher colTrans1;



    @BeforeEach
    void setUp() {
    	colTrans1 = new ColumnarTranspositionCipher("CAT");

    }

    @Test
    void testCipherEquals() {
        assertEquals(colTrans1.cipher("THE DOG IS ALIVE"), "HTEODGSIAILV*E*");
        assertEquals(colTrans1.cipher("THE SKY IS BLUE"), "HTEKSYSIBULE");
    }
}
