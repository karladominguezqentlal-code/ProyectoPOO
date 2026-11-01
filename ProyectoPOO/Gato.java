package zoologico;

import java.util.HashSet;

/**
 * CLASE HIJA #2.
 * Hereda de Animal y sobrescribe hacerSonido().
 */
public class Gato extends Animal {

    // Par primitivo / objeto propio del gato
    private boolean esDeInterior_primitivo;   // primitivo
    private Boolean esDeInterior_objeto;      // objeto (wrapper)

    // HashSet propio: lugares favoritos de la casa (sin repetidos)
    private HashSet<String> lugaresFavoritos = new HashSet<>();

    public Gato(String nombre, String codigo, int edad, double peso, boolean esDeInterior) {
        super(nombre, "Gato", codigo, edad, peso); // llamada al constructor del padre
        this.esDeInterior_primitivo = esDeInterior;
        this.esDeInterior_objeto = esDeInterior;  // autoboxing boolean -> Boolean
        this.sexo_primitivo = 'H';                // accedemos a un atributo PROTECTED heredado
        this.sexo_objeto = 'H';
    }

    // POLIMORFISMO: versión del gato del método del padre
    @Override
    public String hacerSonido() {
        return nombre + " (Gato) dice: ¡Miau!";
    }

    // Método exclusivo de Gato
    public void agregarLugarFavorito(String lugar) {
        lugaresFavoritos.add(lugar);
    }

    public HashSet<String> getLugaresFavoritos() { return lugaresFavoritos; }
    public boolean isEsDeInterior_primitivo() { return esDeInterior_primitivo; }
    public Boolean getEsDeInterior_objeto() { return esDeInterior_objeto; }
}
