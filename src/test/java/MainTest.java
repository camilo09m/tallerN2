import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void leerArchivo() {
        String ruta = " ";
        ArrayList esperado =null;
        ArrayList real = Main.leerArchivo(ruta);
        assertEquals(esperado,real);
    }

    @Test
    void limpiarpalabra() {
        String cadena = "AEFAWFAF AFAEW";
        String esperado = "aefawfafafaew";
        String real = Main.limpiarpalabra(cadena);
        assertEquals(esperado,real);
    }

    @Test
    void esPalindromo() {
    }
}