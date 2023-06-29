package arbol;

import java.util.LinkedList;

public class Simbolo {
    private final Tipo tipo;
    private final String id;
    private Object valor;  
    private boolean parametro;
    private boolean parametroInicia;
    
    //private final LinkedList<Integer> tamanioDime;

    public Simbolo(String id, Tipo tipo) {
        this.tipo = tipo;
        this.id = id;
      //  this.tamanioDime = null;
        this.parametro = false;
        this.parametroInicia = false;
    }


    public String getId() {
        return id;
    }

    public Object getValor() {
        return valor;
    }

    void setValor(Object v) {
       // valor=v;
       Tipo vtipo = null;
       if(v instanceof Integer){
           vtipo = Simbolo.Tipo.NUMERO;
       } else if (v instanceof String){
           vtipo = Simbolo.Tipo.CADENA;
       } else if (v instanceof Float){
           vtipo = Simbolo.Tipo.FLOAT;
    }
       if(vtipo == tipo){
           valor=v;
       }else {
           System.err.println("Esta intentando asignar un valor de tipo ["+(vtipo==null?"null":vtipo.name())+"] a la variable ["+id+"] de tipo ["+tipo.name()+ "], esto no está permitido.");
       }
    }

    public static enum Tipo{
        NUMERO,
        CADENA,
        VOID,
        FLOAT
        }

    public boolean isParametro() {
        return parametro;
    }

    public void setParametro(boolean parametro) {
        this.parametro = parametro;
    }

    public boolean isParametroInicia() {
        return parametroInicia;
    }

    public void setParametroInicia(boolean parametroInicia) {
        this.parametroInicia = parametroInicia;
    }
    
}
