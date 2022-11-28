package ar.edu.unlp.info.oo2.tp.roo2;

public class RailFenceFactory implements CipherFactory{

    public Cipher createCipher(){
        return new RailFenceCipher();
    }
    public Cipher createCipher(int rails){
        return new RailFenceCipher(rails);
    }

}
