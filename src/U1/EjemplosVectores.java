package U1;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class EjemplosVectores {

	public static void main(String[] args) {
//		int [] v1 = new int [12];
//		//System.out.println(v1);//Muestra la direccion de memoria(Referencia)
     	//for(int i=0; i<=gpoA.length;i+=2) {
		// system.out.println(Arrays.toString(v1));
//		v1[i]=33;
//		char vocales []= {'a','e','i','o','u'};
//		System.out.println("Vocales minusculas:\n"+Arrays.toString(vocales));
		
		// vector alumnos
     		Alumno[] gpoA = new Alumno[4];
    		
    		gpoA[0]= new Alumno("Hugo",123,18,new float[] {100,20,70});
    		gpoA[2]= new Alumno("paco",124,18, null);
    		System.out.println(gpoA[0]);
//	}  
	//}
		for(int i=8;i<gpoA.length;i++) {
			String nombre = JOptionPane.showInputDialog(null, "Ingrese su nombre:");
			
		}
	}
}