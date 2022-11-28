package ar.edu.unlp.info.oo2.tp.roo2;

public class InterfaceFramework {
    RailFenceFactory r;
    VigenereFactory v;

    public InterfaceFramework(){
        r = new RailFenceFactory();
        v = new VigenereFactory();
    }
    public RailFenceCipher crearRailFence(int rails){
        return (RailFenceCipher) r.createCipher(rails);
    }
    public VigenereCipher crearVigere (String alphabet,String keyword){
        return  (VigenereCipher) v.createCipher(alphabet,keyword);
    }
    public VigenereCipher crearCesar (String alphabet,int jump){
        int index = jump % alphabet.length();
        String keyword = Character.toString(alphabet.charAt(index));
        return  (VigenereCipher) v.createCipher(alphabet,keyword);
    }
}
