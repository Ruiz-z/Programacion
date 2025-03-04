package U3;

import javax.swing.JOptionPane;

public class ColaCircularArticulos {
	private Articulo[] cc;        // Este es el vector donde se guardan los datos
    private int frente;          // Apuntador al frente , YA NO SE NECESITA EL APUNTADOR DEL FINAL
    private int contador;        // Ahora el control se maneja a traves de un CONTADOR de datos ingresados

    // 1er Constructor crea una cola CIRCULAR de 5 casillas
    public ColaCircularArticulos() {
       cc=new Articulo[5];
       frente = 0;
       contador = 0;
    }

    // 2do Constructor crea una cola CIRCULAR con el numero de elementos que se recibe como parametro
    public ColaCircularArticulos(int num) {
       cc=new Articulo [num];
       frente = 0;
       contador = 0;
    }

    // getters
    public Articulo[ ] getCc () {
        return cc;
    }

    public int getFrente () {
        return frente;
    }

    public int getContador () {
        return contador;
    }

    // setters
    public void setCc (Articulo[] nuevoCc) {
        cc = nuevoCc;
    }

    public void setFrente (int nuevoFrente) {
        frente = nuevoFrente;
    }

    public void setContador (int nuevoCont) {
        contador = nuevoCont;
    }

    //Ahora cuando esta VACIA lo sabemos simplemente porque el CONTADOR de ingresados vale CERO
    public boolean estaVacia ()  {
      if  (contador == 0)
        return true;
      else
        return false;
    }

   // Y para checar si esta LLENA tambien lo podemos saber gracias al CONTADOR de ingresados
   // que se compara contra la cantidad de casillas que tiene el vector
    public boolean estaLlena()  {
      if  ( contador == cc.length)
        return true;
      else
        return false;
    }

   // Devuelve el elemento del frente de la cola CIRCULAR. NO LO ELIMINA
    public Articulo elementoEnFrente () {
      if ( estaVacia() )
         return null;
      else
         return cc [frente];
    }

    // Devuelve el elemento del final de la cola CIRCULAR. NO LO ELIMINA
    public Articulo elementoEnFin () {
       if ( estaVacia() )
          return null;
       else
          return cc [(frente - 1 + contador) % cc.length];
    }

   // Devuelve la cantidad de elementos que hay actualmente en la cola CIRCULAR
    public int numElementos ( ) {
         return contador;
    }

   // Metodo para insertar un dato x
   public void insertar (Articulo x) {
      if ( ! estaLlena () ) {                // solo podemos insertar si NO esta llena
         cc [(frente + contador) % cc.length] = x; // se calcula la posicion donde se insertara x
         contador++;                       // obviamente se incrementa el contador, ya que se inserto un elemento
      }
    }
    
   // Metodo para eliminar un dato, devuelve el elemento eliminado o null si no hay datos para borrar
   public Articulo eliminar ( ) {
      Articulo eliminado=null;
      if ( ! estaVacia () ) {                  // solo podemos eliminar si NO esta vacia
         eliminado = cc[frente];               // Dato que se elimina y es el que se devuelve
         cc[frente] = null;                    // se anula el dato de la casilla
         frente = (frente + 1 ) % cc.length;   // se calcula la nueva posicion del frente
         contador--;                           // obviamente se decrementa el contador, ya que se elimino un elemento
      }    
      return eliminado;
   }

   public String toString() {
      String s="";
      int i= 1, indice = frente;   // se inicia a recorrer la fila circular desde el frente

       while (i <= contador) {    // ciclo que realiza "n" iteraciones (de acuerdo al contador de elementos)
         s+= cc[indice] + "\n";   // se accesa cada elemento con el indice (casilla)
         if (indice == cc.length - 1)   // si el indice esta en la ultima casilla,      
           indice = 0;                  // tiene que MOVERSE hasta la posicion 0
         else                         // si NO esta en la ultima casilla
           indice++;                  // simplemente se incrementa para pasar a la siguiente casilla
         i++;                // se incrementa i que controla la cantidad de iteraciones
          } 
        return s;
    }
   
   public boolean buscar(String x) {
	   int i = 1, indice = frente;
	   boolean s=false;
		while (i <= contador) {
			if (x.equalsIgnoreCase(cc[indice].getDescripcion())) {
				s=true;
			}
			if (indice == cc.length - 1) {
				indice = 0;
			} else {
				indice++;
				i++;
			}
		}
		return s;

	}
   public float inventarioTotal() {
		float inv = 0;
		int i = 1, indice = frente;
		
		while (i <= contador) {
			inv += (cc[indice].getPrecio() * cc[indice].getCantidad());
			if (indice == cc.length - 1) {
				indice = 0;
			} else {
				indice++;
			}
			i++;
		}
		return inv;
	}
   public float Corrupcion() {
	   int i=1,indice=frente;
	   float nuevoPrecio=0.0f;
	   int porcentaje=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el porcentaje a aumentar en todos os articulos: "));
	   while(i<=contador) {
		   float precioActual=cc[indice].getPrecio();
		   float aumento=(precioActual*porcentaje / 100);
		   nuevoPrecio=precioActual+aumento;
		   cc[indice].setPrecio(nuevoPrecio);
		   if (indice == cc.length - 1) {
				indice = 0;
			} else {
				indice++;
			}
			i++;
	   }
	   return nuevoPrecio;
   }
   public String Barabara() {
	   int i=1,indice=frente;
	   float bara=0.0f;	
	   String Barato= "";
	   while (i <= contador) {
			bara=cc[indice].getPrecio();
			Barato=cc[indice].getDescripcion();
			if(bara>cc[indice].getPrecio()) {
				bara=cc[indice].getPrecio();
				Barato=cc[indice].getDescripcion();
			}
			if (indice == cc.length - 1) {
				indice = 0;
			} else {
				indice++;
			}
			i++;
		}
	   return Barato;
   }
   public String Menor10(){
	   int i=1,indice=frente;
	   String salida= "";
	   while (i <= contador) {
			if(cc[indice].getCantidad()<10) {
				salida+=cc[indice];
			}
			if (indice == cc.length - 1) {
				indice = 0;
			} else {
				indice++;
			}
			i++;
		}	
	   return salida;
   }
   public boolean Modificar(String ViejaDesc) {
	   int i = 1, indice = frente;
	   boolean s=false;
		while (i <= contador) {
			if (ViejaDesc.equalsIgnoreCase(cc[indice].getDescripcion())) {
				s=true;
				String NuevaDesc=JOptionPane.showInputDialog("Ingrese la nueva descripcion del articulo");
				cc[indice].setDescripcion(NuevaDesc);
			}
			if (indice == cc.length - 1) {
				indice = 0;
			} else {
				indice++;
				i++;
			}
		}
		return s;
	}
   
   public Articulo[] Invertir() {
	      Articulo[] auxiliar = new Articulo[cc.length];
	      int i = frente;
	      int j = 0;
	      
	      while (j < contador) {
	          auxiliar[j] = cc[i];
	          i = (i + 1) % cc.length;
	          j++;
	      }
	      

	      i = frente;
	      j = 0;
	      while (j < contador) {
	          cc[i] = auxiliar[contador - j - 1];
	          i = (i + 1) % cc.length;
	          j++;
	      }
	      return cc;
	   }
}
 
