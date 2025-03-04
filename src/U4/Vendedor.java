package U4;

public class Vendedor {
private String nombre;
private float sueldoBase;
private float ventas;
public Vendedor(String nombre, float sueldoBase, float ventas) {
	this.nombre = nombre;
	this.sueldoBase = sueldoBase;
	this.ventas = ventas;
}
public Vendedor() {
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public float getSueldoBase() {
	return sueldoBase;
}
public void setSueldoBase(float sueldoBase) {
	this.sueldoBase = sueldoBase;
}
public float getVentas() {
	return ventas;
}
public void setVentas(float ventas) {
	this.ventas = ventas;
}
public String toString() {
	return "vendedor"+"\nNombre:" + nombre + 
			"\nSueldo Base:" + sueldoBase + 
			"\nVentas:" + ventas;
}


}
