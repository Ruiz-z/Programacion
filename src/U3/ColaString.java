package U3;
public class ColaString {
	// 3 atributos
	private String c[]; // Vector de ENTEROS
	private int frente, fin; // Apuntadores para el frente y final de la estructura

	public ColaString() {
		c = new String[5];
		frente = 0;
		fin = -1;
	}

	public ColaString(int n) {
		c = new String[n];
		frente = 0;
		fin = -1;
	}

	public String[] getC() {
		return c;
	}
    

	public int getFrente() {
		return frente;
	}

	public int getFin() {
		return fin;
	}

	public void setC(String[] nuevoC) {
		c = nuevoC;
	}

	public void setFrente(int nuevoFrente) {
		frente = nuevoFrente;
	}

	public void setFin(int nuevoFin) {
		fin = nuevoFin;
	}

    public boolean estaVacia ( ) {
        if (frente > fin)
        return true;
        else
        return false;
        }

    public boolean estaLlena( ) {
            if (fin == c.length - 1)
             return true;
            else
             return false;
             }

    
    public void insertar (String x) {
                if ( !estaLlena ( ) ) {
                fin++;
                c[fin] = x;
                }
                }
       
     public String eliminar( ){
                    String borrado = "";
                    if ( !estaVacia ( ) ) {
                    borrado = c [ frente ];
                    c [ frente ] = "";
                    frente++;
                    if ( estaVacia( ) ) { 
                        frente = 0; 
                        fin = -1;
                    }
                }
                return borrado;
                }
    
      public int numElementos( ) {
                    return fin - frente + 1;
                    }
    
     public String datoEnFrente ( ) {
                        if (estaVacia( ) )
                        return "";
                        else
                        return c[frente];
                        } 
     public boolean Buscar(String x) {
 		boolean s = false;
 		for (int i = frente; i <= fin; i++)
 			if(c[i].compareToIgnoreCase(x)==0) {
 				s=true;
 				break;
 			}
 		return s;
 	}

    public String toString( ) {
 String s="";
 for (int i = frente; i <= fin; i++)
 s += c[i]+"\n";
 return s;
 }

      public String datoEnFin ( ) {
                        if (estaVacia( ) )
                        return "";
                        else
                        return c[fin];
                        }

	
                             
}
