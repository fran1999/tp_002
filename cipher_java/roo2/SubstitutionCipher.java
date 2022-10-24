package roo2;

public abstract class SubstitutionCipher implements Cipher{
	final static String DEFAULT_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    char[] alphabet;

    public SubstitutionCipher(String inputAlphabet){
        alphabet = this.obtenerArreglodeStrings(inputAlphabet);
    }
    
	@Override
	public String cipher(String inputText) {
        char[] result = this.obtenerArreglodeStrings(inputText);

        for (int idx=0; idx < result.length; idx++)
            result[idx]=cipherChar(result[idx]);
        return new String(result); //alphabet[inputText.length()];
	}

	@Override
	public String decipher(String inputText) {
        char[] result = this.obtenerArreglodeStrings(inputText);

        for (int idx=0; idx < result.length; idx++)
            result[idx]=decipherChar(result[idx]);
        return new String(result); 
	}

    private char[] obtenerArreglodeStrings(String inputText){
        char[] arreglo = new char[inputText.length()] ;
        inputText.getChars(0, inputText.length(), arreglo, 0);
        return arreglo;
    }

    protected abstract int calculateOffSetCipher(int idx);

    protected abstract int calculateOffSetDecipher(int idx);

    protected char cipherChar( char inputChar){
        char result;
        int idx=java.util.Arrays.binarySearch(alphabet,inputChar);
        
        if(idx <0){
            result= inputChar;
        }
        else{
            result = getResultCipher(calculateOffSetCipher(idx));
        }
        return result;

    }

    protected char decipherChar( char inputChar){
        char result;
        int idx=java.util.Arrays.binarySearch(alphabet,inputChar);

        if(idx <0){
            result =inputChar;
        }
        else{
            result = getResultDecipher(calculateOffSetDecipher(idx));
        }
        return result;
    }

    private char getResultCipher(int offset) {
        if(offset < alphabet.length){
            return alphabet[offset];
        }
        else{
            return alphabet[offset - alphabet.length];
        }
    }

    private char getResultDecipher(int offset) {
        if(offset>=0){
            return alphabet[offset];
        }
        else{
            return alphabet[ alphabet.length + offset];
        }
    }
}