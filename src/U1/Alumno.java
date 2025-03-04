package U1;

import java.util.Arrays;

//clase instanciable para manejo de alumnos

public class Alumno {
    //atributos
    private String nombre;
    private float numControl;
    private int edad;  
    private float [] calif;
    
    //constuctores
    public Alumno() {
        nombre = "";
        numControl = 0;
        edad = 0;
        calif = new float [1];
    }
    
    public Alumno (String n, float nc, int e,float[] c){
        nombre = n;
        numControl = nc;
        edad = e;
        calif = c;
    }
    
    // getters
    public String getNombre ( ) {
        return nombre;
    }
    
    public float getNumControl ( ) {
        return numControl;
    }
    
    public float[] getCalif() {
		return calif;
	}

	

	public float getEdad ( ) {
        return edad;
    }
    
    //setters
    public void setNombre (String nuevoNombre){
        nombre = nuevoNombre;
    }
    
    public void setNumControl (int nuevoNc){
       numControl = nuevoNc; 
    }
    
    public void setEdad (int nuevaEdad){
        edad = nuevaEdad;
    }
    public void setCalif(float[] calif) {
		this.calif = calif;
	}
    //metodos
    public float calcularPromedio() {
    	float promedio=0;
    	for(int i = 0; i<calif.length;i++) {
    		promedio += calif[i];}
    	return promedio/calif.length;
    }
    public float califMayor() {
    	float califMayor=0;
    	for(int i=0;i<calif.length;i++) {
    		if(calif[i]>califMayor) {
    			califMayor = calif[i];
    		}
    	}
    	return califMayor;
    }
    public void aumentarCalif(float puntos) {
    	for(int i=0;i<calif.length;i++) {
    		if(calif[i]+puntos<=100) {
    			calif[i]= (calif[i]+puntos);
    		}
    	}
    }
    //toString heredado de la clase Object
    public String toString(){
        String s = "";
        s = "Alumno: " + nombre;
        s+= " numero de control: " + numControl +"  Edad: " + edad;
        s+= "calif"+Arrays.toString(calif)+"\n"
        		+ "";
        return s;
    }
}
