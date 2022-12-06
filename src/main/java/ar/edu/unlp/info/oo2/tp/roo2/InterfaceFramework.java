package ar.edu.unlp.info.oo2.tp.roo2;

public class InterfaceFramework {
	
    public InterfaceFramework(){
    }
    public RailFenceCipher crearRailFence(int rails){
        return new RailFenceCipher(rails);
    }
    public VigenereCipher crearVigenere (String alphabet,String keyword){
        return  new VigenereCipher(alphabet,keyword);
    }
    public VigenereCipher crearCesar (String alphabet,int jump){
        int index = jump % alphabet.length();
        String keyword = Character.toString(alphabet.charAt(index));
        return  new VigenereCipher(alphabet,keyword);
    }
    
    public ColumnarTranspositionCipher crearColumnar (String keyword) {
    	return new ColumnarTranspositionCipher(keyword);
    }
}
