package U3;

import javax.swing.JOptionPane;
public class U3Practica3 {
	public static ColaCanciones playlist = new ColaCanciones(12);
	public static String salida="";
	public static void main(String[] args) {
		Object[] opciones = {"1.-Guardar cancion","2.-Mostrar Lista de canciones","3.-Eliminar una cancion",
				"4.-Mostrar cancion del inicio","5.-Mostrar cancion del fin","6.-cantidad de canciones",
				"7.-Duracion de la playlist","8.-cancion de duracion mayor","9.-Buscar cancion por titulo",
				"10.-Terminar"};
String tipo = "";
do {
	tipo = (String) JOptionPane.showInputDialog(null, "Selecciona una opcion", tipo, JOptionPane.PLAIN_MESSAGE,
			null, opciones, opciones[0]);
	if (tipo == null) {
		tipo = "10.- Terminar";
	}
	switch (tipo) {

	case "1.-Guardar cancion":
       GuardarCancion();
		break;


	case "2.-Mostrar Lista de canciones":
		MostrarListaCanciones();
		break;

	case "3.-Eliminar una cancion":
		if(!playlist.estaVacia()) {
			JOptionPane.showMessageDialog(null,"Cancion borrada: "+playlist.eliminar());
		}else {
			JOptionPane.showMessageDialog(null, "No hay canciones que eliminar");
		}
		break;
	case "4.-Mostrar cancion del inicio":
		if(!playlist.estaVacia()) {
			JOptionPane.showMessageDialog(null,playlist.datoEnFrente().getTitulo());
		}else {JOptionPane.showMessageDialog(null, "No hay canciones");}
		break;

	case "5.-Mostrar cancion del fin":
		if(!playlist.estaVacia()) {
			JOptionPane.showMessageDialog(null,playlist.datoEnFin().getTitulo());
		}else {JOptionPane.showMessageDialog(null, "No hay cancion al final");}
		break;
	case "6.-cantidad de canciones":
		JOptionPane.showMessageDialog(null, playlist.numElementos()+" Canciones");
		break;
	case "7.-Duracion de la playlist":
		JOptionPane.showMessageDialog(null, playlist.duracionPlaylist()+" Minutos");
		break;
	case "8.-cancion de duracion mayor":
		JOptionPane.showMessageDialog(null, playlist.encontrarMayorDuracion());
		break;
	case "9.-Buscar cancion por titulo":
		String buscar = JOptionPane.showInputDialog("Ingrese el titulo de la cancion por buscar");
		JOptionPane.showMessageDialog(null,playlist.buscarPorTitulo(buscar));
		break;
	case "10.-Terminar":
		break;
	}
}while(tipo!="10.-Terminar");
}

	public static void GuardarCancion() {
	String Titulo = JOptionPane.showInputDialog("Ingrese el titulo de la cancion");
	String Interprete = JOptionPane.showInputDialog("Ingrese el interprete de la cancion");
	float duracion = Float.parseFloat(JOptionPane.showInputDialog("Inserte la duracion de la cancion"));
	Cancion objCancion= new Cancion(Titulo,Interprete,duracion);
	if(!playlist.estaLlena()) {
		playlist.insertar(objCancion);
		JOptionPane.showMessageDialog(null,"Cancion ingresada correctamente");
	}else {
		JOptionPane.showMessageDialog(null, "La cola esta llena");
	}
	
}

public static void MostrarListaCanciones() {
	salida ="";
	if(!playlist.estaVacia()) {
		salida += "\nLista de canciones: \n";
		salida += playlist.toString();
		JOptionPane.showMessageDialog(null, salida);
	}else {
		JOptionPane.showMessageDialog(null, "Registro vacio");
	}
}

}