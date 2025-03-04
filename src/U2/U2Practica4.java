package U2;

import javax.swing.JOptionPane;

//import Practicas.Libro;
//import Practicas.PilaLibros;

public class U2Practica4 {

    public static void main (String []largs){
        		Object[] opciones = { "1.- Insertar un libro", "2.- Eliminar un libro de Historia",
				"3.- Eliminar un libro de Novela", "4.- Mostrar libros de Historia", "5.- Mostrar libros de Novela",
				"6.- Terminar" };
		String tipo = "";
		do {
			tipo = (String) JOptionPane.showInputDialog(null, "Selecciona una opcion", tipo, JOptionPane.PLAIN_MESSAGE,
					null, opciones, opciones[0]);
			if (tipo == null) {
				tipo = "6.- Terminar";
			}
			switch (tipo) {
			case "1.- Insertar un libro":
				IngresarLibro();
				break;
			case "2.- Eliminar un libro de Historia":
				EliminarLibroHistoria();
				break;
			case "3.- Eliminar un libro de Novela":
				EliminarLibroNovela();
				break;
			case "4.- Mostrar libros de Historia":
				MostrarListaHistoria();
				break;
			case "5.- Mostrar libros de Novela":
				MostrarListaNovelas();
				break;
			case "6.- Terminar":
				break;
			}
		} while (!tipo.equals("6.- Terminar"));
	}

	static String salida = "";
	static PilaLibro PilaHistorias = new PilaLibro(5);
	static PilaLibro PilaNovelas = new PilaLibro(7);
	
	public static void IngresarLibro() {
		String titulo = JOptionPane.showInputDialog("Ingrese el titulo del libro");
		String autor = JOptionPane.showInputDialog("Ingrese el autor del libro");
		float precio = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio del libro"));
		Libro objLibro = new Libro(titulo,autor,precio);
		if (objLibro.getPrecio() < 300) {
			if (!PilaNovelas.isFull()) {
				PilaNovelas.push(objLibro);
				JOptionPane.showMessageDialog(null,"Libro ingresado correctamente");
			}else {
				JOptionPane.showMessageDialog(null,"La pila de novelas esta llena");
			}
		} else {
			if (!PilaHistorias.isFull()) {
				PilaHistorias.push(objLibro);
				JOptionPane.showMessageDialog(null,"Libro ingresado correctamente");
			}else {
				JOptionPane.showMessageDialog(null,"La pila de libros de historia esta llena");
			}
		}
	}

	public static void EliminarLibroHistoria() {
		if (!PilaHistorias.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Libro borrado: " + PilaHistorias.pop());
		} else {
			JOptionPane.showMessageDialog(null, "No hay historias que eliminar");
		}
	}

	public static void EliminarLibroNovela() {
		if (!PilaNovelas.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Libro borrado: " + PilaNovelas.pop());
		} else {
			JOptionPane.showMessageDialog(null, "No hay novelas que eliminar");
		}
	}
	public static void MostrarListaHistoria() {
		if(!PilaHistorias.isEmpty()) {
			salida+="Lista de libros de historia:\n";
			salida+=PilaHistorias.toString();
			JOptionPane.showMessageDialog(null, salida);
		}else {
			JOptionPane.showMessageDialog(null,"Registro vacio");
		}
		
	}
	public static void MostrarListaNovelas() {
		if(!PilaNovelas.isEmpty()) {
			salida+="Lista de libros novelas:\n";
			salida+=PilaNovelas.toString();
			JOptionPane.showMessageDialog(null, salida);
		}else {
			JOptionPane.showMessageDialog(null,"Registro vacio");
		}
	}	
    }
