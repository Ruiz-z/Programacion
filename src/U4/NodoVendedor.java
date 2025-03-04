package U4;
/** CLASE INSTANCIABLE PARA MANEJAR UN nodo de Alumnos  
- solo 1 dato alumno:Alumno
- y OBIVAMENTE el apuntador que guarda la dirección del siguiente nodo (enlace) */

public class NodoVendedor {

    // 2 atributos: el alumno y la liga o enlace al siguiente nodo    
    private Vendedor vendedor;
    private NodoVendedor enlace;  // El enlace SIEMPRE será del mismo tipo de la 
                        // clase que lo contiene, 
                        // porque guarda la dirección de memoria del siguiente nodo

    // 1er. Constructor, crea un nodo con datos vacíos (NO recibe parámetros)
    public NodoVendedor ( ) { 
        vendedor = null;
        enlace = null; 
    }

    // 2do. Constructor, recibe como parámetro 1 dato (Alumno), el enlace NO se recibe, sino 
    // que se pone en null porque todos los nodos nuevos está DESCONECTADOS de la lista 
    public NodoVendedor (Vendedor ven) {
        vendedor = ven;
        enlace = null;
    }

    // Métodos get...
    public Vendedor getVendedor(){ 
        return vendedor;
    }
    
    public NodoVendedor getEnlace(){ 
        return enlace;
    }
    
    // Métodos set...
    public void setAlumno (Vendedor nvoVen) { 
        vendedor = nvoVen;
    }
    
    public void setEnlace(NodoVendedor nuevoE) { 
        enlace = nuevoE;
    }
    
    /* Método toString
     Solamente se devuelven los datos del objeto Alumno, NO el enlace, 
    ya que es una dirección de memoria para ligar nodos,
    NO es un dato que deba ver el usuario.*/
    public String toString( ) { 
        return vendedor.toString();
    }
    
} // fin de la clase NodoAlumno
