# Compilador_Grafico

public Lexico(String inputString) {
    this();
    if (null == inputString) {
        throw new Error("Error: Bad input string initializer.");
    }
    yy_reader = new java.io.BufferedReader(new java.io.StringReader(inputString));
}
#  Agregar esto cuand se inicialice el Compilar.bat las clase lexico.java y sintactico.java

  public Sintactico(java_cup.runtime.Scanner s, JTextArea j) {super(s); this.textArea=j;}
