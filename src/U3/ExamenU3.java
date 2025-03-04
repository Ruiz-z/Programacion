package U3;



import javax.swing.JOptionPane;

public class ExamenU3 {
public static ColaCircularFarmacias guadalajara = new ColaCircularFarmacias(10);
public static ColaCircularFarmacias benavides = new ColaCircularFarmacias(10);
	public static void main(String[] args) {

		Object[] opciones = { "1.-Insertar farmacia",
						"2.-Mostrar farmacias guadalajara", 
						"3.-Mostrar farmacias Benavides",
						"4.-Suma Total de Ventas", 
						"5.-Farmacias con menos ventas", 
						"6.-Terminar" };
		String tipo = "";
		
		do {
			tipo = (String) JOptionPane.showInputDialog(null, "Selecciona una opcion", tipo, JOptionPane.PLAIN_MESSAGE,
					null, opciones, opciones[0]);

			if (tipo == null) {
				tipo = "6.-Terminar";
			}

			switch (tipo) {

			case "1.-Insertar farmacia":
				InsertarFarmacia();
				break;

			case "2.-Mostrar farmacias guadalajara":
				MostrarGuadalajara();
				break;

			case "3.-Mostrar farmacias Benavides":
				MostrarBenavides();
				break;
			case "4.-Suma Total de Ventas":
				SumaTotal();
				break;
			case "5.-Farmacias con menos ventas":
				
				JOptionPane.showMessageDialog(null, "El articulo más barato es: "+benavides.Barabara());
			
				break;
			case "6.-Terminar":
				break;
		
			}
		} while (tipo != "6.-Terminar");

	}
	public static void InsertarFarmacia() {
		Object[] opcionFarm = {"1.Benavides","2.Guadalajara"};
		String farmTipo = "";
		String sucursal = JOptionPane.showInputDialog("Ingrese el nombre de la sucursal");
		float ventas = Float.parseFloat(JOptionPane.showInputDialog("Ingrese las ventas de la farmcia"));
		Farmacia objFarmacia= new Farmacia(sucursal, ventas);
		farmTipo = (String) JOptionPane.showInputDialog(null, "Selecciona una Farmacia", farmTipo, JOptionPane.PLAIN_MESSAGE,
				null, opcionFarm, opcionFarm[0]);
		if(farmTipo=="1.Benavides" ) {
			if(!benavides.estaLlena()) {
				benavides.insertar(objFarmacia);
			}else {JOptionPane.showMessageDialog(null, "La cola esta llena");}
			}if(farmTipo=="2.Guadalajara") {
				if(!guadalajara.estaLlena()) {
					guadalajara.insertar(objFarmacia);
				}else {JOptionPane.showMessageDialog(null, "La cola esta llena");}
				}
		}
	
	public static void MostrarGuadalajara() {
		String salida ="";
		if(!guadalajara.estaVacia()) {
			salida += "\nLista de canciones: \n";
			salida += guadalajara.toString();
			JOptionPane.showMessageDialog(null, salida);
		}else {
			JOptionPane.showMessageDialog(null, "Registro vacio");}
		}
		public static void MostrarBenavides() {
			String salida = "";
			if (!benavides.estaVacia()) {
				salida += "\nLista de articulos: \n";
				salida += benavides.toString();
				JOptionPane.showMessageDialog(null, salida);
			} else {
				JOptionPane.showMessageDialog(null, "Registro vacio");
			}
		}
public static void SumaTotal() {
	float sumaT=0;
	sumaT+=benavides.SumaT() + guadalajara.SumaT();
	JOptionPane.showMessageDialog(null,sumaT);
}

}

	


