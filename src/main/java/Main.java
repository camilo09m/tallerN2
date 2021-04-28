import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ordenarArray();
    }
    public static void ordenarArray(){
        int contadorPal=0;
        List<String> lista = new ArrayList<>();
        lista = leerArchivo("cadenas.txt");
        for (int i=0; i<lista.size();i++){
            String palabra = limpiarpalabra(lista.get(i));
            if(esPalindromo(palabra)==true){
                contadorPal++;
                System.out.println("En el archivo existen: "+ contadorPal+" palindromos");
            }
        }
    }
    public static ArrayList leerArchivo(String ruta) {
        List<String> lista = new ArrayList<>();
        try (FileReader fr = new FileReader(ruta);
             BufferedReader br = new BufferedReader(fr)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(linea);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return (ArrayList) lista;
    }

    public static String limpiarpalabra(String cadena) {
        String limpio = null;
        if (cadena != null) {
            String valor = cadena;
            valor = valor.toLowerCase();
            limpio = Normalizer.normalize(valor, Normalizer.Form.NFD);
            limpio = limpio.replaceAll("[(ASCII 255),(N\u0303)(n\u0303),( )(\u00A1)(\u00BF)(\u00B0)(U\u0308)(u\u0308),(u)]", "");
            limpio = Normalizer.normalize(limpio, Normalizer.Form.NFC);
        }
        return limpio;
    }

    public static boolean esPalindromo(String cadena) {
        String resultado = "";
        System.out.println("real: "+ cadena+ " invertido: "+resultado);
        StringBuilder stringBuilder = new StringBuilder(cadena);
        resultado = stringBuilder.reverse().toString();
        System.out.println("real: "+ cadena+ " invertido: "+resultado);
        if (resultado==cadena)return true;
    return false;
    }
}
