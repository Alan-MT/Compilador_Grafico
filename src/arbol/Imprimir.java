package arbol;

import java.util.ArrayList;
import javax.swing.JTextArea;

public class Imprimir implements Instruccion{

    private final Instruccion contenido;
    private JTextArea textArea2 = new JTextArea();
    private ArrayList<String> listaStrings = new ArrayList<>();

    public Imprimir(Instruccion contenido) {
        this.contenido = contenido;
    }

    public Imprimir(Instruccion contenido, JTextArea textArea) {
       this.contenido = contenido;
       this.textArea2 = textArea;
    }

    @Override
    public Object ejecutar(TablaDeSimbolos ts, Arbol ar) {
        Object imp = contenido.ejecutar(ts, ar);
        listaStrings.add(String.valueOf(imp));
        if(imp != null){
        System.out.println(String.valueOf(imp));
        textArea2.append(String.valueOf(imp));
        textArea2.append("\n");
        }

        return null;
    }
    
}
