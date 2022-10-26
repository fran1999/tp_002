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

        for (int index=0; index < result.length; index++)
            result[index]=cipherChar(result[index]);
        return new String(result); //alphabet[inputText.length()];
	}

	@Override
	public String decipher(String inputText) {
        char[] result = this.obtenerArreglodeStrings(inputText);

        for (int index=0; index < result.length; index++)
            result[index]=decipherChar(result[index]);
        return new String(result); 
	}

    private char[] obtenerArreglodeStrings(String inputText){
        char[] arreglo = new char[inputText.length()] ;
        inputText.getChars(0, inputText.length(), arreglo, 0);
        return arreglo;
    }

    protected abstract int calculateOffSetCipher(int index);

    protected abstract int calculateOffSetDecipher(int index);

    protected char cipherChar( char inputChar){
        char result;
        int index=java.util.Arrays.binarySearch(alphabet,inputChar);
        
        if(index <0){
            result= inputChar;
        }
        else{
            result = getResultCipher(calculateOffSetCipher(index));
        }
        return result;

    }

    protected char decipherChar( char inputChar){
        char result;
        int index=java.util.Arrays.binarySearch(alphabet,inputChar);

        if(index <0){
            result =inputChar;
        }
        else{
            result = getResultDecipher(calculateOffSetDecipher(index));
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