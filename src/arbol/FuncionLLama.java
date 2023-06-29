package arbol;

import java.util.LinkedList;

/**
 *
 * @author alanm
 */
public class FuncionLLama implements Instruccion{

    private final String identificador;
    private final LinkedList<Instruccion> parametros;
    
    public FuncionLLama(String id, LinkedList<Instruccion> inst){
        identificador=id;
        parametros=inst;
    }
    
    @Override
    public Object ejecutar(TablaDeSimbolos ts, Arbol ar) {
        String id = "_" + identificador +"(";
        for(Instruccion paramaetro: parametros){
            Object result = paramaetro.ejecutar(ts, ar);
            if(result instanceof Integer){
                id += "_" + Simbolo.Tipo.NUMERO;
            } else if(result instanceof String) {
                id += "_" + Simbolo.Tipo.CADENA;
            
            }
           
        } id += ")";
        
        Funcion fun= ar.getFuncion(id.toLowerCase());
        if (null != fun) {
            fun.setValoresParametros(parametros);
            Object resultFun = fun.ejecutar(ts, ar);
            if (fun.getTipo() == Simbolo.Tipo.VOID && !(resultFun instanceof Return || resultFun == null)) {
                System.err.println("Una función de tipo Void no puede retornar valores, solamente puede retornar vacío.");
                System.exit(0);
                return null;
            } else if (fun.getTipo() != Simbolo.Tipo.VOID && resultFun instanceof Return) {
                System.err.println("La funcion necesita un valor de retorno");
                System.exit(0);
                return null;
            } else if (fun.getTipo() != Simbolo.Tipo.VOID && resultFun == null) {
                System.err.println("Hace falta una sentencia de retorno en la función");
                System.exit(0);
                return null;
            }else if(fun.getTipo()==Simbolo.Tipo.NUMERO && !(resultFun instanceof Integer)){
                System.err.println("Una función de tipo Number no puede retornar un valor que no sea numérico.");
                System.exit(0);
                return null;
            }else if(fun.getTipo()==Simbolo.Tipo.CADENA && !(resultFun instanceof String)){
                System.err.println("Una función de tipo Cadena no puede retornar un valor que no sea una cadena de caracteres.");
                System.exit(0);
                return null;
            }
            if(resultFun instanceof Return){
                return null;
            }else{
                return resultFun;
            }
        } else {
            System.err.println("La función " + identificador + " no existe.");
            System.exit(0);
        }
        return null;
    }
    
}
