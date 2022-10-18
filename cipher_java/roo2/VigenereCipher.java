package roo2;

import roo2.CharRing;

//import roo2.Cipher;

public class  VigenereCipher extends SubstitutionCipher {
    char[] alphabet;
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

    protected char cipherChar( char inputChar){
        int offset;
        char result;
        
        int idx=java.util.Arrays.binarySearch(alphabet,inputChar);
        
        if(idx <0){
            result= inputChar;
        }
        else{ offset = idx + this.currentOffset();
            if(offset<alphabet.length){
                result= alphabet[offset];
            }
            else{
                result= alphabet[offset - alphabet.length];
            }
        }
        return result;

    };

    protected char decipherChar( char inputChar){
        int offset;
        char result;
        int idx=java.util.Arrays.binarySearch(alphabet,inputChar);
        
        if(idx <0){
            result =inputChar;
        }
        else{ 
            offset = idx - this.currentOffset();
            
            if(offset>=0){
                result= alphabet[offset];
            }
            else{
                result= alphabet[ alphabet.length + offset];
            }
        }
        return result;
    };
    public void setKeyword(String srcString){
        keyword = new CharRing(srcString);
    }
    private int currentOffset(){
        return keyword.next()- alphabet[0];
    }
}