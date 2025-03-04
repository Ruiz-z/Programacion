package U1;

public class PiramidePentagonal {

	private float lado;
	private float altura;
	private float apotemaBase;
	
	public PiramidePentagonal() {
	}
	public PiramidePentagonal(float lado,float altura,float apotemaBase) {
 	super();
 	this.lado = lado;
 	this.altura = altura;
 	this.apotemaBase =apotemaBase;
	}
	public float getLado() {
		return lado;
	}
	public void setLado(float lado) {
		this.lado = lado;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public float getApotemaBase() {
		return apotemaBase;
	}
	public void setApotemaBase(float apotemaBase) {
		this.apotemaBase = apotemaBase;
	}
	public float calcularApotemaPiramide() {
		float aP= (float) Math.sqrt((Math.pow(altura, 2))+(Math.pow(apotemaBase, 2)));
		return aP;
	}
	public float calcularVolumen() {
		float area = (5*lado/2)*(apotemaBase + calcularApotemaPiramide());
		return area;
	}
	public String toString() {
		return "PiramidePentagonal [lado=" + lado + ", altura=" + altura + ", apotemaBase=" + apotemaBase + "]";
	}
	
	
}
