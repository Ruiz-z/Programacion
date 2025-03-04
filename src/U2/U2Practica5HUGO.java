package U2;

import javax.swing.JOptionPane;

import utilidades.SalidaFor;

public class U2Practica5HUGO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object[] opciones = { "1.- Insertar un libro", "2.- Eliminar un libro de Historia",
				"3.- Eliminar un libro de Novela", "4.- Mostrar libros de Historia", "5.- Mostrar libros de Novela",
				"6. Libro de historia en el tope de la pila", "7. Aumentar precio de todos los libros",
				"8. Vaciar la pila de Novelas", "9. Precio total de libros", "10.- Terminar" };
		String tipo = "";
		do {
			tipo = (String) JOptionPane.showInputDialog(null, "Selecciona una opcion", tipo, JOptionPane.PLAIN_MESSAGE,
					null, opciones, opciones[0]);
			if (tipo == null) {
				tipo = "Salir";
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
			case "6. Libro de historia en el tope de la pila":
				SayMyName();
				break;
			case "7. Aumentar precio de todos los libros":
				Corrupcion();
				break;
			case "8. Vaciar la pila de Novelas":
				VaciarNovelas();
				break;
			case "9. Precio total de libros":
				PrecioTotal();
				break;
			case "10.- Terminar":
				break;
			}
		} while (!tipo.equals("10.- Terminar"));
	}

	static String salida = "";
	static PilaLibro PilaHistorias = new PilaLibro(5);
	static PilaLibro PilaNovelas = new PilaLibro(7);

	public static void IngresarLibro() {
		String titulo = JOptionPane.showInputDialog("Ingrese el titulo del libro");
		String autor = JOptionPane.showInputDialog("Ingrese el autor del libro");
		float precio = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio del libro"));
		Libro objLibro = new Libro(titulo, autor, precio);
		if (objLibro.getPrecio() < 300) {
			if (!PilaNovelas.isFull()) {
				PilaNovelas.push(objLibro);
				JOptionPane.showMessageDialog(null, "Libro ingresado correctamente");
			} else {
				JOptionPane.showMessageDialog(null, "La pila de novelas esta llena");
			}
		} else {
			if (!PilaHistorias.isFull()) {
				PilaHistorias.push(objLibro);
				JOptionPane.showMessageDialog(null, "Libro ingresado correctamente");
			} else {
				JOptionPane.showMessageDialog(null, "La pila de libros de historia esta llena");
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
		if (!PilaHistorias.isEmpty()) {
			salida += "\nLista de libros de historia: \n";
			salida += PilaHistorias.toString();
			SalidaFor.imprimerConScroll(salida);
		} else {
			JOptionPane.showMessageDialog(null, "Registro vacio");
		}

	}

	public static void MostrarListaNovelas() {
		if (!PilaNovelas.isEmpty()) {
			salida += "\nLista de libros novelas: \n";
			salida += PilaNovelas.toString();
			SalidaFor.imprimerConScroll(salida);
		} else {
			JOptionPane.showMessageDialog(null, "Registro vacio");
		}
	}

	public static void SayMyName() {
		if (!PilaHistorias.isEmpty()) {
			JOptionPane.showMessageDialog(null, PilaHistorias.getP()[PilaHistorias.getTope()].getTitulo());
		} else {
			JOptionPane.showMessageDialog(null, "NO HAY LIBROS DE HISTORIA");
		}
	}

	public static void Corrupcion() {
		int porcentaje = Integer
				.parseInt(JOptionPane.showInputDialog("Ingrese el porcentaje a aumentar en todos los libros: "));
		for (int i = 0; i < PilaHistorias.size(); i++) {
			float precioActual = PilaHistorias.getP()[i].getPrecio();
			float aumento = (precioActual * porcentaje / 100);
			float nuevoPrecio = precioActual + aumento;
			JOptionPane.showMessageDialog(null, "Precio antes de aumento: " + PilaHistorias.getP()[i].getPrecio());
			PilaHistorias.getP()[i].setPrecio(nuevoPrecio);
			JOptionPane.showMessageDialog(null, PilaHistorias);
		}
		for (int i = 0; i < PilaNovelas.size(); i++) {
			float precioActual = PilaNovelas.getP()[i].getPrecio();
			float aumento = (precioActual * porcentaje / 100);
			float nuevoPrecio = precioActual + aumento;
			JOptionPane.showMessageDialog(null, "Precio antes de aumento: " + PilaNovelas.getP()[i].getPrecio());
			PilaNovelas.getP()[i].setPrecio(nuevoPrecio);
			JOptionPane.showMessageDialog(null, PilaNovelas);
		}
	}

	public static void VaciarNovelas() {
		do {
			if (!PilaNovelas.isEmpty()) {
				Libro libroactual = PilaNovelas.pop();
				JOptionPane.showMessageDialog(null, "Libro eliminado: " + libroactual.getTitulo());
			} else {
				JOptionPane.showMessageDialog(null, "NO HAY LIBROS DE NOVELA PARA ELIMINAR");
			}
		} while (!PilaNovelas.isEmpty());
	}

	public static void PrecioTotal() {
		float SumaTotal = 0;
		float SumaNovelas = 0;
		float SumaHistorias = 0;
		for (int i = 0; i < PilaNovelas.size(); i++) {
			SumaNovelas += PilaNovelas.getP()[i].getPrecio() + SumaNovelas;
		}
		for (int i = 0; i < PilaHistorias.size(); i++) {
			SumaHistorias += PilaHistorias.getP()[i].getPrecio() + SumaHistorias;
		}
		SumaTotal = SumaHistorias + SumaNovelas;
		salida += "\nSuma total de novelas: " + SumaNovelas;
		salida += "\nSuma total de historias: " + SumaHistorias;
		salida += "\nSuma total de ambas pilas: " + SumaTotal;
		SalidaFor.imprimerConScroll(salida);
	}
}
//Metodos para eliminar libros especificos
	/*public static void EliminarLibroHistoria() {
	if (!PilaHistorias.isEmpty()) {
      
      String libroABuscar =JOptionPane.showInputDialog("Ingrese el libro a eliminar: ");
      PilaLibros pilaAuxiliar = new PilaLibros(7);
      boolean encontrado = false;
      while (!PilaHistorias.isEmpty()) {
          Libro LibroActual = PilaHistorias.pop();
          if (LibroActual.getTitulo().equalsIgnoreCase(libroABuscar)) {
              JOptionPane.showMessageDialog(null,"Libro eliminado: " +
          LibroActual);
              encontrado = true;
              break;
          } else {
              pilaAuxiliar.push(LibroActual);
          }
      }

      while (!pilaAuxiliar.isEmpty()) {
          PilaHistorias.push(pilaAuxiliar.pop());
      }

      if (!encontrado) {
           JOptionPane.showMessageDialog(null,"Libro no encontrado en el registro.");
      }
  } else {
  	JOptionPane.showMessageDialog(null,"Registro vacio, no se puede sacar ningun libro");
  }
	salida=PilaHistorias.toString();
}
public static void EliminarLibroNovela() {
	if (!PilaNovelas.isEmpty()) {
      
      String libroABuscar =JOptionPane.showInputDialog("Ingrese el libro a eliminar: ");
      PilaLibros pilaAuxiliar = new PilaLibros(7);
      boolean encontrado = false;
      while (!PilaNovelas.isEmpty()) {
          Libro LibroActual = PilaNovelas.pop();
          if (LibroActual.getTitulo().equalsIgnoreCase(libroABuscar)) {
              JOptionPane.showMessageDialog(null,"Libro eliminado: " +
          LibroActual);
              encontrado = true;
              break;
          } else {
              pilaAuxiliar.push(LibroActual);
          }
      }

      while (!pilaAuxiliar.isEmpty()) {
      	PilaNovelas.push(pilaAuxiliar.pop());
      }

      if (!encontrado) {
           JOptionPane.showMessageDialog(null,"Libro no encontrado en el registro.");
      }
  } else {
  	JOptionPane.showMessageDialog(null,"Registro vacio, no se puede sacar ningun libro");
  }
	salida=PilaNovelas.toString();
}*/

