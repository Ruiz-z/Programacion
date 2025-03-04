package U2;

import javax.swing.JOptionPane;

public class ExamenUnidad2 {

	public static void main(String[] args) {
		Object[] opciones = { "1.-Insertar Producto",
				 "2.- Mostrar Bebidas", "3.- Mostrar alimentos","4.-Aumentar precio a una bebida",
				"5.-Vaciar pila de alimentos","6.- Terminar" };
		String tipo = "";
		do {
			tipo = (String) JOptionPane.showInputDialog(null, "Selecciona una opcion", tipo, JOptionPane.PLAIN_MESSAGE,
					null, opciones, opciones[0]);
			if (tipo == null) {
				tipo = "6.- Terminar";
			}
			switch (tipo) {
			case "1.-Insertar Producto":
				IngresaProducto();
				break;
			case "2.- Mostrar Bebidas":
				MostrarBebidas();
				break;
			case "3.- Mostrar alimentos":
				MostrarAlimentos();
				break;
			case "4.-Aumentar precio a una bebida":
				AumentarPrecio();
				break;
			case "5.-Vaciar pila de alimentos":
				VaciarAlimentos();
				break;
			case "6.- Terminar":
				break;
			}
		} while (!tipo.equals("6.- Terminar"));
	}
	static String salida = "";
	static PilaProductos PilaBebidas = new PilaProductos(12);
	static PilaProductos PilaAlimentos = new PilaProductos(12);

public static void IngresaProducto() {
	int clave = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la clave del producto"));
	String descripcion = JOptionPane.showInputDialog("Ingrese la descripcion del producto");
	float precio = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio del producto"));
	Producto objProducto = new Producto(clave,descripcion,precio);
	if(objProducto.getClave()%2==0) {
		if(!PilaBebidas.isFull()) {
			PilaBebidas.push(objProducto);
			JOptionPane.showMessageDialog(null,"El producto fue ingresado correctamente");
		}else {
			JOptionPane.showMessageDialog(null,"La pila esta llena");
		}}
	else {
		if(!PilaAlimentos.isFull()) {
			PilaAlimentos.push(objProducto);
			JOptionPane.showMessageDialog(null,"El producto fue ingresado correctamente");
		}else {
			JOptionPane.showMessageDialog(null, "La pila esta llena");
		}
			
		}
	}


public static void MostrarBebidas() {
	if(!PilaBebidas.isEmpty()) {
		salida+="Lista de bebidas:\n";
		salida+=PilaBebidas.toString();
		JOptionPane.showMessageDialog(null, salida);
	}else {
		JOptionPane.showMessageDialog(null, "Pila Vacia");
	}
}

public static void MostrarAlimentos() {
	if(!PilaBebidas.isEmpty()) {
		salida+="Lista de Alimentos:\n";
		salida+=PilaAlimentos.toString();
		JOptionPane.showMessageDialog(null, salida);
	}else {
		JOptionPane.showMessageDialog(null, "Pila Vacia");
	}
}

public static void AumentarPrecio() {
	int porcentaje = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el porcentaje a aumentar"));
	for(int i =0; i<PilaBebidas.size();i++) {
		float precioActual = PilaBebidas.getP()[i].getPrecio();
		float aumento = (precioActual*porcentaje/100);
		float nuevoPrecio= precioActual + aumento;
		PilaBebidas.getP()[i].setPrecio(nuevoPrecio);
		JOptionPane.showMessageDialog(null, PilaBebidas);
	}
}

public static void VaciarAlimentos() {
	do {
		if(!PilaAlimentos.isEmpty()) {
			Producto produActual = PilaAlimentos.pop();
			JOptionPane.showMessageDialog(null, "Alimento eliminado"+produActual.getDescripcion());
		}
		else {
			JOptionPane.showMessageDialog(null,"NO hay Alimentos que eliminar");
		}
	}while(!PilaAlimentos.isEmpty());
}
}
	

