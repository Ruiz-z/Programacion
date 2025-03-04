package U2;

public class PilaChar {
	// atributos
	private char p[]; // vector para guardar datos de la pila
	private int tope; // apuntador al último elemento de la pila

	public PilaChar(int n) {
		p = new char[n]; // se crea el vector (pila) de n casillas
		tope = -1; // igual, se inicializa el tope
	}

	public char[] getP() {
		return p;
	}

	public void setP(char[] p) {
		this.p = p;
	}

	public int getTope() {
		return tope;
	}

	public void setTope(int tope) {
		this.tope = tope;
	}

	// inserta un elemento en la pila
	public void push(char nuevo) {
		if (!isFull()) { // checa que la pila NO esté llena
			tope++; // mueve el tope a la sig. casilla libre
			p[tope] = nuevo; // guarda el dato en el tope de la pila
		}
	}

	// elimina un elemento de la pila
	public char pop() {
		char borrado = ' '; // devuelve el dato borrado
		if (!isEmpty()) {

			borrado = p[tope]; // se saca el dato del tope
			p[tope] = 0; // se borra físicamente la casilla
			tope--; // se decrementa el tope
		}
		return borrado; // se devuelve el valor eliminado
	}

// método que checa si la pila está vacía
	public boolean isEmpty() {
		if (tope == -1){ // si el tope no señala a ninguna casilla
			return true;
		}else{
			return false;
		}
	}

// método que checa si la pila está llena
	public boolean isFull() {
		if (tope == p.length - 1) { // si el tope está en la última casilla
			return true;
		}else {
			return false;
		}
	}
	public char datoEnTope() {
        if (!isEmpty())
            return p[tope];
        return ' ';
    }

// devuelve el número de elementos que hay actualmente en la pila
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
