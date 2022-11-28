package ar.edu.unlp.info.oo2.tp.roo2;

public class VigenereFactory implements CipherFactory{
    @Override
    public Cipher createCipher(){
        return new VigenereCipher();
    }
    public VigenereCipher createCipher(String alphaber, String Kword){
        return new VigenereCipher(alphaber,Kword);
    }

}
