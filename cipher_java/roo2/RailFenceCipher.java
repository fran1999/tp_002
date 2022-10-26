package roo2;

import roo2.BouncingIndex;

public class  RailFenceCipher implements Cipher {
    String[] rails;
    BouncingIndex bIndex;

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

        for(int index =0; index < inputText.length(); index++){
            int rIndex= bIndex.next();            
            rails[rIndex]+=  inputChar[index]; 
        }

        for(int index=0; index < rails.length; index++){
            result += rails[index];
        }
        return result; 
    }; 

    public String decipher(String inputText){
        return this.decryption(inputText, this.rails.length);
    }


    public String decryption(String cipherText,int depth)
    {
        int r=depth,len=cipherText.length();
        int c=len/depth;
        char mat[][]=new char[r][c];
        int k=0;

        String plainText="";


        for(int i=0;i< r;i++)
        {
            for(int j=0;j< c;j++)
            {
                mat[i][j]=cipherText.charAt(k++);
            }
        }
        for(int i=0;i< c;i++)
        {
            for(int j=0;j< r;j++)
            {
                plainText+=mat[j][i];
            }
        }

        return plainText;
    }

}