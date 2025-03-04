package U5;

/* Clase instanciable para manejar un árbol binario ordenado con este criterio:
 * Para TODOS los nodos se aplica
 * datos MENORES a la izquierda y 
 * MAYORES O IGUALES a la derecha 
 */

public class ArbolBinario {
    
   // Atributo (solo la raíz del árbol)
    private NodoArbolBin raiz; 
    
   // Constructor (crea un árbol binario vacío)
   public ArbolBinario ( ) { 
       raiz = null;
   }
   
   // 1 get
   public NodoArbolBin getRaiz ( ) { 
        return raiz;
   }
   
   // 1 set
   public void setRaiz ( NodoArbolBin nuevaRaiz ) { 
       raiz = nuevaRaiz;
   }
   
   // Método para determinar si el árbol está vacío
   public boolean estaVacio() {
      if ( raiz == null )
          return true;
      else
          return false;
   }
   
   // Método PRINCIPAL para insertar un nodo en el árbol
   public void insertar ( NodoArbolBin nuevo) {
       if( estaVacio() ) //si el arbol esta vacio, crea la raiz con este nodo nuevo
           raiz = nuevo; 
       else
           insertarAuxiliar(raiz, nuevo); //si ya tiene nodos, busca dónde insertarlo usando un método auxiliar 
   }
   
   // Método AUXILIAR para insertar RECURSIVO agrega < a la izquierda y >= a la derecha
   public void insertarAuxiliar (NodoArbolBin raiz, NodoArbolBin nuevo) {
      if ( nuevo.getDato() < raiz.getDato() ) {  // si el dato nuevo es MENOR, se va a la izquierda
         if ( raiz.getIzquierdo() == null)  // si no tiene hijo izquierdo
             raiz.setIzquierdo (nuevo); // en esta posición inserta un nuevo nodo
         else    // cuando ya tiene hijo izquierdo ese nodo, y no lo puede colgar
             insertarAuxiliar (raiz.getIzquierdo(), nuevo); //se manda llamar a sí mismo para buscar lugar libre
      }
      else {  // si el dato nuevo es MAYOR O IGUAL, se va a la derecha
          if (raiz.getDerecho() == null)  // si no tiene hijo derecho
              raiz.setDerecho (nuevo); // en esta posición inserta un nuevo nodo
          else
              insertarAuxiliar (raiz.getDerecho(), nuevo); //se manda llamar a sí mismo para buscar espacio libre
      } 
    
   }
   
   // devuelve un String con el recorrido PREORDEN del árbol
   public String preorden (NodoArbolBin nodo) { 
      if (nodo == null) // caso base o primitiva PARA LA EJECUCIÓN DEL MÉTODO
         return "";
      return nodo.getDato() +"\n"+ preorden(nodo.getIzquierdo()) +  preorden(nodo.getDerecho());
   }
   
   // devuelve un String con el recorrido INORDEN del árbol
   public String inorden (NodoArbolBin nodo) { 
      if (nodo == null) // caso base o primitiva PARA LA EJECUCIÓN DEL MÉTODO
         return "";
      return inorden(nodo.getIzquierdo()) + nodo.getDato() +"\n"+ inorden(nodo.getDerecho());
   }
   
   // devuelve un String con el recorrido POSTORDEN del árbol
   public String postorden (NodoArbolBin nodo) { 
       if (nodo == null)
          return "";
      return postorden(nodo.getIzquierdo()) + postorden(nodo.getDerecho()) + nodo.getDato() +"\n";
    } 
    
      
    /* MÉTODO PRINCIPAL PARA ELIMINAR UN NODO (RECURSIVO) */

    public NodoArbolBin eliminar (NodoArbolBin nodo, int datoBorrar) {
        if (nodo == null)
            return null;
        if (datoBorrar < nodo.getDato()) // busca a la izquierda si el dato es MENOR
             nodo.setIzquierdo(eliminar(nodo.getIzquierdo(), datoBorrar));
        else
            if (datoBorrar > nodo.getDato())  // busca a la derecha si el dato es MAYOR
               nodo.setDerecho(eliminar(nodo.getDerecho(), datoBorrar));
            else    // AQUÍ ES DONDE ENCUENTRA EL DATO A BORRAR
                if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) // si es una hoja
                   nodo = null;
                else
                  if (nodo.getDerecho() != null) {
                     nodo.setDato (sucesor(nodo.getDerecho()));
                     nodo.setDerecho(eliminar(nodo.getDerecho(),nodo.getDato()));
                  }
                  else {
                     nodo.setDato (predecesor (nodo.getIzquierdo()));
                     nodo.setIzquierdo(eliminar(nodo.getIzquierdo(), nodo.getDato()));
                  }
         return nodo;
     }


// 1ER.MÉTODO AUXILIAR PARA ELIMINAR (recursivo)
    private int sucesor (NodoArbolBin nodo) {
        if (nodo.getIzquierdo() == null)
             return nodo.getDato();
        return sucesor (nodo.getIzquierdo());
    }


// 2DO.MÉTODO AUXILIAR PARA ELIMINAR (recursivo)
    private int predecesor (NodoArbolBin nodo) {
        if (nodo.getDerecho() == null)
            return nodo.getDato();
        return predecesor  (nodo.getDerecho());
    }

    // Método para buscar un elemento "x" en el árbol (devuelve valor booleano)
    public boolean encontrar (NodoArbolBin nodo, int x) {
       if(nodo == null)
           return false;
       else
           if(x == nodo.getDato())  // cuando encuentra x devuelve true
               return true;
           else    // si no lo ha encontrado, sigue recorriendo por las ramas izq. y der.
               return encontrar(nodo.getIzquierdo(),x) || encontrar(nodo.getDerecho(),x); 
   }
   
}