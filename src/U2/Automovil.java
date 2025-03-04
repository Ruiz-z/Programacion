package U2;

public class Automovil {
	private String placa;
	private String propietario;
	private String marca;
	
	public Automovil(String placa, String propietario, String marca) {
		super();
		this.placa = placa;
		this.propietario = propietario;
		this.marca = marca;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Automovil: \n"+ "Placa: " + placa + "\nPropietario: " + propietario + "\nMarca: " + marca;
	}
	
	
}
