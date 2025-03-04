package U4;

import javax.swing.JOptionPane;

/* CLASE INSTANCIABLE PARA MANEJAR UNA LISTA ENLAZADA CIRCULAR con 3 atributos:
 *  - un apuntador al primer nodo (inicio) 
 *  - un apuntador al ultimo nodo (fin)
 *  - un contador de nodos (numNodos) que SIEMPRE va a ser ENTERO */

public class ListaCircularVendedores {
  // Atributos
  private NodoVendedor inicio;
  private NodoVendedor fin;
  private int numNodos;

  //  Constructor (crea una lista vacia)
  public ListaCircularVendedores () {
     inicio = fin = null;
     numNodos = 0;
  }
 
  // get...
  public NodoVendedor getInicio() {
     return inicio;
  }
  
  public NodoVendedor getFin() {
     return fin;
  }
  
  
  public int getNumNodos() {
	return numNodos;
}

public void setNumNodos(int numNodos) {
	this.numNodos = numNodos;
}

public void setInicio(NodoVendedor inicio) {
	this.inicio = inicio;
}

public void setFin(NodoVendedor fin) {
	this.fin = fin;
}

// checa si la lista esta vacia
  public boolean listaVacia () {
     return (inicio == null);
  }
  
  //inserta nodo al inicio
  public void insertaInicio (NodoVendedor nuevo) {
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
  
  public void insertarFinal (NodoVendedor nuevo) {
	    if (listaVacia () ) {
	       inicio = fin = nuevo;
	       nuevo.setEnlace (nuevo);
	    }
	    else {
	        fin.setEnlace(nuevo);
	        nuevo.setEnlace(inicio);
	        fin=nuevo;
	    }
	    numNodos++;    
	  }
  
  public NodoVendedor Buscar (String nombre) {
	    NodoVendedor r = inicio;
	    NodoVendedor eliminado = null;
	    if (listaVacia () )
	      return inicio;
	    else {
	       do {
	        if(r.getVendedor().getNombre().equalsIgnoreCase(nombre)) {
	        	eliminado = r;
	        }
	        r = r.getEnlace();
	      } while (r != inicio);
	    }  
	    
	    return eliminado;    
	  }

    public void AumentarTodosLosSalarios () {
	    NodoVendedor r = inicio;
	  float p=r.getVendedor().getVentas()*15/100;
	    if (!listaVacia () )
	       do {
	        r.getVendedor().setSueldoBase(r.getVendedor().getSueldoBase()+(r.getVendedor().getSueldoBase()*p)/100);
	        r = r.getEnlace();
	      } while (r != inicio);
	    }  
	        
    

  //toString
  public String toString () {
    String s = "";
    NodoVendedor r = inicio;
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
  
  
  public void insertarAlfabeticamente(NodoVendedor nuevo) {

    if (inicio == null) {
        // La lista está vacía, el nuevo nodo será el inicio y el fin
        inicio = nuevo;
        fin = nuevo;
        nuevo.setEnlace(inicio); // El siguiente del nuevo nodo apunta al inicio
    } else {
        // La lista no está vacía, debemos encontrar la posición adecuada para el nuevo nodo
        NodoVendedor r = inicio;
        NodoVendedor anterior = null;

        // Recorremos la lista para encontrar la posición adecuada
        do {
            if (nuevo.getVendedor().getNombre().compareTo(r.getVendedor().getNombre()) < 0) {
                // El nuevo doctor va antes que el doctor r
                break;
            }
            anterior = r;
            r = r.getEnlace();
        } while (r != inicio);

        if (anterior == null) {
            // El nuevo doctor va al principio de la lista
            nuevo.setEnlace(inicio);
            inicio = nuevo;
            fin.setEnlace(inicio); // El siguiente del último nodo apunta al inicio
        } else {
            // El nuevo doctor va en medio o al final de la lista
            anterior.setEnlace(nuevo);
            nuevo.setEnlace(r);

            if (r == inicio) {
                // El nuevo doctor va al final de la lista
                fin = nuevo;
                fin.setEnlace(inicio); // El siguiente del último nodo apunta al inicio
            }
        }
    }

    numNodos++;
}
  private NodoVendedor obtenerNodoEnPosicion(int posicion) {
	  NodoVendedor r = inicio;

	  for (int i = 0; i < posicion; i++) {
	      r = r.getEnlace();
	  }

	  return r;
	}
  public void eliminarUltimoNodo() {
	  if (inicio == null) {
	      // La lista está vacía, no hay nada que eliminar
	      JOptionPane.showMessageDialog(null,"Lista Vacia");
	  }

	  if (numNodos == 1) {
	      // Solo hay un nodo en la lista, eliminar ese nodo
	      inicio = null;
	      fin = null;
	  } else {
	      // Encontrar el penúltimo nodo
	      NodoVendedor penultimo = obtenerNodoEnPosicion(numNodos - 2);

	      // Eliminar el último nodo (penúltimo ahora apuntará al inicio)
	      penultimo.setEnlace(inicio);
	      fin = penultimo;
	  }
	  
	  numNodos--;
	  }
}
  // faltan métodos


