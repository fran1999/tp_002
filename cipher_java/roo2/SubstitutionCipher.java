package roo2;

public abstract class SubstitutionCipher implements Cipher{
	final String DEFAULT_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    char[] alphabet;
    
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
    protected abstract char cipherChar(char inputChar);

    protected abstract char decipherChar(char inputChar);
}
