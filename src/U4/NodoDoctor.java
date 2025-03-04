package U4;

public class NodoDoctor {
	   // 3 atributos: los 2 datos y la liga o enlace al siguiente nodo    
 private Doctor doctor; 
 private NodoDoctor enlace;  // El enlace SIEMPRE será del mismo tipo de la 
                     // clase que lo contiene, 
                     // porque guarda la dirección de memoria del siguiente nodo

 // 1er. Constructor, crea un nodo con datos vacíos (NO recibe parámetros)
 public NodoDoctor( ) { 
     doctor=null;
     enlace=null;
 }

 // 2do. Constructor, recibe como parámetros los 2 datos, el enlace NO se recibe, sino 
 // que se pone en null porque todos los nodos nuevos está DESCONECTADOS de la lista 
 public NodoDoctor (Doctor a1) {
     doctor=a1; 
     enlace = null;
 }

	

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public NodoDoctor getEnlace() {
		return enlace;
	}

	public void setEnlace(NodoDoctor enlace) {
		this.enlace = enlace;
	}

	@Override
	public String toString() {
		return doctor.toString();
	}


 
} // fin de la clase Nodo

