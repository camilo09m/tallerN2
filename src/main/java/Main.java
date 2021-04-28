import javax.swing.plaf.basic.BasicButtonUI;
import java.io.*;
import java.text.Normalizer;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
            System.out.println(leerArchivo());
    }
    public static ArrayList leerArchivo() {
        File f = new File("TallerN°2/cadenas.txt");
        BufferedReader entrada;
        ArrayList arrLinea = new ArrayList();
        try {
            entrada = new BufferedReader(new FileReader(f));
            String linea;
            while (entrada.ready()) {
                linea = entrada.readLine();
                String lineaLimpia = limpiarpalabra(linea);
                arrLinea.add(lineaLimpia);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrLinea;
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
