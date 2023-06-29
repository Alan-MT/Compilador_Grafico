package arbol;

public class Operacion implements Instruccion{
    
     // Enumeración del tipo de operación que puede ser ejecutada por esta clase.
     
    public static enum Tipo_operacion{
        SUMA,
        RESTA,
        MULTIPLICACION,
        DIVISION,
        NEGATIVO,
        NUMERO,
        IDENTIFICADOR,
        CADENA,
        FLOAT,
        MAYOR_QUE,
        MENOR_QUE,
        MAYOR_IGUAL_QUE,
        MENOR_IGUAL_QUE,
        DIFERENTE_QUE,
        IGUAL_QUE
    }

    private final Tipo_operacion tipo;

    //private Operacion operadorIzq;
    private Instruccion operadorIzq;
    
    //private Operacion operadorDer;
    private Instruccion operadorDer;
 
    private Object valor;
    
    public Operacion(Instruccion operadorIzq, Instruccion operadorDer, Tipo_operacion tipo) {
        this.tipo = tipo;
        this.operadorIzq = operadorIzq;
        this.operadorDer = operadorDer;
    }

    //public Operacion(Operacion operadorIzq, Tipo_operacion tipo) {
    public Operacion(Instruccion operadorIzq, Tipo_operacion tipo){
        this.tipo = tipo;
        this.operadorIzq = operadorIzq;
    }

    public Operacion(String a, Tipo_operacion tipo) {
        this.valor=a;
        this.tipo = tipo;
    }

    public Operacion(Integer a) {
        this.valor=a;
        this.tipo = Tipo_operacion.NUMERO;
    }
        
  
    @Override
    public Object ejecutar(TablaDeSimbolos ts, Arbol ar) {
        Object a = (operadorIzq==null)?null:operadorIzq.ejecutar(ts, ar);
        Object b = (operadorDer==null)?null:operadorDer.ejecutar(ts, ar);
        
        if(tipo== Tipo_operacion.DIVISION){
            if(a instanceof Integer && b instanceof Integer){
                return (Integer)a / (Integer)b;
            }else{
                System.err.println("Error, la división debe hacerse entre números.");
                System.exit(0);
                return null;
            }
        }else if(tipo== Tipo_operacion.MULTIPLICACION){
            if(a instanceof Integer && b instanceof Integer){
                return (Integer)a * (Integer)b;
            }else{
                System.err.println("Error , la multiplicación debe hacerse entre números.");
                System.exit(0);
                return null;
            }
        }else if(tipo== Tipo_operacion.RESTA){
            if(a instanceof Integer && b instanceof Integer){
                return (Integer)a - (Integer)b;
            }else{
                System.err.println("Error , la resta debe hacerse entre números.");
                System.exit(0);
                return null;
            }
        }else if(tipo== Tipo_operacion.SUMA){
            if(a instanceof Integer && b instanceof Integer){
                return (Integer)a + (Integer)b;
            }else{
                System.err.println("Error , la suma debe hacerse entre números.");
                System.exit(0);
                return null;
            }
        }else if(tipo== Tipo_operacion.NEGATIVO){
            if(a instanceof Integer){
                return (Integer)a * -1;
            }else{
                System.err.println("Error , el operador negativo debe aplicarse a un número.");
                System.exit(0);
                return null;
            }
        }else if(tipo== Tipo_operacion.NUMERO){
            return new Integer(valor.toString());
        }else if(tipo== Tipo_operacion.IDENTIFICADOR){
            return ts.getValor(valor.toString());
        }else if(tipo== Tipo_operacion.CADENA){
            return valor.toString();
        }else if(tipo == Tipo_operacion.FLOAT){
            return new Float(valor.toString());
        }else if(tipo== Tipo_operacion.MAYOR_QUE){
            if(a instanceof Integer && b instanceof Integer){
                return (Boolean)(((Integer)a).doubleValue()>((Integer)b).doubleValue());
            }else{
                System.err.println("Error de tipos, la comparación mayor que debe hacerse entre números.");
                System.exit(0);
                return null;
            }
        }else if(tipo== Tipo_operacion.MENOR_QUE){
            if(a instanceof Integer && b instanceof Integer){
                return (Boolean)(((Integer)a).intValue()<((Integer)b).intValue());
            }else{
                System.err.println("Error de tipos, la comparación menor que debe hacerse entre números.");
                System.exit(0);
                return null;
            }
        }else if(tipo== Tipo_operacion.MENOR_IGUAL_QUE){
            if(a instanceof Integer && b instanceof Integer){
                return (Boolean)(((Integer)a).intValue()<=((Integer)b).intValue());
            }else{
                System.err.println("Error de tipos, la comparación menor o igual que debe hacerse entre números.");
                System.exit(0);
                return null;
            }
        }else if(tipo== Tipo_operacion.MAYOR_IGUAL_QUE){
            if(a instanceof Integer && b instanceof Integer){
                return (Boolean)(((Integer)a).intValue()>=((Integer)b).intValue());
            }else{
                System.err.println("Error de tipos, la comparación mayor o igual que debe hacerse entre números.");
                System.exit(0);
                return null;
            }
        }else if(tipo== Tipo_operacion.DIFERENTE_QUE){
            if(a instanceof Integer && b instanceof Integer){
                return (Boolean)(((Integer)a).intValue()!=((Integer)b).intValue());
            }else{
                System.err.println("Error de tipos, la comparación diferente que debe hacerse entre números.");
                System.exit(0);
                return null;
            }
        }else if(tipo== Tipo_operacion.IGUAL_QUE){
            if(a instanceof Integer && b instanceof Integer){
                return (Boolean)(((Integer)a).intValue()==((Integer)b).intValue());
            }else{
                System.err.println("Error de tipos, la comparación igual que debe hacerse entre números.");
                System.exit(0);
                return null;
            }
       
        }else{
            return null;
        }
      
    }    
}
