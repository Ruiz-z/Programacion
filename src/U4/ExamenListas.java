package U4;


import javax.swing.JOptionPane;

public class ExamenListas {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				ListaCircularVendedores vendedores =new ListaCircularVendedores();
				String n;
				Float sB;
				Float v;
				Object[] opciones = { "1.-Insertar Vendedor",
						"2.-Mostrar la lista de Vendedores",
						"3.-Eliminar el ultimo vendedor",
						"4.-Sueldo neto de vendedores",
						"5.-Terminar"};
				String tipo = "";
				do {
					tipo = (String) JOptionPane.showInputDialog(null, "Selecciona una opcion", tipo, JOptionPane.PLAIN_MESSAGE,
							null, opciones, opciones[0]);
					if (tipo == null) {
						tipo = "5.-Terminar";
					}
					switch (tipo) {
					case "1.-Insertar Vendedor":
						n=JOptionPane.showInputDialog(null,"Ingrese el vendedor");
						sB=Float.parseFloat(JOptionPane.showInputDialog("Sueldo base"));
						v=Float.parseFloat(JOptionPane.showInputDialog("Ventas"));
						Vendedor vendedor = new Vendedor(n,sB,v);
						NodoVendedor unVendedor= new NodoVendedor(vendedor);
						vendedores.insertarAlfabeticamente(unVendedor);
						break;
					case"2.-Mostrar la lista de Vendedores":
						JOptionPane.showMessageDialog(null, vendedores.toString());
						break;
					case "3.-Eliminar el ultimo vendedor":
					vendedores.eliminarUltimoNodo();
		                break;  
					case "4.-Sueldo neto de vendedores":
					 vendedores.AumentarTodosLosSalarios();  
						break;
					case "5.-Terminar":
						JOptionPane.showMessageDialog (null, "Fin del Programa");
		                break;


					}
				} while (!tipo.equals("5.-Terminar"));

			}
}
