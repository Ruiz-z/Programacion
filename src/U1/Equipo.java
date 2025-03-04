package U1;

public class Equipo {
 String nombre;
 int division;
 int puntos;
public Equipo(String nombre, int division, int puntos) {
	this.nombre = nombre;
	this.division = division;
	this.puntos = puntos;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public int getDivision() {
	return division;
}
public void setDivision(int division) {
	this.division = division;
}
public int getPuntos() {
	return puntos;
}
public void setPuntos(int puntos) {
	this.puntos = puntos;
}
@Override
public String toString() {
	return "Equipo:\n"+"nombre: " + nombre + 
			"\ndivision:" + division + "\npuntos:" + puntos;
}

 
 
}
