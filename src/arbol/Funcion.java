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
public class Funcion implements Instruccion{

    private final Simbolo.Tipo tipo;
    private final String identificador;
    private final LinkedList<Declaracion> parametros;
    private LinkedList<Instruccion> valoresParametros;
    private final LinkedList<Instruccion> instrucciones;
    
    //Recibe Parametros
    public Funcion(String TipoF, String IdFun, LinkedList<Declaracion> Decla, LinkedList<Instruccion> instr){
        switch(TipoF.toLowerCase()){
            case "number": tipo=Simbolo.Tipo.NUMERO;
            break;
            case "string": tipo=Simbolo.Tipo.CADENA;
            break;
            case "void": tipo=Simbolo.Tipo.VOID;
            break;
            default:
            tipo=null;
            
        }
        identificador= IdFun;
        parametros= Decla;
        instrucciones= instr;
    }
    
    //No recibe Parametros
    
    public Funcion(String tipoF, String idFun, LinkedList<Instruccion> instr){
        String reservadaTipo = tipoF.toLowerCase();
                switch (reservadaTipo) {
            case "number": tipo=Simbolo.Tipo.NUMERO;
                     break;
            case "string":  tipo=Simbolo.Tipo.CADENA;
                     break;
            case "void": tipo=Simbolo.Tipo.VOID;
                     break;
            default:
                tipo=null;
        }
        identificador=idFun;
        parametros=new LinkedList<>();
        instrucciones=instr;
    }
    @Override
    public Object ejecutar(TablaDeSimbolos ts, Arbol ar) {
        TablaDeSimbolos tablaLocal = new TablaDeSimbolos();
        tablaLocal.addAll(ar.TablaSimbolosGlobal);
        if (parametros.size() == valoresParametros.size()) {
            for (int i = 0; i < parametros.size(); i++) {
                Declaracion declara = parametros.get(i);
                declara.setParametro(true);
                declara.ejecutar(tablaLocal, ar);
                
                Asignacion asig = new Asignacion(declara.getIdentificador(), valoresParametros.get(i));
                asig.setPadre(ts);
                asig.ejecutar(tablaLocal, ar);
                tablaLocal.setParametroInicia(declara.getIdentificador());
            }
            for (Instruccion ins : instrucciones) {
                Object r;
                r = ins.ejecutar(tablaLocal, ar);
                if (r != null) {
                    if (r instanceof Break) {
                        System.err.println("La sentencia break no se encuentra dentro de un ciclo");
                        System.exit(0);
                        return null;
                    }
                    return r;
                }
            }
        } else {
            System.err.println("La cantidad de parámetros enviada a la función " + identificador + " no es correcta.");
            System.exit(0);
        }
        return null;
    }
    
    public String getIdentificador(){
        String id ="_"+ identificador + "(";
        if(parametros != null){
            for(Declaracion parametro: parametros){
                id += "_" + parametro.tipo.name();
            }
        }
        id +=")";
        return id.toLowerCase();
    }

    public Simbolo.Tipo getTipo() {
        return tipo;
    }

    public LinkedList<Instruccion> getValoresParametros() {
        return valoresParametros;
    }

    public void setValoresParametros(LinkedList<Instruccion> valoresParametros) {
        this.valoresParametros = valoresParametros;
    }

    public LinkedList<Declaracion> getParametros() {
        return parametros;
    }
    
    
}
