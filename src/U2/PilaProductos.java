package U2;

public class PilaProductos {
private Producto[]p;
private int tope;

public PilaProductos(int n) { 
	p= new Producto[n];
	tope = -1;
}

public Producto[] getP() {
	return p;
}

public void setP(Producto[] p) {
	this.p = p;
}

public int getTope() {
	return tope;
}

public void setTope(int tope) {
	this.tope = tope;
}
public boolean isFull() {
	if (tope == p.length - 1) { // si el tope está en la última casilla
		return true;
	}else {
		return false;
	}
}

public boolean isEmpty() {
	if (tope == -1){ // si el tope no señala a ninguna casilla
		return true;
	}else{
		return false;
	}
}
public Object datoEnTope() {
    if (!isEmpty())
        return p[tope];
    return ' ';
}
public void push(Producto nuevo) {
	if (!isFull()) {
		tope++; 
		p[tope] = nuevo; 
	}
}
public Producto pop() {
	Producto borrado = p[tope]; // devuelve el dato borrado
	if (!isEmpty()) {

		borrado = p[tope]; // se saca el dato del tope
		p[tope] = null; // se borra físicamente la casilla
		tope--; // se decrementa el tope
	}
	return borrado; // se devuelve el valor eliminado
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
