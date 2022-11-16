package ar.edu.unlp.info.oo2.tp.roo2;

public class CesarCreator extends CipherCreator{

	@Override
	public Cipher factoryMethod() {
		// TODO Auto-generated method stub
		return new CesarProvider();
	}

}
