package ar.edu.unlp.info.oo2.tp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ar.edu.unlp.info.oo2.tp.roo2.VigenereCipher;
import ar.edu.unlp.info.oo2.tp.roo2.RailFenceCipher;

public class ciphercmd {
    public static void main(String[] args)
        throws IOException
    {
        final VigenereCipher vigenere = new VigenereCipher();
        final RailFenceCipher railFence = new RailFenceCipher(2);

        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
 
        // Reading data using readLine
        String name = reader.readLine();
 
        // Printing the read line
        vigenere.setKeyword("abcdefghijklmnopqrstuvwxyz");
        System.out.println("Vigener Cipher:"+vigenere.cipher(name));
        System.out.println("RailFence Cipher:"+railFence.cipher(name));
    }
}



