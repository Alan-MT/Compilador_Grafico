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
import java.util.HashMap;
import java.util.LinkedList;

public class Switch implements Instruccion {
    /**
     * Expresión sobre la cual se evaluarán los casos.
     */
    private final Operacion expresion;
    /**
     * Lista de casos y sus respectivas instrucciones.
     */
    private final LinkedList<Case> casos;

    public Switch(Operacion expresion, LinkedList<Case> casos) {
        this.expresion = expresion;
        this.casos = casos;
    }

    @Override
    public Object ejecutar(TablaDeSimbolos ts, Arbol ar) {
        Object valorExpresion = expresion.ejecutar(ts, ar);
        boolean casoEjecutado = false;

        for (Case caso : casos) {
            Object valorCaso = caso.getExpresion().ejecutar(ts, ar);
            if (valorExpresion.equals(valorCaso)) {
                TablaDeSimbolos tablaLocal = new TablaDeSimbolos();
                tablaLocal.addAll(ts);
                casoEjecutado = true;

                for (Instruccion instruccion : caso.getInstrucciones()) {
                    instruccion.ejecutar(tablaLocal, ar);
                }
                break;
            }
        }

        if (!casoEjecutado && casos.getLast().getExpresion() == null) {
            TablaDeSimbolos tablaLocal = new TablaDeSimbolos();
            tablaLocal.addAll(ts);
            for (Instruccion instruccion : casos.getLast().getInstrucciones()) {
                instruccion.ejecutar(tablaLocal, ar);
            }
        }

        return null;
    }
}
