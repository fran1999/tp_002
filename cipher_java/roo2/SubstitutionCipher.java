package roo2;

public abstract class SubstitutionCipher implements Cipher{
	final static String DEFAULT_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    char[] alphabet;

    public SubstitutionCipher(String inputAlphabet){
        alphabet = new char[inputAlphabet.length()];
        inputAlphabet.getChars(0, inputAlphabet.length(), alphabet, 0);
    }
    
	@Override
	public String cipher(String inputText) {
        char[] result = new char[inputText.length()] ;
        inputText.getChars(0, inputText.length(), result, 0);

        for (int idx=0; idx < result.length; idx++)
            result[idx]=cipherChar(result[idx]);
        return new String(result); //alphabet[inputText.length()];
	}

	@Override
	public String decipher(String inputText) {
        char[] result = new char[inputText.length()] ;
        inputText.getChars(0, inputText.length(), result, 0);

        for (int idx=0; idx < result.length; idx++)
            result[idx]=decipherChar(result[idx]);
        return new String(result); 
	}

    protected abstract int calculateOffSetCipher(int idx);


    protected abstract int calculateOffSetDecipher(int idx);


    protected char cipherChar( char inputChar){
        int offset;
        char result;
        
        int idx=java.util.Arrays.binarySearch(alphabet,inputChar);
        
        if(idx <0){
            result= inputChar;
        }
        else{
            offset = calculateOffSetCipher(idx);

            if(offset < alphabet.length){
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
            offset = calculateOffSetDecipher(idx);
            
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
