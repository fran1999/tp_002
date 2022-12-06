package ar.edu.unlp.info.oo2.tp.roo2;

import java.util.ArrayList;
import java.util.Collections;

public class ComplexCipher implements Cipher{
	ArrayList<Cipher> ciphers;
	
	public ComplexCipher() {
		this.ciphers = new ArrayList<Cipher>();
	}
	
	public void addCipher(Cipher cipher) {
		this.ciphers.add(cipher);
	}

	@Override
	public String cipher(String inputText) {
		// TODO Auto-generated method stub
		String message = inputText;
	    for (Cipher c : ciphers) {
	        message = c.cipher(message);
	      }
		return message;
	}

	@Override
	public String decipher(String inputText) {
		// TODO Auto-generated method stub
		ArrayList<Cipher> reverseList = this.ciphers;
		String message = inputText;
		Collections.reverse(reverseList);		
		for (Cipher c : reverseList) {
			message = c.decipher(message);
		}
		return message;
	}

}
