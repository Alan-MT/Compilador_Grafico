package arbol;

public class Asignacion implements Instruccion{

    protected final String id;

    //private final Operacion valor;
    protected TablaDeSimbolos Padre;
    protected final Instruccion valor;

    public Asignacion(String a, Instruccion b) {
        this.id=a;
        this.valor=b;
    }

    @Override
    public Object ejecutar(TablaDeSimbolos ts, Arbol ar) {
        //ts.setValor(id,valor.ejecutar(ts));
        if(Padre != null )
            ts.setValor(id, valor.ejecutar(Padre, ar));
        else 
            ts.setValor(id, valor.ejecutar(ts, ar));
        return null;
    }

    public void setPadre(TablaDeSimbolos ts) {
        this.Padre = ts;
    }
    
    
    
}
