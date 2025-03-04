package U3;

public class Farmacia {
private String sucursal;
private float ventas;
public Farmacia(String sucursal, float ventas) {
	this.sucursal = sucursal;
	this.ventas = ventas;
}
public String getSucursal() {
	return sucursal;
}
public void setSucursal(String sucursal) {
	this.sucursal = sucursal;
}
public float getVentas() {
	return ventas;
}
public void setVentas(float ventas) {
	this.ventas = ventas;
}
@Override
public String toString() {
	return "\nFarmacia"+"\nsucursal:" + sucursal + "\nventas:" + ventas;
}


}
