package roo2;

//import roo2.Cipher;

public class  CesarCipher extends SubstitutionCipher {
    int jump = 0;
    public  CesarCipher(int number, String inputAlphabet){
        super(inputAlphabet);
        jump = number;
    };

    public  CesarCipher(int number) {
        this(number, DEFAULT_ALPHABET);
    };
    protected int calculateOffSet(){
        return jump;
    }
    protected int calculateOffSetCipher(int idx){
        return idx + jump;
    }
    protected int calculateOffSetDecipher(int idx){
        return idx - jump;
    }


}