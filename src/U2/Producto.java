package U2;

public class Producto {
int clave;
String descripcion;
float precio;
public Producto(int clave, String descripcion, float precio) {
	this.clave = clave;
	this.descripcion = descripcion;
	this.precio = precio;
}
public int getClave() {
	return clave;
}
public void setClave(int clave) {
	this.clave = clave;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public float getPrecio() {
	return precio;
}
public void setPrecio(float precio) {
	this.precio = precio;
}

public String toString() {
	return "Producto:"+"\nclave:" + clave +"\ndescripcion:" 
			+ descripcion + "\nprecio:" + precio;
}




}
