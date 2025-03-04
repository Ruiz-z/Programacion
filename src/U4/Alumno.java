package U4;
import java.util.Arrays;
//clase instanciable para manejo de alumnos

public class Alumno {
    //atributos
    private String nombre;
    private int numControl;
    private int edad;  
    private float[] calif;
    
    //constuctores
    public Alumno() {
        nombre = "";
        numControl = 0;
        edad = 0;
        calif = null;
    }
    
    public Alumno (String n, int nc, int e, float[] c){
        nombre = n;
        numControl = nc;
        edad = e;
        calif = c;
    }
    
    // getters
    public String getNombre ( ) {
        return nombre;
    }
    
    public float getNumControl ( ) {
        return numControl;
    }
    
    public float getEdad ( ) {
        return edad;
    }

    public float[] getCalif() {
      return calif;
    }

    public float getPromedio () {
      float sumatoria = 0;
      for(int i=0; i < this.calif.length; i++)
        sumatoria += this.calif[i];

      return sumatoria / this.calif.length;
    }
    
    //setters
    public void setNombre (String nuevoNombre){
        nombre = nuevoNombre;
    }
    
    public void setNumControl (int nuevoNc){
       numControl = nuevoNc; 
    }
    
    public void setEdad (int nuevaEdad){
        edad = nuevaEdad;
    }

    public void setCalif (float[] nuevasC) {
      calif = nuevasC;
    }

    //métodos de instancia
    public String datosAlumno() {
      String s = "";

      s = "Alumno: " + nombre;
      s += "\nNúmero de control: " + numControl;
      s += "\nEdad: " + edad;
      s += "\nPromedio: " + this.getPromedio();

      return s;
    }

    //toString heredado de la clase Object
    public String toString(){
        String s = "";

        s = "Alumno: " + nombre;
        s += "  Num.Control: " + numControl +"  Edad: " + edad;
        s += "  Calificaciones: " + Arrays.toString(calif);

        return s;
    }
}
