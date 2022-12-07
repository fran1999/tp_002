package ar.edu.unlp.info.oo2.tp.roo2;

public class  RailFenceCipher implements Cipher {

    BouncingIndex bouncingIndex; //renombrar bIndex

    public  RailFenceCipher(){
        bouncingIndex = new BouncingIndex(3);
    }

    public  RailFenceCipher(int railCount){
        bouncingIndex = new BouncingIndex(railCount);

    };


    public String cipher(String inputText){
        String result = "";
        char inputChar[] = new char[inputText.length()];
        inputText.getChars(0,inputText.length(), inputChar, 0);
        bouncingIndex.CalcularlistaConPosiciones(inputText.length());

        for(int index =0; index < inputText.length(); index++){
            int rIndex= bouncingIndex.nextCipher(index);
            //rails[rIndex]+=  inputChar[index];
            result += inputChar[rIndex];
        }
        return result;
    }

    public String decipher(String inputText){
        String result = "";
        char inputChar[] = new char[inputText.length()];
        inputText.getChars(0,inputText.length(), inputChar, 0);
        bouncingIndex.CalcularlistaConPosiciones(inputText.length());

        for(int index =0; index < inputText.length(); index++){
            int rIndex= bouncingIndex.nextDecipher(index+1);
            //rails[rIndex]+=  inputChar[index];
            result += inputChar[rIndex];
        }
        return result;
    }
}