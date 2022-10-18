package roo2;

//import roo2.Cipher;

public class  CesarCipher extends SubstitutionCipher {
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


	@Override
	protected char callCipherChar(char inputChar) {
		// TODO Auto-generated method stub		
		return this.cipherChar(inputChar,this.jump);
	}

	@Override
	protected char callDecipherChar(char inputChar) {
		// TODO Auto-generated method stub
		return this.decipherChar(inputChar,this.jump);
	};
}