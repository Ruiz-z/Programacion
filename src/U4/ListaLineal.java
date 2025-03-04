package U4;

/** CLASE INSTANCIABLE PARA MANEJAR UNA LISTA ENLAZADA LINEAL Ó SIMPLE 
 * La lista que vamos a estar manejando tiene 2 atributos:
 * - el apuntador al primer nodo (inicio) del mismo tipo de la clase Nodo
 * - un contador de nodos (numNodos) que SIEMPRE va a ser ENTERO */
 
public class ListaLineal {
    // Atributos
    private Nodo inicio; 
    private int numNodos;
    
    /* Constructor que crea una lista vacía SIN NODOS, 
    por eso el contador de nodos queda en CERO y el apuntador 
    inicio que va a guardar la dirección del primer nodo (cuando exista) 
    se inicializa de momento en null*/
    public ListaLineal () { 
        inicio = null; 
        numNodos=0;
    }

    // get...
    public Nodo getInicio ( ) { 
        return inicio;
    }
        
    public int getNumNodos ( ) { 
        return numNodos;
    }

    // Método que devuelve true si la lista está vacía
    public boolean listaVacia() { 
        if (inicio == null)
            return true; 
        else
            return false;
    }

    // Método que inserta un nodo al inicio de la lista 
    public void insertaInicio (Nodo nuevo) {
        nuevo.setEnlace(inicio);
        inicio = nuevo;
        numNodos++; 
    }

    // Método importante para RECORRER la lista (visitar TODOS los nodos)
    public void recorreLista() {
        Nodo r = inicio;
        System.out.println("Empieza la lista:\n");
        while (r != null) {
            System.out.println ( r.toString() + "\n");
            r = r.getEnlace();
        }
        System.out.println("Fin de la lista"); }
    
  
    	   
      
    
}
