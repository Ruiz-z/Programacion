package U3;

import javax.swing.JOptionPane;

public class U3Tarea1 {
	static ColaCircularArticulos farmacia = new ColaCircularArticulos(4);

	public static void main(String[] args) {

		Object[] opciones = { "1.- Agregar articulo", "2.- Lista de articulos", "3.- Eliminar un articulo",
				"4.- Buscar un articulo", "5.- Inventario total", "6.- Aumentar precio", "7.- Articulo más barato",
				"8.- Articulos con cantidad < 10", "9.- Modificar descripción", "10.- Invertir orden de los articulos",
				"11.- Terminar" };
		String tipo = "";

		do {
			tipo = (String) JOptionPane.showInputDialog(null, "Selecciona una opcion", tipo, JOptionPane.PLAIN_MESSAGE,
					null, opciones, opciones[0]);

			if (tipo == null) {
				tipo = "11.- Terminar";
			}

			switch (tipo) {

			case "1.- Agregar articulo":
				InsertarArticulo();
				break;

			case "2.- Lista de articulos":
				ListaDeArticulos();

				break;

			case "3.- Eliminar un articulo":
				if (!farmacia.estaVacia()) {
					JOptionPane.showMessageDialog(null, "Articulo borrado: " + farmacia.eliminar());
				} else {
					JOptionPane.showMessageDialog(null, "No hay articulos que eliminar");
				}
				break;

			case "4.- Buscar un articulo":
				String buscar = JOptionPane.showInputDialog("Ingrese el articulo a buscar");
				if (farmacia.buscar(buscar) == true) {
					JOptionPane.showMessageDialog(null, "El articulo fue encontrado: " + buscar);
				} else {
					JOptionPane.showMessageDialog(null, "El articulo no fue encontrado en la lista");
				}
				
				break;
			case "5.- Inventario total":
				if (farmacia.estaVacia()) {
					JOptionPane.showMessageDialog(null, "NO HAY INVENTARIO PARA MOSTRAR");
				}
				else {
					JOptionPane.showMessageDialog(null, "Inventario total: \n" +  "$" + farmacia.inventarioTotal());
				}
				break;
			case "6.- Aumentar precio":
				JOptionPane.showMessageDialog(null,"Articulos despues de aumentar precio: "+farmacia.Corrupcion()); 
				break;
			case "7.- Articulo más barato":
				JOptionPane.showMessageDialog(null, "El articulo más barato es: "+farmacia.Barabara());
				break;
			case "8.- Articulos con cantidad < 10":
				JOptionPane.showMessageDialog(null, "Los articulos con cantidad menor a 10 son: "+farmacia.Menor10());
				break;
			case "9.- Modificar descripción":
				String Modificar=JOptionPane.showInputDialog("Ingrese el articulo a modificar");
				if (farmacia.Modificar(Modificar) == true) {
					JOptionPane.showMessageDialog(null, "El articulo fue modificado: " + Modificar);
				} else {
					JOptionPane.showMessageDialog(null, "El articulo no fue encontrado en la lista");
				}
				break;
			case "10.- Invertir orden de los articulos":
				farmacia.Invertir();
				JOptionPane.showMessageDialog(null,"La cola invertida es: "+farmacia.toString());
				break;
			case "11.- Terminar":
				break;
			}
		} while (tipo != "11.- Terminar");

	}
	public static void InsertarArticulo() {
		String descripcion = JOptionPane.showInputDialog("Descripcion del articulo: ");
		int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad: "));
		float precio = Float.parseFloat(JOptionPane.showInputDialog("Precio: "));
		Articulo articulo = new Articulo(descripcion, cantidad, precio);
		if (!farmacia.estaLlena()) {
			farmacia.insertar(articulo);
			JOptionPane.showMessageDialog(null, "Articulo ingresado correctamente");
		} else {
			JOptionPane.showMessageDialog(null, "La farmacia esta llena");
		}
	}
	public static void ListaDeArticulos() {
		String salida = "";
		if (!farmacia.estaVacia()) {
			salida += "\nLista de articulos: \n";
			salida += farmacia.toString();
			JOptionPane.showMessageDialog(null, salida);
		} else {
			JOptionPane.showMessageDialog(null, "Registro vacio");
		}
	}


}
