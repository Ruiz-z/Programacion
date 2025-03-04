package U2;

public class PilaLibro {
	 private Libro p[ ];     // vector para guardar datos de la pila
     private int tope;
     
     public PilaLibro(int n) {
    	 p = new Libro[n];
    	 tope = -1;
     }
     public Libro [] getP() {
    	 return p;
     }
     public int getTope ( ) {
    		return tope;
    	         }
     
public void setNovela (Libro [] nuevaNovela) {
	p =  nuevaNovela;
}
public void setTope ( int nuevoTope ) {
    tope = nuevoTope;
}
public void push ( Libro nuevo ) {
if ( !isFull () ) {      
tope++;                       
p[tope] = nuevo;   
}
  }
public Libro pop ( ) {
    Libro borrado = p[tope];     //  devuelve el dato borrado
if ( !isEmpty () ) {


   borrado = p[tope];      // se saca el dato del tope
       p[tope] = null;                     // se borra físicamente la casilla	        
    tope--;                              // se decrementa el tope
    }
return borrado;              // se devuelve el valor eliminado
}
public boolean isEmpty ( ) {
    if( tope == -1)           // si el tope no señala a ninguna casilla
return true;
   else
return false;
}

public boolean isFull ( ) {
    if ( tope == p.length - 1)  //si el tope está en la última casilla
return true;
   else
return false;
}
public Object datoEnTope() {
    if (!isEmpty())
        return p[tope];
    return ' ';
}
public int size() {
    return tope + 1;
}
public String toString() {
	String s = "";
	int i;
	for (i = tope; i >= 0; i--) {
		s += p[i] + "\n";
	}
	return s;
}

}
