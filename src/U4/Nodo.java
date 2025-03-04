package U4;

/** CLASE INSTANCIABLE PARA MANEJAR UN nodo con 2 datos:
- un string (dato1)
- un entero (dato2)
- y OBIVAMENTE el apuntador que guarda la dirección del siguiente nodo (enlace) */

public class Nodo {

    // 3 atributos: los 2 datos y la liga o enlace al siguiente nodo    
    private String dato1; 
    private int dato2; 
    private Nodo enlace;  // El enlace SIEMPRE será del mismo tipo de la 
                        // clase que lo contiene, 
                        // porque guarda la dirección de memoria del siguiente nodo

    // 1er. Constructor, crea un nodo con datos vacíos (NO recibe parámetros)
    public Nodo ( ) { 
        dato1 = "";
        dato2 = 0;
        enlace = null; 
    }

    // 2do. Constructor, recibe como parámetros los 2 datos, el enlace NO se recibe, sino 
    // que se pone en null porque todos los nodos nuevos está DESCONECTADOS de la lista 
    public Nodo (String d1, int d2) {
        dato1 = d1; 
        dato2 = d2; 
        enlace = null;
    }

    // Métodos get...
    public String getDato1(){ 
        return dato1;
    }

    public int getDato2 () { 
        return dato2;
    }
    
    public Nodo getEnlace(){ 
        return enlace;
    }
    
    // Métodos set...
    public void setDato1(String nuevoD1) { 
        dato1 = nuevoD1;
    }
        
    public void setDato2(int nuevoD2) { 
        dato2 = nuevoD2;
    }
    
    public void setEnlace(Nodo nuevoE) { 
        enlace = nuevoE;
    }

    /* Método toString
     Solamente se devuelven los datos, NO el enlace, 
    ya que es una dirección de memoria para ligar nodos,
    NO es un dato que deba ver el usuario.*/
    public String toString( ) { 
        return dato1 + "   " + dato2;
    }

	
} // fin de la clase Nodo