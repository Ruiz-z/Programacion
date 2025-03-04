/** CLASE INSTANCIABLE PARA MANEJAR UNA LISTA ENLAZADA LINEAL Ó SIMPLE 
 * La lista que vamos a estar manejando tiene 2 atributos:
 * - el apuntador al primer nodo (inicio) del mismo tipo de la clase Nodo
 * - un contador de nodos (numNodos) que SIEMPRE va a ser ENTERO */
 package U4;
import javax.swing.JOptionPane;

public class ListaArticulos {
	 private NodoArticulo inicio; 
	    private int numNodos;
	    
	    /* Constructor que crea una lista vacía SIN NODOS, 
	    por eso el contador de nodos queda en CERO y el apuntador 
	    inicio que va a guardar la dirección del primer nodo (cuando exista) 
	    se inicializa de momento en null*/
	    public ListaArticulos () { 
	        inicio = null; 
	        numNodos = 0;
	    }

	    // get...
	    public NodoArticulo getInicio ( ) { 
	        return inicio;
	    }
	        
	    public int getNumNodos ( ) { 
	        return numNodos;
	    }
	    
	    // setters 
	    public void setInicio (NodoArticulo nuevoInicio) {
	       inicio = nuevoInicio;
	    }
	    
	    public void setNumNodos (int nuevoNN) {
	       numNodos = nuevoNN;
	    }
	    
	    // Método que devuelve true si la lista está vacía
	    public boolean listaVacia() { 
	        return (inicio == null);
	    }

	    // Método que inserta un nodo al inicio de la lista 
	    public void insertaInicio (NodoArticulo nuevo) {
	        nuevo.setEnlace(inicio);
	        inicio = nuevo;
	        numNodos++; 
	    }
	    
	    public void insertaFinal(NodoArticulo nuevo) {
	        NodoArticulo ultimo = inicio;
	        if (listaVacia())
	           insertaInicio(nuevo);
	        else {
	            while ( ultimo.getEnlace() != null) 
	                ultimo = ultimo.getEnlace();
	            // encontro el ultimo nodo
	            ultimo.setEnlace(nuevo);
	            numNodos++;
	        }
	        
	    }

	    // Método importante para RECORRER la lista (visitar TODOS los nodos)
	    public void recorreLista() {
	        NodoArticulo r = inicio;
	        System.out.println("Empieza la lista:\n");
	        while (r != null) {
	            System.out.println ( r.toString());
	            r = r.getEnlace();
	        }
	        System.out.println("\nFin de la lista"); 
	    }
	    public boolean buscar(String x) {
	    	boolean s=false;
	 	   NodoArticulo r=inicio;
	 	   while (r!=null) {
	 		   if(r.getDescripcion().equalsIgnoreCase(x)) {
	 			   s=true;
	 		   }
	 		  r=r.getEnlace();
	 	   }
	 		return s;
	 	}
	    public float AumentarPrecios() {
	 	   NodoArticulo r=inicio;
	 	   float nuevoPrecio=0.0f;
	 	   int porcentaje=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el porcentaje a aumentar en todos los articulos: "));
	 	   while(r!=null) {
	 		   float precioActual=r.getPrecio();
	 		   float aumento=(precioActual*porcentaje / 100);
	 		   nuevoPrecio=precioActual+aumento;
	 		   r.setPrecio(nuevoPrecio);
	 		   r=r.getEnlace();
	 	   }
	 	   
	 	   return nuevoPrecio;
	    }
	    public NodoArticulo eliminar ( ) {
	        NodoArticulo eliminado=null;
	        if(!listaVacia()) {
	        	eliminado=inicio;
	        	inicio=null;
	        }
	        return eliminado;
	     }

         public NodoArticulo EliminarNodoInicial(){
            NodoArticulo eliminado=null;
	       
            if(!listaVacia()) {
	           eliminado=inicio;
               inicio = inicio.getEnlace();
               numNodos--;
	        	
	        }
	        return eliminado;
         }
	    
        public NodoArticulo ArticuloMasCaro() {
	        NodoArticulo r = inicio;
            NodoArticulo mayor = inicio;

	       for(int i=1;i<numNodos;i++){ 
	 		  
                if(mayor.getPrecio()<=r.getEnlace().getPrecio()){
                    mayor = r.getEnlace();
                }
                
                 r=r.getEnlace();

	        }
            return mayor;
	    }

		
		
		public NodoArticulo EliminarUltimoNodo() {

			NodoArticulo borrado = null;
			NodoArticulo r = inicio;
			NodoArticulo penultimo = new NodoArticulo();
	
			if (listaVacia()) {
				return borrado;
			}
			if (r.getEnlace() == null) {
				numNodos = 0;
				borrado = inicio;
				inicio = null;
				return borrado;
			}
	
			while (r != null) {

				if (r.getEnlace() == null) {
					borrado = r;
					penultimo.setEnlace(null);
					numNodos--;
					break;
				}

				penultimo = r;
				r=r.getEnlace();


			}
	
				penultimo.setEnlace(null);
				return r;
	
		}

		public void insertaAlfabetico(NodoArticulo nuevo) {
			if (listaVacia() || nuevo.getDescripcion().compareToIgnoreCase(inicio.getDescripcion()) < 0) {
				// La lista está vacía o el nuevo nodo va antes del inicio
				insertaInicio(nuevo);
			} else {
				NodoArticulo actual = inicio;
				NodoArticulo anterior = null;
		
				while (actual != null && nuevo.getDescripcion().compareToIgnoreCase(actual.getDescripcion()) > 0) {
					anterior = actual;
					actual = actual.getEnlace();
				}
		
				nuevo.setEnlace(actual);
		
				if (anterior != null) {
					anterior.setEnlace(nuevo);
				} else {
					// El nuevo nodo va al principio de la lista
					inicio = nuevo;
				}
		
				numNodos++;
			}
		}

		public float AumentarPrecioEsp(){
			NodoArticulo r=inicio;
			  float nuevoPrecio=0.0f;
			  String buscar= JOptionPane.showInputDialog("Ingrese el articulo a buscar");
			 if(r.getDescripcion().equalsIgnoreCase(buscar)) {
				int porcentaje=Integer.parseInt(JOptionPane.showInputDialog(
						  "Ingrese el porcentaje a aumentar en todos los articulos: "));
				  while(r!=null) {
					  float precioActual=r.getPrecio();
					  float aumento=(precioActual*porcentaje / 100);
					  nuevoPrecio=precioActual+aumento;
					  r.setPrecio(nuevoPrecio);
					  r=r.getEnlace();
				  }   
			 }else {JOptionPane.showMessageDialog(null,"No se encontro el articulo");}
			  return nuevoPrecio;
	  }


	  public NodoArticulo eliminarSegundoNodo() {
		  
		  if (inicio == null || inicio.getEnlace() == null) {
          
            System.out.println("Hay menos de 2 elementos en la lista");
            return null;
        }
		
		NodoArticulo x = inicio.getEnlace();

	inicio.setEnlace(x.getEnlace());
			numNodos--;
			return x;	

			}
		  
	

	    public String toString () {
	        NodoArticulo r = inicio;
	        String s = "Datos de la lista:\n";
	        while (r != null) {
	            s += r.toString()+"\n";
	            r = r.getEnlace();
	        }
	        return s;  
	    }

        
    }