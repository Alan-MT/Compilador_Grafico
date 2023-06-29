package Inicio;

import arbol.Arbol;
import arbol.TablaDeSimbolos;
import java.io.FileInputStream;




public class Inicio {

/*
    public static void main(String[] args) {
        interpretar("entrada.txt");
    }

    private static void interpretar(String path) {
        analizadores.Sintactico pars;
       // LinkedList<Instruccion> AST_arbolSintaxisAbstracta=null;
        Arbol arbolSinta = null;
       try {
            pars=new analizadores.Sintactico(new analizadores.Lexico(new FileInputStream(path)));
            pars.parse();        
            arbolSinta = pars.getAST();
        } catch (Exception ex) {
            System.out.println("Error fatal en compilación de entrada.");
            
        } 
       if(arbolSinta == null){
            System.err.println("No es posible ejecutar las instrucciones porque\r\n"
                    + "el árbol no fue cargado de forma adecuada por la existencia\r\n"
                    + "de errores léxicos o sintácticos.");
            return;
        }
        //ejecutarAST(AST_arbolSintaxisAbstracta);
        TablaDeSimbolos ts = new TablaDeSimbolos();
        arbolSinta.ejecutar(ts, arbolSinta);
    }
 /*
    private static void ejecutarAST(LinkedList<Instruccion> ast) {
        if(ast==null){
            System.out.println("No es posible ejecutar las instrucciones porque\r\n"
                    + "el árbol no fue cargado de forma adecuada por la existencia\r\n"
                    + "de errores léxicos o sintácticos.");
            System.exit(0);
            return;
        }
        //Se crea una tabla de símbolos global para ejecutar las instrucciones.
        TablaDeSimbolos ts=new TablaDeSimbolos();
        //Se ejecuta cada instruccion en el ast, es decir, cada instruccion de 
        //la lista principal de instrucciones.
        for(Instruccion ins:ast){
            //Si existe un error léxico o sintáctico en cierta instrucción esta
            //será inválida y se cargará como null, por lo tanto no deberá ejecutarse
            //es por esto que se hace esta validación.
            if(ins!=null)
                ins.ejecutar(ts);
        }
    }*/
}
