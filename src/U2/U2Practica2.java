package U2;
import javax.swing.JOptionPane;

public class U2Practica2 {
    public static void main(String[] args){
        PilaChar pila1;
        PilaChar pila2;
        Boolean seguir = true;

        do{
        String mensaje = JOptionPane.showInputDialog("Ingrese el mensaje que desea codificar:  ");
        
        if(mensaje.length()%2==0){
            pila1 = new PilaChar(mensaje.length()/2);
            pila2 = new PilaChar(mensaje.length()/2);
        }else{
            pila1 = new PilaChar((mensaje.length()/2)+1);
            pila2 = new PilaChar(mensaje.length()/2);  
        }

        

        for (int i=0;i<mensaje.length();i++) {

            if(i%2==0){
                pila1.push(mensaje.charAt(i));
            }

            if(i%2!=0){
                pila2.push(mensaje.charAt(i));
            }
        }

        String MensajeSecreto="#";

        for (int i=0;i<(String.valueOf(pila1.getP()).length());i++) {
            
            if(!pila1.isEmpty()){
                MensajeSecreto+=pila1.pop();
            }

            if(!pila1.isEmpty()){
                MensajeSecreto+=pila1.pop();
            }

            if(!pila2.isEmpty()){
                MensajeSecreto+=pila2.pop();
            }

            if(!pila2.isEmpty()){
                MensajeSecreto+=pila2.pop();
            }
        }

        String UltimaLetra = String.valueOf(MensajeSecreto.charAt(MensajeSecreto.length()-1));
        
        if(UltimaLetra.equalsIgnoreCase("a") ||
        UltimaLetra.equalsIgnoreCase("e")   ||
        UltimaLetra.equalsIgnoreCase("i")   ||
        UltimaLetra.equalsIgnoreCase("o")   ||
        UltimaLetra.equalsIgnoreCase("u")){
            MensajeSecreto+="@";
        }else{
            MensajeSecreto+="y";
        }
        

            JOptionPane.showMessageDialog(null,"Frase original: "+mensaje+"\n\nCodificado: "+MensajeSecreto);
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea codificar otro mensaje?", null, JOptionPane.YES_NO_OPTION);
            if(respuesta==1)seguir=false;

        }while(seguir==true);
        
    }
}
