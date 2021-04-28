import java.io.File;
import java.text.Normalizer;

public class Main {
    public static void main(String[] args) {

    }
    public static void leerPalindromo(){

        String palabraLimpia = limpiarpalabra();
    }
    public static String leerArchivo(){
        File f = new File("/home/UFRO/5semestre/PROGRAMACIONII/")
    }
    public static String limpiarpalabra(String cadena) {
        String limpio =null;
        if (cadena !=null) {
            String valor = cadena;
            valor = valor.toLowerCase();
            limpio = Normalizer.normalize(valor, Normalizer.Form.NFD);
            limpio = limpio.replaceAll("[^\\p{ASCII}(N\u0303)(n\u0303)(\u00A1)(\u00BF)(\u00B0)(U\u0308)(u\u0308)]", "");
            limpio = Normalizer.normalize(limpio, Normalizer.Form.NFC);
        }
        return limpio;
    }
    public static boolean esPalindromo(String cadena){
        String resultado = "";
        StringBuilder stringBuilder = new StringBuilder(cadena);
        resultado = stringBuilder.reverse().toString();
        if(cadena.equals(resultado)) return true;
        return false;
    }
    public static void mostrarResultado(String palindromo){
        if (esPalindromo(palindromo)){
            System.out.println("Es palíndromo");
        }
        else {
            System.out.println("No es palíndromo");
        }}
}
