package arbol;

import java.util.LinkedList;

public class TablaDeSimbolos extends LinkedList<Simbolo>{

    public TablaDeSimbolos() {
        super();
    }

    public Object getValor(String id) {
        //for(Simbolo s:this){
        for(int i = this.size()-1; i >= 0;i--){
            Simbolo s = this.get(i);
            if(s.isParametro() && s.isParametroInicia() || !s.isParametro()){
               if(s.getId().equals(id)){
                  Object aux = s.getValor();
                //return s.getValor();
                return aux;
            }
            }

        }
        System.out.println("La variable "+id+" no existe en este ámbito.");
        System.exit(0);
        return null;
        
    }

    public void setValor(String id, Object valor) {
        //for(Simbolo s:this){
        for(int i = this.size()-1; i >= 0; i--){
            Simbolo s = this.get(i);
            if(s.getId().equals(id)){
                s.setValor(valor);
                return;
            }
        }
        System.out.println("La variable "+id+" no existe en este ámbito, por lo "
                + "que no puede asignársele un valor.");
        System.exit(0);
    }
    
    public void setParametroInicia(String id){
        for(int i = this.size()-1; i >= 0; i--){
            Simbolo s = this.get(i);
            if(s.getId().equals(id)){
                s.setParametroInicia(true);
                return;
            }
        }
        System.out.println("El parámtro "+id+" que quiere marcar como inicializado no existe en este ámbito, por lo "
                + "que no puede marcar.");
        System.exit(0);
    }
    
}