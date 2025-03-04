package U3;
public class ColaCanciones {
private Cancion c[];
private int frente,fin;

public ColaCanciones() {
	c = new Cancion [5];
	frente = 0;
	fin = -1;
}

public ColaCanciones(int n) {
	c = new Cancion[n];
	frente =0;
	fin=-1;
}
public Cancion[] getC() {
	return c;
	
}
public int getFrente() {
	return frente;
}
public int getFin() {
	return fin;
}
public void setC(Cancion[]nuevoC) {
	c=nuevoC;
}

public void setFrente(int frente) {
	this.frente = frente;
}

public void setFin(int fin) {
	this.fin = fin;
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

public void insertar ( Cancion x) {
    if ( !estaLlena ( ) ) {
    fin++;
    c[fin] = x;
    }
    }

public Cancion eliminar( ){
    Cancion borrado = null;
    if ( !estaVacia ( ) ) {
    borrado = c [ frente ];
    c [ frente ] = null;
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
public float duracionPlaylist() {
	float duracionTotal=0;
	   for (Cancion objCancion : c) {
		   if(objCancion != null) {
           duracionTotal += objCancion.getDuracion();
       }}
       return duracionTotal;
   }
public Cancion encontrarMayorDuracion() {
    Cancion cancionMayorDuracion = null;
    for (Cancion objCancion : c) {
    	if(objCancion != null) {
        if (cancionMayorDuracion == null || objCancion.getDuracion() > cancionMayorDuracion.getDuracion()) {
            cancionMayorDuracion = objCancion;
        }
        }
    }
    return cancionMayorDuracion;
}
public Cancion buscarPorTitulo(String buscar) {
    for (Cancion objcancion : c) {
    	if(objcancion != null) {
        if (objcancion.getTitulo().equals(buscar)) {
            return objcancion;
        }}
    }
    return null;
}


public Cancion datoEnFrente ( ) {
    if (!estaVacia( ) )
    return c[frente];
    else
    return null;
    } 

public Cancion datoEnFin ( ) {
    if (!estaVacia( ) )
    return c[fin];
    else
    return null;
    }

public String toString( ) {
String s="";
for (int i = frente; i <= fin; i++)
s += c[i]+"\n";
return s;
}


}
