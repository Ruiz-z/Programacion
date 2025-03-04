package U3;

public class Cancion {
private String Titulo;
private String Interprete;
private float duracion;

public Cancion(String titulo, String interprete, float duracion) {
	super();
	Titulo = titulo;
	Interprete = interprete;
	this.duracion = duracion;
}
public Cancion() {
	
}
public String getTitulo() {
	return Titulo;
}
public void setTitulo(String titulo) {
	Titulo = titulo;
}
public String getInterprete() {
	return Interprete;
}
public void setInterprete(String interprete) {
	Interprete = interprete;
}
public float getDuracion() {
	return duracion;
}
public void setDuracion(float duracion) {
	this.duracion = duracion;
}
@Override
public String toString() {
	return "Cancion"+"\nTitulo:" + Titulo + 
			"\nInterprete:" + Interprete + "\nDuracion:" + duracion;
}


}
