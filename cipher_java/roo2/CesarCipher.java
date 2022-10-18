package roo2;

//import roo2.Cipher;

public class  CesarCipher extends SubstitutionCipher {
	final String DEFAULT_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    char[] alphabet;
    int jump = 0;
    public  CesarCipher(int number, String inputAlphabet){
        alphabet = new char[inputAlphabet.length()];
        inputAlphabet.getChars(0,inputAlphabet.length(), alphabet, 0);
        jump = number;
    };

    public  CesarCipher(int number) {
        
        String inputAlphabet = DEFAULT_ALPHABET;
        alphabet = new char[inputAlphabet.length()];
        inputAlphabet.getChars(0,inputAlphabet.length(), alphabet, 0);
        jump = number;
    };


    protected char cipherChar( char inputChar){
        int offset;
        char result;
        int idx=java.util.Arrays.binarySearch(alphabet,inputChar);
        
        if(idx <0){
            result= inputChar;
        }
        else{ offset = idx + jump;
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
            offset = idx - jump;
            
            if(offset>=0){
                result= alphabet[offset];
            }
            else{
                result= alphabet[ alphabet.length + offset];
            }
        }
        return result;
    };
}