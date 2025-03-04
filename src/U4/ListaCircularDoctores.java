package U4;

import javax.swing.JOptionPane;

/* CLASE INSTANCIABLE PARA MANEJAR UNA LISTA ENLAZADA CIRCULAR con 3 atributos:
 *  - un apuntador al primer nodo (inicio) 
 *  - un apuntador al ultimo nodo (fin)
 *  - un contador de nodos (numNodos) que SIEMPRE va a ser ENTERO */

public class ListaCircularDoctores {
  // Atributos
  private NodoDoctor inicio;
  private NodoDoctor fin;
  private int numNodos;

  //  Constructor (crea una lista vacia)
  public ListaCircularDoctores () {
     inicio = fin = null;
     numNodos = 0;
  }
 
  // get...
  public NodoDoctor getInicio() {
     return inicio;
  }
  
  public NodoDoctor getFin() {
     return fin;
  }
  
  
  public int getNumNodos() {
	return numNodos;
}

public void setNumNodos(int numNodos) {
	this.numNodos = numNodos;
}

public void setInicio(NodoDoctor inicio) {
	this.inicio = inicio;
}

public void setFin(NodoDoctor fin) {
	this.fin = fin;
}

// checa si la lista esta vacia
  public boolean listaVacia () {
     return (inicio == null);
  }
  
  //inserta nodo al inicio
  public void insertaInicio (NodoDoctor nuevo) {
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
  
  public void insertarFinal (NodoDoctor nuevo) {
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
  
  public NodoDoctor Buscar (String nombre) {
	    NodoDoctor r = inicio;
	    NodoDoctor eliminado = null;
	    if (listaVacia () )
	      return inicio;
	    else {
	       do {
	        if(r.getDoctor().getNombre().equalsIgnoreCase(nombre)) {
	        	eliminado = r;
	        }
	        r = r.getEnlace();
	      } while (r != inicio);
	    }  
	    
	    return eliminado;    
	  }

    public void AumentarTodosLosSalarios (int p) {
	    NodoDoctor r = inicio;
	    if (!listaVacia () )
	       do {
	        r.getDoctor().setSueldo(r.getDoctor().getSueldo()+(r.getDoctor().getSueldo()*p)/100);
	        r = r.getEnlace();
	      } while (r != inicio);
	    }  
	        
          public NodoDoctor DoctorQueGanaMas () {
	    NodoDoctor r = inicio;
      NodoDoctor eliminado = inicio;
	    if (!listaVacia () )
	       do {
	        if(eliminado.getDoctor().getSueldo()<=r.getDoctor().getSueldo()){
            eliminado = r;
          }

          r = r.getEnlace();
	      } while (r != inicio);


       return eliminado;
	    }  
	  
  

     public void AumentarSalarioPorNombre (String nombre) {
	    NodoDoctor r = inicio;
	    NodoDoctor eliminado = null;
	    if (!listaVacia () ){
	       do {
	        if(r.getDoctor().getNombre().equalsIgnoreCase(nombre)) {
	        	eliminado = r;
	        }
	        r = r.getEnlace();  
	      } while (r != inicio);
	    }  
	    
      if(eliminado!=null){
	    eliminado.getDoctor().setSueldo(Float.parseFloat(JOptionPane.showInputDialog ("Nuevo sueldo: ")));    
      }else{
        JOptionPane.showMessageDialog(null, "No se encontró el doctor");
      }

	  }

  //toString
  public String toString () {
    String s = "";
    NodoDoctor r = inicio;
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
  
  
  public void insertarAlfabeticamente(NodoDoctor nuevo) {

    if (inicio == null) {
        // La lista está vacía, el nuevo nodo será el inicio y el fin
        inicio = nuevo;
        fin = nuevo;
        nuevo.setEnlace(inicio); // El siguiente del nuevo nodo apunta al inicio
    } else {
        // La lista no está vacía, debemos encontrar la posición adecuada para el nuevo nodo
        NodoDoctor r = inicio;
        NodoDoctor anterior = null;

        // Recorremos la lista para encontrar la posición adecuada
        do {
            if (nuevo.getDoctor().getNombre().compareTo(r.getDoctor().getNombre()) < 0) {
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


public void eliminarEnPosicion(int posicion) {
  if (inicio == null || posicion < 0 || posicion >= numNodos) {
      // La lista está vacía o la posición proporcionada es inválida
      return;
  }

  if (numNodos == 1) {
      // Solo hay un nodo en la lista, eliminar ese nodo
      inicio = null;
      fin = null;
      numNodos--;
  } else {
      if (posicion == 0) {
          // Si la posición es 0, eliminar el primer nodo
          inicio = inicio.getEnlace();
          fin.setEnlace(inicio); // Actualizar el siguiente del último nodo
          numNodos--;
      } else {
          // Encontrar el nodo anterior al que se eliminará
          NodoDoctor anterior = obtenerNodoEnPosicion(posicion - 1);

          // Eliminar el nodo en la posición proporcionada
          anterior.setEnlace(anterior.getEnlace().getEnlace());

          // Si se eliminó el último nodo, actualizar el fin
          if (posicion == numNodos - 1) {
              fin = anterior;
              fin.setEnlace(inicio); // Actualizar el siguiente del último nodo
          }

          numNodos--;
      }
  }

  numNodos--;
}

public NodoDoctor eliminarPorNombre(String nombre) {
  if (listaVacia()) {
      JOptionPane.showMessageDialog(null, "Lista Vacía");
  }

  NodoDoctor eliminado = null;
  NodoDoctor anterior = null;
  NodoDoctor r = inicio;      
    do {
      if (r.getDoctor().getNombre().equals(nombre)) {
          eliminado = r;
          break;
      }
      anterior = r;
      r = r.getEnlace();
  } while (r != inicio);

if(eliminado!=null){
 
  if (numNodos == 1) {
    // Solo hay un nodo en la lista
    inicio = null;
    fin = null;
} else if (r == inicio) {
    // El nodo a eliminar es el primer nodo
    inicio = inicio.getEnlace();
    fin.setEnlace(inicio); // Actualizar el siguiente del último nodo
} else if (r == fin) {
    // El nodo a eliminar es el último nodo
    fin = anterior;
    fin.setEnlace(inicio); // Actualizar el siguiente del último nodo
} else {
    // El nodo a eliminar está en medio de la lista
    anterior.setEnlace(r.getEnlace());
}

numNodos--;
}
return eliminado;
}

public void AumentarSalarioEspecifico(int posicion) {
  if (inicio == null || posicion < 0 || posicion >= numNodos) {

  }else if (numNodos == 1) {

      inicio.getDoctor().setSueldo(Float.parseFloat(JOptionPane.showInputDialog ("Nuevo sueldo: ")));
  } else {
      if (posicion == 0) {
          inicio.getDoctor().setSueldo(Float.parseFloat(JOptionPane.showInputDialog ("Nuevo sueldo: ")));// Actualizar el siguiente del último nodo
      } else {
        
          obtenerNodoEnPosicion(posicion).getDoctor().setSueldo(Float.parseFloat(JOptionPane.showInputDialog ("Nuevo sueldo: ")));;
      }
  }

}

// Método auxiliar para obtener el nodo en una posición dada
private NodoDoctor obtenerNodoEnPosicion(int posicion) {
  NodoDoctor r = inicio;

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
      NodoDoctor penultimo = obtenerNodoEnPosicion(numNodos - 2);

      // Eliminar el último nodo (penúltimo ahora apuntará al inicio)
      penultimo.setEnlace(inicio);
      fin = penultimo;
  }

  numNodos--;
  }


}
  // faltan métodos


