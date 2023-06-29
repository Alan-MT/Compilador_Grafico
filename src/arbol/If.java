package arbol;

import java.util.LinkedList;


public class If implements Instruccion{

    private final LinkedList<Instruccion> subIfs;
    
    public If(SubIf a) {
        subIfs=new LinkedList<>();
        subIfs.add(a);
    }

    public If(SubIf a, LinkedList<SubIf> b) {
        subIfs=new LinkedList<>();
        subIfs.add(a);
        subIfs.addAll(b);
    }

    public If(SubIf a, LinkedList<SubIf> b, SubIf c) {
        subIfs=new LinkedList<>();
        subIfs.add(a);
        subIfs.addAll(b);
        subIfs.add(c);
    }

    public If(SubIf a, SubIf b) {
        subIfs=new LinkedList<>();
        subIfs.add(a);
        subIfs.add(b);
    }
    
    @Override
    public Object ejecutar(TablaDeSimbolos ts, Arbol ar) {
        //Ejecutar SubIfs
        Object r;
        for(Instruccion in: subIfs){
            r= in.ejecutar(ts, ar);
            if(((SubIf)in).getValorCondicion())
                return r;
        }
        return null;
    }
}
