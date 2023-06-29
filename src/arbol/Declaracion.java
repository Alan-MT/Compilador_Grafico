package arbol;

public class Declaracion implements Instruccion{

    private final String id;
    private boolean parametro;
    protected Simbolo.Tipo tipo;


    public Declaracion(String a, String b) {
        id=a;
        String reservadaTipo=b.toLowerCase();
        switch (reservadaTipo) {
            case "number": tipo=Simbolo.Tipo.NUMERO;
                     break;
            case "string":  tipo=Simbolo.Tipo.CADENA;
                     break;
            case "float": tipo= Simbolo.Tipo.FLOAT;
            default:
                tipo=null;
        }
        parametro=false;
    }
    
    @Override
    public Object ejecutar(TablaDeSimbolos ts, Arbol ar) {
        //ts.add(new Simbolo(id,tipo));
         Simbolo aux=new Simbolo(id,tipo);
        aux.setParametro(this.parametro);
        ts.add(aux);
        return null;
    }

    public String getIdentificador(){
        return id;
    }
    public boolean isParametro() {
        return parametro;
    }

    public void setParametro(boolean parametro) {
        this.parametro = parametro;
    }
    
    
    
}
