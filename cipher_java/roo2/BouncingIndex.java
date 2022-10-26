package roo2;

//import roo2.Cipher;

public class  BouncingIndex {
    int maxSize;
    int maxSizeAux;
    int index;
    
    public  BouncingIndex(int size){
        maxSize= size;
        maxSizeAux=size;
        index = 0;
    };

    public int next( ){
        int result;
        if(maxSizeAux == 0){
            //para cuando llega a cero directamente va al siguente ya que si no llega a devolver dos veces cero
            maxSizeAux = maxSize;
            index=1;
        }
        if((index==maxSize)&&(maxSize != 1)){
            //para decrementar cuando se llega al maximo si no esta la primera condicion devuelve 2 veces el maximo rail
            //se pone que maxSize sea distinto de uno porque sino entra aca y decremeta dando numero negativo
            maxSizeAux--;
            index--;
        }
        
        if (index < maxSizeAux){
            result = index++;
            }
        else { maxSizeAux--;
            result =  --index;
        }
        return result;            
    }

}