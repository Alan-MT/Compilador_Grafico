package arbol;

/**
 *
 * @author alanm
 */
import java.util.LinkedList;


public class For implements Instruccion{

    private final Asignacion inicializador;

   // private final Operacion condicion;
    
    private final Instruccion condi;

    private final Asignacion incrementador;

    private final LinkedList<Instruccion> listaInstrucciones;

    public For(Asignacion a, Instruccion b, Asignacion c, LinkedList<Instruccion> d) {
        inicializador=a;
        condi=b;
        incrementador=c;
        listaInstrucciones=d;
    }

    @Override
    public Object ejecutar(TablaDeSimbolos ts, Arbol ar) {
        inicializador.ejecutar(ts, ar);
        while((Boolean)condi.ejecutar(ts,ar)){
            incrementador.ejecutar(ts,ar);
            TablaDeSimbolos tablaLocal=new TablaDeSimbolos();
            tablaLocal.addAll(ts);
            for(Instruccion ins:listaInstrucciones){
                Object r = ins.ejecutar(tablaLocal, ar);
                if(r != null){
                    if(r instanceof Break){
                        return null;
                    } else {
                        return r;
                    }
                }
            }
        }
        return null;
    }   
}