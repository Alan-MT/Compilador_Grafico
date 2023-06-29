/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;

import java.util.LinkedList;

/**
 *
 * @author alanm
 */
public class Arbol implements Instruccion{

    private final LinkedList<Instruccion> instrucciones;
    public TablaDeSimbolos TablaSimbolosGlobal;
    
    public Arbol(LinkedList<Instruccion> a){
        instrucciones = a;
    }
    
    
    @Override
    public Object ejecutar(TablaDeSimbolos ts, Arbol ar) {
        TablaSimbolosGlobal = ts;
        
        for(Instruccion ins:instrucciones){
            if(ins instanceof Declaracion){
                Declaracion d = (Declaracion)ins;
                d.ejecutar(ts, ar);
            }
        }
        for(Instruccion ins: instrucciones){
            if(ins instanceof Funcion){
                Funcion f = (Funcion)ins;
                String id = f.getIdentificador();
                
                if("_main()".equals(id)){
                    f.setValoresParametros(new LinkedList<>());
                    f.ejecutar(ts, ar);
                    break;  
                }
                
            }
        }
        return null;
    }
    
    public Funcion getFuncion(String identifcador){
        for(Instruccion ins: instrucciones){
            if(ins instanceof Funcion){
                Funcion fun=(Funcion)ins;
                String id = fun.getIdentificador();
                if(identifcador.equals(id)){
                    return fun;
                }
            }
        }
        return null;
    }
    
}
