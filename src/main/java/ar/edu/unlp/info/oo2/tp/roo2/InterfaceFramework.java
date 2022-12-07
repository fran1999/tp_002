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
    public VigenereCipher crearVigenere (){
        return  new VigenereCipher();
    }
    public VigenereCipher crearCesar (String alphabet,int jump){
        if (!alphabet.equals("")) {
            int index = jump % alphabet.length();
            String keyword = Character.toString(alphabet.charAt(index));
            return new VigenereCipher(alphabet, keyword);
        }
        else{
            return new VigenereCipher("abcdefghijklmnopqrstuvwxyz", "a");
        }
    }
    public VigenereCipher crearCesar (int jump){
        String alphabet="abcdefghijklmnopqrstuvwxyz";
        int index = jump % alphabet.length();
        String keyword = Character.toString(alphabet.charAt(index));
        VigenereCipher v = new VigenereCipher();
        v.setKeyword(keyword);
        return  v;
    }
    
    public ColumnarTranspositionCipher crearColumnar (String keyword) {
    	return new ColumnarTranspositionCipher(keyword);
    }
    
    public ComplexCipher crearComplexCipher () {
    	return new ComplexCipher();
    }
}
