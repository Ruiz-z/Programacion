package U4;
/* CLASE INSTANCIABLE PARA MANEJAR UNA LISTA ENLAZADA CIRCULAR con 3 atributos:
 *  - un apuntador al primer nodo (inicio) 
 *  - un apuntador al ultimo nodo (fin)
 *  - un contador de nodos (numNodos) que SIEMPRE va a ser ENTERO */

public class ListaCircularAlumnos {
  // Atributos
  private NodoAlumno inicio;
  private NodoAlumno fin;
  private int numNodos;

  //  Constructor (crea una lista vacia)
  public ListaCircularAlumnos () {
     inicio = fin = null;
     numNodos = 0;
  }
 
  // get...
  public NodoAlumno getInicio() {
     return inicio;
  }
  
  public NodoAlumno getFin() {
     return fin;
  }
  
  public int getNumNodos() {
     return numNodos;
  }
  
  // set...
  public void setInicio (NodoAlumno n) {
     inicio = n;
  }
  
  public void setFin (NodoAlumno n) {
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
  public void insertaInicio (NodoAlumno nuevo) {
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
  public void insertaFinal(NodoAlumno nuevo) {
		if (listaVacia()) {
			inicio = fin = nuevo;
			nuevo.setEnlace(nuevo);
		} else {
			nuevo.setEnlace(inicio);
			fin.setEnlace(nuevo);
			fin = nuevo;

		}
		numNodos++;
	}
  //toString
  public String toString () {
    String s = "";
    NodoAlumno r = inicio;
    if (listaVacia () )
      s += "Lista vacia";
    else {
       do {
        s += r.toString() + "\n"; // s+= r.getAlumno().toString() + "\n";
        r = r.getEnlace();
      } while (r != inicio);
    }  
    return s;    
  }


  // faltan métodos
}
