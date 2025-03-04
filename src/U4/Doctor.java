package U4;

public class Doctor {
String nombre;
String especialidad;
float sueldo;
public Doctor() {
}
public Doctor(String nombre, String especialidad, float sueldo) {
	super();
	this.nombre = nombre;
	this.especialidad = especialidad;
	this.sueldo = sueldo;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getEspecialidad() {
	return especialidad;
}
public void setEspecialidad(String especialidad) {
	this.especialidad = especialidad;
}
public float getSueldo() {
	return sueldo;
}
public void setSueldo(float sueldo) {
	this.sueldo = sueldo;
}
public String toString() {
	return "Doctor"+"\nNombre=" + nombre + 
			"\nEspecialidad:" + especialidad + 
			"\nSueldo:" + sueldo;
}


}
