package roo2;

//import roo2.Cipher;

public class  BouncingIndex {
    int maxSize;
    int maxSizeAux;
    int idx;
    
    public  BouncingIndex(int size){
        maxSize= size;
        maxSizeAux=size;
        idx = 0;
    };

    public int next( ){
        int result;
        if(maxSizeAux == 0){
            //para cuando llega a cero directamente va al siguente ya que si no llega a devolver dos veces cero
            maxSizeAux = maxSize;
            idx=1;
        }
        if((idx==maxSize)&&(maxSize != 1)){
            //para decrementar cuando se llega al maximo si no esta la primera condicion devuelve 2 veces el maximo rail
            //se pone que maxSize sea distinto de uno porque sino entra aca y decremeta dando numero negativo
            maxSizeAux--;
            idx--;
        }
        
        if (idx < maxSizeAux){
            result = idx++;
            }
        else { maxSizeAux--;
            result =  --idx;
        }
        return result;            
    }

}