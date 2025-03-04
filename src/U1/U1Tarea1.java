package U1;
import javax.swing.JOptionPane;

public class U1Tarea1 {

	static int m[][];
	static String salida = "";
	static int suma;


	public static void GenerarMatriz() {
		int n = 0;
        try{
        do{
            n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero para crear una matriz: "));
            if(n<=0){
                JOptionPane.showMessageDialog(null,"Ingrese un numero valido para la creacion de la matriz: ");
            }
        }while(n<=0);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Solo numeros enteros");
            
        }
		m= new int[n][n];
        
		for (int x = 0; x < m.length; x++) {
			for (int y=0; y < m[x].length; y++) {
			    m[x][y] = (int) (Math.random()*100+1);
			 }
		}
	}

	public static void DesplegarMatriz() {
		salida+="Datos de la matriz:\n";
		for (int i = 0; i < m.length; i++) {
			for(int j=0;j<m.length;j++) {
				salida+="| "+m[i][j];
			}
			salida+="|\n";
		}
		JOptionPane.showMessageDialog(null,salida);
        salida="";
	}

	public static void SumaMatriz() {
		suma=0;
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[i].length;j++) {
				suma+=m[i][j];
			}
		}
		JOptionPane.showMessageDialog(null,"Suma total de la tabla: "+suma);
	}

    public static void Sustituir5s() {
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[i].length;j++) {
				if(m[i][j]%5==0){
                    m[i][j]=0;
                };
			}
		}
	}

        public static void SumaDiagonal() {
		int suma=0;
            for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[i].length;j++) {
				if(i==j){
                    suma+=m[i][j];
                };
			}
		}
        JOptionPane.showMessageDialog(null,"Suma total de la diagonal: "+suma);
	}

        public static void SustituirFilas() {
            int fila1=0;
            int fila2=0;
    try{
            fila1=Integer.parseInt(JOptionPane.showInputDialog("Primer fila a sustituir"));
            fila2=Integer.parseInt(JOptionPane.showInputDialog("Segunda fila a sustituir"));

            if(fila1<=0 || fila2<=0){
                JOptionPane.showMessageDialog(null,"Ingrese numeros validos para la matriz");
            }
       
       
        
        int[] vectorExtra=m[fila1-1];

        m[fila1-1]=m[fila2-1];
        m[fila2-1]=vectorExtra;
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,"Ingrese numeros validos");
    }
	}  



	public static void main(String[] args) {

		Object[] opciones = { "Generar Matriz", "Desplegar la matriz", "Sumar datos de la matriz",
				"Sustituir multiplos de 5 por 0s", "Sumar la diagonal principal", "Intercambiar filas",
				"Salir" };
		String tipo = "";
		do {
			tipo = (String) JOptionPane.showInputDialog(null, "Selecciona una opcion", tipo, JOptionPane.PLAIN_MESSAGE,
					null, opciones, opciones[0]);
			if (tipo == null) {
				tipo = "Salir";
			}
			switch (tipo) {
			case "Generar Matriz":
				GenerarMatriz();
				break;
			case "Desplegar la matriz":
				DesplegarMatriz();
				break;
			case "Sumar datos de la matriz":
				SumaMatriz();
				break;
			case "Sustituir multiplos de 5 por 0s":
                Sustituir5s();
				break;
			case "Sumar la diagonal principal":
                SumaDiagonal();
				break;
			case "Intercambiar filas":
                SustituirFilas();
				break;
			case "Salir":
				break;
			}
		} while (tipo!="Salir");
	}
}
