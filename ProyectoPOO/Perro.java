package zoologico;

import java.util.ArrayList;

/**
 * CLASE HIJA #1.
 * "extends Animal" significa que Perro HEREDA todos los atributos y métodos
 * public y protected de Animal (nombre, especie, comer(), vacunar(), etc.).
 * Además agrega sus propios atributos y SOBRESCRIBE hacerSonido().
 */
public class Perro extends Animal {

    // Atributo PRIVADO propio de Perro (no existe en Animal)
    private String raza;

    // Par primitivo / objeto propio del perro
    private int trucosAprendidos_primitivo;   // primitivo
    private Integer trucosAprendidos_objeto;  // objeto (wrapper)

    // ArrayList propio: lista de trucos que sabe hacer
    private ArrayList<String> trucos = new ArrayList<>();

    // Constructor de la hija
    public Perro(String nombre, String codigo, int edad, double peso, String raza) {
        // super(...) llama al constructor de la clase PADRE. Debe ser la primera línea.
        // Así reutilizamos la inicialización que ya hace Animal (HERENCIA).
        super(nombre, "Perro", codigo, edad, peso);
        this.raza = raza;
        this.trucosAprendidos_primitivo = 0;
        this.trucosAprendidos_objeto = 0;
    }

    // POLIMORFISMO: reinterpretamos el método del padre.
    // @Override le indica al compilador que estamos sobrescribiendo un método heredado.
    @Override
    public String hacerSonido() {
        return nombre + " (Perro) dice: ¡Guau guau!";
    }

    // Método EXCLUSIVO de Perro (Animal no lo tiene)
    public void aprenderTruco(String truco) {
        trucos.add(truco);
        trucosAprendidos_primitivo++;                 // incremento normal de un primitivo
        trucosAprendidos_objeto = trucosAprendidos_objeto + 1; // unboxing, suma y autoboxing
    }

    // Getters y setters del atributo privado raza
    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }

    public ArrayList<String> getTrucos() { return trucos; }
    public int getTrucosAprendidos_primitivo() { return trucosAprendidos_primitivo; }
    public Integer getTrucosAprendidos_objeto() { return trucosAprendidos_objeto; }
}
