package zoologico;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * CLASE HIJA #3.
 * Hereda de Animal y sobrescribe hacerSonido().
 */
public class Ave extends Animal {

    // Par primitivo / objeto propio del ave
    private double envergaduraAlas_primitiva;   // primitivo
    private Double envergaduraAlas_objeto;      // objeto (wrapper)

    // LinkedList propia: ruta de vuelo (orden en que visita lugares)
    private LinkedList<String> rutaDeVuelo = new LinkedList<>();

    // HashMap propio: palabra aprendida -> veces que la ha repetido
    private HashMap<String, Integer> palabrasAprendidas = new HashMap<>();

    public Ave(String nombre, String codigo, int edad, double peso, double envergadura) {
        super(nombre, "Ave", codigo, edad, peso);
        this.envergaduraAlas_primitiva = envergadura;
        this.envergaduraAlas_objeto = envergadura;
        this.altura_primitiva = 0.3f;   // modificamos atributos PROTECTED heredados
        this.altura_objeto = 0.3f;
    }

    // POLIMORFISMO: versión del ave del método del padre
    @Override
    public String hacerSonido() {
        // super.hacerSonido() permite usar también la versión del padre si se desea
        return nombre + " (Ave) dice: ¡Pío pío! [versión del padre: " + super.hacerSonido() + "]";
    }

    // Métodos exclusivos del ave
    public void volarA(String lugar) {
        rutaDeVuelo.add(lugar);
    }

    public void decirPalabra(String palabra) {
        palabrasAprendidas.put(palabra, palabrasAprendidas.getOrDefault(palabra, 0) + 1);
    }

    public LinkedList<String> getRutaDeVuelo() { return rutaDeVuelo; }
    public HashMap<String, Integer> getPalabrasAprendidas() { return palabrasAprendidas; }
    public double getEnvergaduraAlas_primitiva() { return envergaduraAlas_primitiva; }
    public Double getEnvergaduraAlas_objeto() { return envergaduraAlas_objeto; }
}
