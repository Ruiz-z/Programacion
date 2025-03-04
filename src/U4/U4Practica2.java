package U4;

import javax.swing.JOptionPane;

public class U4Practica2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				ListaArticulos abarrotes=new ListaArticulos();
				String d;
				int c=0;
				float p=0;
				
				Object[] opciones = { "1.- Insertar un articulo al inicio", "2.- Insertar un articulo al final", 
						"3.- Mostrar la lista de articulos",
						"4.- Aumentar precios","5.- Buscar un articulo" ,"6.- Elimianr el nodo del inicio","7.- Articulo mas caro","8.- Terminar"};
				String tipo = "";
				do {
					tipo = (String) JOptionPane.showInputDialog(null, "Selecciona una opcion", tipo, JOptionPane.PLAIN_MESSAGE,
							null, opciones, opciones[0]);
					if (tipo == null) {
						tipo = "6.- Terminar";
					}
					switch (tipo) {
					case "1.- Insertar un articulo al inicio":
						d=JOptionPane.showInputDialog(null,"Ingrese la descripcion del articulo");
						c=Integer.parseInt(JOptionPane.showInputDialog("Cantidad del articulo"));
						p=Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio del articulo"));
						NodoArticulo unArticulo= new NodoArticulo(d, c, p);
						abarrotes.insertaInicio(unArticulo);
						break;
					case "2.- Insertar un articulo al final":
						d = JOptionPane.showInputDialog ("Descripcion del articulo:");
		                c = Integer.parseInt (JOptionPane.showInputDialog ("Cantidad: "));
		                p = Float.parseFloat (JOptionPane.showInputDialog ("Precio: "));
		                //insertar el articulo, creando un NodoArticulo con los datos leidos
		                abarrotes.insertaFinal (new NodoArticulo (d,c,p));
						break;
					case "3.- Mostrar la lista de articulos":
						JOptionPane.showMessageDialog (null, abarrotes.toString());
		                break;
					case "4.- Aumentar precios":
						JOptionPane.showMessageDialog(null,"Precio aumentado Exitosamente");
						break;
					case "5.- Buscar un articulo":
						String buscar = JOptionPane.showInputDialog("Ingrese el articulo a buscar");
						if (abarrotes.buscar(buscar) == true) {
							JOptionPane.showMessageDialog(null, "El articulo fue encontrado: " + buscar);
						} else {
							JOptionPane.showMessageDialog(null, "El articulo no fue encontrado en la lista");
						}
						break;
                    case "6.- Elimianr el nodo del inicio":
                        abarrotes.EliminarNodoInicial();
                    break;
                    case  "7.- Articulo mas caro":
                        JOptionPane.showMessageDialog(null,"Articulo más caro:\n"+abarrotes.ArticuloMasCaro().toString());
                    break;
                   
					case "8.- Terminar":
						JOptionPane.showMessageDialog (null, "Fin del Programa");
		                break;


					}
				} while (!tipo.equals("8.- Terminar"));

			}

	}