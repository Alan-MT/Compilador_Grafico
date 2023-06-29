package arbol;
/**
 *
 * @author alanm
 */
import java.util.LinkedList;

public class While implements Instruccion{

    //private final Operacion condicion;
    private final Instruccion condicion;

    private final LinkedList<Instruccion> listaInstrucciones;

    public While(Instruccion inst, LinkedList<Instruccion> lista) {
        this.condicion=inst;
        this.listaInstrucciones=lista;
    }

    @Override
    public Object ejecutar(TablaDeSimbolos ts, Arbol ar) {
        while((Boolean)condicion.ejecutar(ts, ar)){
            TablaDeSimbolos tablaLocal=new TablaDeSimbolos();
            tablaLocal.addAll(ts);
            for(Instruccion ins:listaInstrucciones){
                Object result = ins.ejecutar(tablaLocal, ar);
                if(result != null){
                    if(result instanceof Break){
                        return null;
                    } else {
                        return result;
                    }
                }
            }
        }
        return null;
    }   
}
