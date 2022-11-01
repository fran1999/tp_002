package roo2;
import java.util.ArrayList;
//import roo2.Cipher;

public class  BouncingIndex {
    int maxSize;

    ArrayList<Integer> numeros = new ArrayList<Integer>();
    
    public  BouncingIndex(int size){
        maxSize= size;

    };
    public void calcular(int n){
        int j=0;
        int [][] posiciones = new int [maxSize][n];//row, col
        int tamaño = n;
        boolean subeBaja= false;
        int posicion = 1;
        for (int i=0; i<tamaño; i++){
            if (j==0 || j == maxSize-1){
                subeBaja = !subeBaja;
            }
            posiciones[j][i] = posicion ;
            if(subeBaja){
                j++;
                posicion++;
            }else{
                j--;
                posicion--;
            }
        }
        //numeros = new ArrayList<Integer>();
        for (int i=0; i< n; i++){
            for (int k=0; k< maxSize; k++){
                if (posiciones[k][i] != 0){
                    numeros.add(posiciones[k][i]) ;
                }

            }
        }

    }
    /*public void calcularCipher(int n){
        int j=0;
        int [][] posiciones = new int [maxSize][n];//row, col
        int tamaño = n;
        boolean subeBaja= false;
        int posicion = 1;
        for (int i=0; i<tamaño; i++){
            if (j==0 || j == maxSize-1){
                subeBaja = !subeBaja;
            }
            posiciones[j][i] = posicion ;
            if(subeBaja){
                j++;
                posicion++;
            }else{
                j--;
                posicion++;
            }
        }
        //numeros = new ArrayList<Integer>();
        for (int k=0; k< maxSize; k++){
            for (int i=0; i< n; i++){
                if (posiciones[k][i] != 0){
                    numeros.add(posiciones[k][i]) ;
                }

            }
        }

    }*/
    public void calcularDecipher(int n){
        int j=0;
        int [][] posiciones = new int [maxSize][n];//row, col
        int tamaño = n;
        boolean subeBaja= false;
        for (int i=0; i<tamaño; i++){
            if (j==0 || j == maxSize-1){
                subeBaja = !subeBaja;
            }
            posiciones[j][i] = i+1;
            if(subeBaja){
                j++;
            }else{
                j--;
            }
        }
        //numeros = new ArrayList<Integer>();
        for (int k=0; k< maxSize; k++){
            for (int i=0; i< n; i++){
                if (posiciones[k][i] != 0){
                    numeros.add(posiciones[k][i]) ;
                }

            }
        }

    }

    public int next( ){
        return (numeros.remove(0)-1);
    }
    /*public int nextCipher(int posicion ){
        return numeros.get(posicion)-1;
    }*/
    public int nextDecipher(int posicion){
        return numeros.indexOf(posicion);
    }

}