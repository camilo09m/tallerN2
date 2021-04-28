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
        leerArchivo();
    }
    public static ArrayList leerArchivo() {
        List<String> lista = new ArrayList<>();
        try (FileReader fr = new FileReader("cadenas.txt");
             BufferedReader br = new BufferedReader(fr)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(linea);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (ArrayList) lista;
    }
    public static void ordenarArray(){
        List<String> lista = new ArrayList<>();
        lista = leerArchivo();
        for (int i=0; i<lista.size();i++){
            String palabra = limpiarpalabra(lista.get(i));
            esPalindromo(palabra);
        }
    }
    public static String limpiarpalabra(String cadena) {
        String limpio = null;
        if (cadena != null) {
            String valor = cadena;
            valor = valor.toLowerCase();
            limpio = Normalizer.normalize(valor, Normalizer.Form.NFD);
            limpio = limpio.replaceAll("[^\\p{ASCII}(N\u0303)(n\u0303)(\u00A1)(\u00BF)(\u00B0)(U\u0308)(u\u0308)]", "");
            limpio = Normalizer.normalize(limpio, Normalizer.Form.NFC);
        }
        return limpio;
    }

    public static void esPalindromo(String cadena) {
        String resultado = "";
        StringBuilder stringBuilder = new StringBuilder(cadena);
        resultado = stringBuilder.reverse().toString();
    }
}
