/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;

/**
 *
 * @author alanm
 */
public class Return implements Instruccion{
    
    private final Instruccion valorRetorno;
    
    public Return(Instruccion a){
        valorRetorno=a;
    }
    
    public Return(){
        valorRetorno=null;
    }

    @Override
    public Object ejecutar(TablaDeSimbolos ts, Arbol ar) {
        if(valorRetorno==null){
            return this;
        } else{
            return valorRetorno.ejecutar(ts, ar);
        }
    }
    
}
