package U4;

import javax.swing.JOptionPane;

public class U4Practica4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				ListaArticulos abarrotes=new ListaArticulos();
				String d;
				int c=0;
				float p=0;
				
				Object[] opciones = { "1.- Insertar un articulo alfabeticamente",
						"2.-Mostrar la lista de articulos",
						"3.-Eliminar el ultimo articulo",
						"4.-Aumentar el precio de un articulo",
						"5.-Eliminar segundo nodo",
						"6.-Terminar"};
				String tipo = "";
				do {
					tipo = (String) JOptionPane.showInputDialog(null, "Selecciona una opcion", tipo, JOptionPane.PLAIN_MESSAGE,
							null, opciones, opciones[0]);
					if (tipo == null) {
						tipo = "6.-Terminar";
					}
					switch (tipo) {
					case "1.- Insertar un articulo alfabeticamente":
						d=JOptionPane.showInputDialog(null,"Ingrese la descripcion del articulo");
						c=Integer.parseInt(JOptionPane.showInputDialog("Cantidad del articulo"));
						p=Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio del articulo"));
						NodoArticulo unArticulo= new NodoArticulo(d, c, p);
						abarrotes.insertaAlfabetico(unArticulo);;
						break;
					case "2.-Mostrar la lista de articulos":
						abarrotes.recorreLista();
						break;
					case "3.-Eliminar el ultimo articulo":
						if((!abarrotes.listaVacia())){
							JOptionPane.showMessageDialog(null,"Articulo Eliminado: "+ abarrotes.EliminarUltimoNodo().toString());
					}else{
						JOptionPane.showMessageDialog(null, "Lista Vacia");
					}
		                break;  
					case "4.-Aumentar el precio de un articulo":
						abarrotes.AumentarPrecioEsp();
						break;
					case "5.-Eliminar segundo nodo":
					
                            if (abarrotes.getNumNodos()>=2){
                                JOptionPane.showMessageDialog(null,"Articulo Eliminado: "+ abarrotes.eliminarSegundoNodo().toString());
					}else{
						JOptionPane.showMessageDialog(null, "Hay menos de 2 nodos");
					}
						break;
					case "6.-Terminar":
						JOptionPane.showMessageDialog (null, "Fin del Programa");
		                break;


					}
				} while (!tipo.equals("6.-Terminar"));

			}
}
