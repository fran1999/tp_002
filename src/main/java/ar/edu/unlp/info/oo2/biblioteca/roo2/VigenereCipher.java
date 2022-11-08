package ar.edu.unlp.info.oo2.biblioteca.roo2;

import ar.edu.unlp.info.oo2.biblioteca.roo2.CharRing;

//import roo2.Cipher;

public class  VigenereCipher extends SubstitutionCipher {
    CharRing keyword;

    public VigenereCipher(String inputAlphabet, String kword) {
        super(inputAlphabet);
        setKeyword(kword);
    }

    public VigenereCipher() {
        this(DEFAULT_ALPHABET,"a");
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