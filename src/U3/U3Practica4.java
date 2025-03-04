package U3;

import javax.swing.JOptionPane;

public class U3Practica4 {
	static ColaCircularArticulos farmacia = new ColaCircularArticulos(4);

	public static void main(String[] args) {

		Object[] opciones = { "1.- Agregar articulo", "2.- Lista de articulos", "3.- Eliminar un articulo",
				"4.- Buscar un articulo", "5.- Inventario total", "6.- Terminar" };

		String tipo = "";

		do {
			tipo = (String) JOptionPane.showInputDialog(null, "Selecciona una opcion", tipo, JOptionPane.PLAIN_MESSAGE,
					null, opciones, opciones[0]);

			if (tipo == null) {
				tipo = "6.- Terminar";
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


			}
		} while (tipo != "6.- Terminar");

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
