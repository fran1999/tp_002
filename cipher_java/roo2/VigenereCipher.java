package roo2;

import roo2.CharRing;

//import roo2.Cipher;

public class  VigenereCipher extends SubstitutionCipher {
    CharRing keyword;

    public VigenereCipher(String inputAlphabet, String kword) {
        alphabet = new char[inputAlphabet.length()];
        inputAlphabet.getChars(0, inputAlphabet.length(), alphabet, 0);
        setKeyword(kword);
    }

    ;

    public VigenereCipher() {

        String inputAlphabet = DEFAULT_ALPHABET;
        alphabet = new char[inputAlphabet.length()];
        inputAlphabet.getChars(0, inputAlphabet.length(), alphabet, 0);
        keyword = new CharRing("a");
    }


    protected int calculateOffSetCipher(int idx){
        return idx + currentOffset();
    }
    protected int calculateOffSetDecipher(int idx){
        return idx - currentOffset();
    }
    public void setKeyword(String srcString){
        keyword = new CharRing(srcString);
    }
    private int currentOffset(){
        return keyword.next() - super.alphabet[0];
    }
}