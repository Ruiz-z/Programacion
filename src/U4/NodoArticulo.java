package U4;

public class NodoArticulo {

    // 4 atributos: los 3 datos y la liga o enlace al siguiente nodo    
    private String descripcion; 
    private int cantidad; 
    private float precio; 
    private NodoArticulo enlace;  // El enlace SIEMPRE será del mismo tipo de la 
                        // clase que lo contiene, 
                        // porque guarda la dirección de memoria del siguiente nodo

    // 1er. Constructor, crea un nodo con datos vacíos (NO recibe parámetros)
    

    // 2do. Constructor, recibe como parámetros los 2 datos, el enlace NO se recibe, sino 
    // que se pone en null porque todos los nodos nuevos está DESCONECTADOS de la lista 
    public NodoArticulo (String desc, int cant, float pre) {
        descripcion = desc;
        cantidad = cant;
        precio = pre; 
        enlace = null;
    }

    public NodoArticulo() {
		// TODO Auto-generated constructor stub
	}

	// Métodos get...
    public String getDescripcion(){ 
        return descripcion;
    }

    public int getCantidad () { 
        return cantidad;
    }
    
     public float getPrecio () { 
        return precio;
    }
    
    public NodoArticulo getEnlace(){ 
        return enlace;
    }
    
    // Métodos set...
    public void setDescripcion(String nuevaDescripcion) { 
        descripcion = nuevaDescripcion;
    }
        
    public void setCantidad (int nuevaCantidad) { 
        cantidad = nuevaCantidad;
    }
    
    public void setPrecio (float nuevoPrecio) { 
        precio = nuevoPrecio;
    }
    
    public void setEnlace(NodoArticulo nuevoE) { 
        enlace = nuevoE;
    }

    /* Método toString
     Solamente se devuelven los datos, NO el enlace, 
    ya que es una dirección de memoria para ligar nodos,
    NO es un dato que deba ver el usuario.*/
    public String toString( ) { 
        return "Articulo: " + descripcion + ", cantidad: " 
        + cantidad + " , Precio: $ " + precio;
    }
    
} // fin de la clase NodoArticulo
