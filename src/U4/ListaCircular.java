package U4;/* CLASE INSTANCIABLE PARA MANEJAR UNA LISTA ENLAZADA CIRCULAR con 3 atributos:
 *  - un apuntador al primer nodo (inicio) 
 *  - un apuntador al ultimo nodo (fin)
 *  - un contador de nodos (numNodos) que SIEMPRE va a ser ENTERO */

public class ListaCircular {
  // Atributos
  private Nodo inicio;
  private Nodo fin;
  private int numNodos;

  //  Constructor (crea una lista vacia)
  public ListaCircular () {
     inicio = fin = null;
     numNodos = 0;
  }
 
  // get...
  public Nodo getInicio() {
     return inicio;
  }
  
  public Nodo getFin() {
     return fin;
  }
  
  public int getNumNodos() {
     return numNodos;
  }
  
  // set...
  public void setInicio (Nodo n) {
     inicio = n;
  }
  
  public void setFin (Nodo n) {
     fin = n;
  }
  
  public void setNumNodos (int nn) {
     numNodos = nn;
  }
  
  // checa si la lista esta vacia
  public boolean listaVacia () {
     return (inicio == null);
  }
  
  //inserta nodo al inicio
  public void insertaInicio (Nodo nuevo) {
    if (listaVacia () ) {
       inicio = fin = nuevo;
       nuevo.setEnlace (nuevo);
    }
    else {
        nuevo.setEnlace (inicio);
        inicio = nuevo;
        fin.setEnlace (nuevo);
    }
    numNodos++;    
  }
  
  //toString
  public String toString () {
    String s = "";
    Nodo r = inicio;
    if (listaVacia () )
      s += "Lista vacia";
    else {
       do {
        s += r.toString() + "\n";
        r = r.getEnlace();
      } while (r != inicio);
    }  
    return s;    
  }

  // faltan métodos
}
