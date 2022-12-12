package ar.edu.unlp.info.oo2.tp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ar.edu.unlp.info.oo2.tp.roo2.VigenereCipher;

public class deciphercmd {
    public static void main(String[] args)
        throws IOException
    {
        final VigenereCipher vigenere = new VigenereCipher();

        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
 
        // Reading data using readLine
        String name = reader.readLine();
 
        // Printing the read line
        vigenere.setKeyword("abcdefghijklmnopqrstuvwxyz");
        System.out.println("Vigener Cipher:"+vigenere.decipher(name));
    }
}



