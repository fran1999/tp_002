package roo2;

import roo2.BouncingIndex;

public class  RailFenceCipher implements Cipher {
    String[] rails;
    BouncingIndex bIndex; //renombrar bIndex

    public  RailFenceCipher(int railCount){
        rails = new String[railCount];
        for (int index =0; index < rails.length; index++)
            rails[index]="";
        bIndex = new BouncingIndex(railCount);

    };


    public String cipher(String inputText){
        String result = "";
        char inputChar[] = new char[inputText.length()];
        inputText.getChars(0,inputText.length(), inputChar, 0);
        bIndex.CalcularlistaConPosiciones(inputText.length());

        for(int index =0; index < inputText.length(); index++){
            int rIndex= bIndex.nextCipher(index);
            //rails[rIndex]+=  inputChar[index];
            result += inputChar[rIndex];
        }
        return result;
    }

    public String decipher(String inputText){
        String result = "";
        char inputChar[] = new char[inputText.length()];
        inputText.getChars(0,inputText.length(), inputChar, 0);
        bIndex.CalcularlistaConPosiciones(inputText.length());

        for(int index =0; index < inputText.length(); index++){
            int rIndex= bIndex.nextDecipher(index+1);
            //rails[rIndex]+=  inputChar[index];
            result += inputChar[rIndex];
        }
        return result;
    }
}