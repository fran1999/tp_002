package roo2;

import roo2.CharRing;

//import roo2.Cipher;

public class  VigenereCipher extends SubstitutionCipher {
    CharRing keyword;
    public  VigenereCipher(String inputAlphabet, String kword){
        alphabet = new char[inputAlphabet.length()];
        inputAlphabet.getChars(0,inputAlphabet.length(), alphabet, 0);
        setKeyword(kword);
    };

    public  VigenereCipher() {
        
        String inputAlphabet = DEFAULT_ALPHABET;
        alphabet = new char[inputAlphabet.length()];
        inputAlphabet.getChars(0,inputAlphabet.length(), alphabet, 0);
        keyword = new CharRing("a");
    };
    
	@Override
	protected char callCipherChar(char inputChar) {
		// TODO Auto-generated method stub		
		return this.cipherChar(inputChar,this.currentOffset());
	}

	@Override
	protected char callDecipherChar(char inputChar) {
		// TODO Auto-generated method stub
		return this.decipherChar(inputChar,this.currentOffset());
	};
    public void setKeyword(String srcString){
        keyword = new CharRing(srcString);
    }
    private int currentOffset(){
        return keyword.next()- alphabet[0];
    }
}