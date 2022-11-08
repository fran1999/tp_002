package ar.edu.unlp.info.oo2.biblioteca.roo2;
import java.util.ArrayList;
//import roo2.Cipher;

public class  BouncingIndex {
    int maxSize;
    ArrayList<Integer> numeros = new ArrayList<Integer>();
    
    public  BouncingIndex(int size){
        maxSize= size;

    }

    public void CalcularlistaConPosiciones(int n){
        int [][] posiciones = new int [maxSize][n];//row, col
        crearMatrizConPosiciones(posiciones,n);
        crearListaConPosiciones(n,posiciones);
    }

    private void crearMatrizConPosiciones(int[][] posiciones, int tamaño) {
        int j=0;
        boolean subeBaja= false;
        for (int i = 0; i< tamaño; i++){
            if (j ==0 || j == maxSize-1){
                subeBaja = !subeBaja;
            }
            posiciones[j][i] = i+1;
            if(subeBaja && (maxSize != 1)){
                j++;
            }else if (maxSize != 1){
                j--;
            }
        }
    }

    private void crearListaConPosiciones(int n, int[][] posiciones) {
        for (int k=0; k< maxSize; k++){
            for (int i = 0; i< n; i++){
                if (posiciones[k][i] != 0){
                    numeros.add(posiciones[k][i]) ;
                }
            }
        }
    }
    public int nextCipher(int posicion ){
        return numeros.get(posicion)-1;
    }
    public int nextDecipher(int posicion){
        return numeros.indexOf(posicion);
    }

}