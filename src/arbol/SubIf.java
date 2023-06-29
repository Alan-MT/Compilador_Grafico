package arbol;

import java.util.LinkedList;

public class SubIf implements Instruccion{

    private Boolean valorCondicion;
    
      //Bandera que indica si la sub instrucción es Else o no.
     
    private final boolean isElse;

    //private final Operacion condicion;
    private final Instruccion condicion;

    private final LinkedList<Instruccion> listaInstrucciones;

    public SubIf(Instruccion a, LinkedList<Instruccion> b) {
        condicion=a;
        listaInstrucciones=b;
        isElse=false;
    }

    public SubIf(LinkedList<Instruccion> a) {
        condicion=null;
        listaInstrucciones=a;
        isElse=true;
    }

    public Boolean getValorCondicion() {
        return valorCondicion || isElse;
    }
   
    @Override
    public Object ejecutar(TablaDeSimbolos ts, Arbol ar) {
        valorCondicion=((condicion==null)?false:(Boolean)condicion.ejecutar(ts, ar));        
        if(valorCondicion || isElse){
            TablaDeSimbolos tablaLocal=new TablaDeSimbolos();
            tablaLocal.addAll(ts);
            for(Instruccion in: listaInstrucciones){
                Object result;
                result= in.ejecutar(tablaLocal, ar);
                if(result != null){
                    return result;
                }
            }
        }
        return null;
    }
}
