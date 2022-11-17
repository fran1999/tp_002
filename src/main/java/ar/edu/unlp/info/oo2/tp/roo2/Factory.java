package ar.edu.unlp.info.oo2.tp.roo2;


public class Factory {
	
	private String calculateIndex(String alfabeto,int jump) {
		int index = jump % alfabeto.length();
		String character = Character.toString(alfabeto.charAt(index));
		return character;
	}

    public VigenereCipher getCesarCipher(String alfabeto, int salto){
    	return new VigenereCipher(alfabeto,calculateIndex(alfabeto,salto));
    }

    public Cipher getVigenereCipher(String alfabeto, String clave){
        return new VigenereCipher(alfabeto,clave);
    }
}