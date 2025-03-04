package U3;

public class ColaCircularFarmacias {
private Farmacia[] cc;
private int frente;
private int contador;

public ColaCircularFarmacias() {
	cc = new Farmacia[5];
	frente=0;
	contador=0;
}
public ColaCircularFarmacias(int num) {
	cc= new Farmacia[num];
	frente=0;
	contador=0;
}
public Farmacia[] getCc() {
	return cc;
}
public void setCc(Farmacia[] cc) {
	this.cc = cc;
}
public int getFrente() {
	return frente;
}
public void setFrente(int frente) {
	this.frente = frente;
}
public int getContador() {
	return contador;
}
public void setContador(int contador) {
	this.contador = contador;
}
public boolean estaVacia ()  {
    if  (contador == 0)
      return true;
    else
      return false;
  }
public boolean estaLlena()  {
    if  ( contador == cc.length)
      return true;
    else
      return false;
  }
public Farmacia elementoEnFrente () {
    if ( estaVacia() )
       return null;
    else
       return cc [frente];
  }
public int numElementos ( ) {
    return contador;
}
public void insertar (Farmacia x) {
    if ( ! estaLlena () ) {                
       cc [(frente + contador) % cc.length] = x; 
       contador++;
    }
  }
public Farmacia eliminar ( ) {
    Farmacia eliminado=null;
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
public float SumaT() {
	float SumaT=0;
	   for (Farmacia objFarmacia : cc) {
		   if(objFarmacia != null) {
          SumaT += objFarmacia.getVentas();
       }}
       return SumaT;
   }
public String Barabara() {
	   int i=1,indice=frente;
	   float bara=0.0f;	
	   String Barato= "";
	   while (i <= contador) {
			bara=cc[indice].getVentas();
			Barato=cc[indice].getSucursal();
			if(bara>cc[indice].getVentas()) {
				bara=cc[indice].getVentas();
				Barato=cc[indice].getSucursal();
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
}
