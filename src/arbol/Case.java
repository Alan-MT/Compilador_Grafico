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
public class Case {
     private final Operacion expresion;
    private final LinkedList<Instruccion> instrucciones;

    public Case(Operacion expresion, LinkedList<Instruccion> instrucciones) {
        this.expresion = expresion;
        this.instrucciones = instrucciones;
    }

    public Operacion getExpresion() {
        return expresion;
    }

    public LinkedList<Instruccion> getInstrucciones() {
        return instrucciones;
    }
}