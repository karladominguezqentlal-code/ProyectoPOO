// Paquete al que pertenecen todas las clases del proyecto.
// Los atributos "protected" son visibles para las clases de este mismo paquete y para las clases hijas.
package zoologico;

// Importamos las colecciones que vamos a usar (ArrayList, LinkedList, HashSet, HashMap)
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * CLASE PADRE (superclase).
 * Define lo que TODOS los animales tienen en común. Las clases hijas (Perro, Gato, Ave)
 * heredan estos atributos y métodos con la palabra "extends".
 *
 * Aquí se demuestra:
 *  - ENCAPSULAMIENTO: atributos public, protected y private + getters y setters.
 *  - Variables PRIMITIVAS vs NO PRIMITIVAS (clases envolventes / wrappers), intercaladas.
 *  - Colecciones: ArrayList, LinkedList, HashSet y HashMap.
 *  - Un método (hacerSonido) que las hijas van a SOBRESCRIBIR (polimorfismo).
 */
public class Animal {

    // =====================================================================
    // 1) ATRIBUTOS CON DISTINTOS MODIFICADORES DE ACCESO (ENCAPSULAMIENTO)
    // =====================================================================

    // PUBLIC: cualquier clase puede leerlo y modificarlo directamente (animal.nombre = "x").
    public String nombre;

    // PROTECTED: solo lo ven esta clase, las clases hijas y las clases del mismo paquete.
    protected String especie;

    // PRIVATE: solo esta clase puede tocarlo. Para acceder desde fuera se usan getters/setters.
    private String codigoIdentificacion;

    // =====================================================================
    // 2) VARIABLES PRIMITIVAS Y NO PRIMITIVAS INTERCALADAS
    //    Primitivo  -> guarda el valor directamente, NO puede ser null, no tiene métodos.
    //    Wrapper    -> es un OBJETO que envuelve al valor, SÍ puede ser null y tiene métodos
    //                  (por ejemplo Integer.toString(), Double.compare(), etc.).
    //    Son "la misma variable" en dos versiones, una justo después de la otra.
    // =====================================================================

    // --- Tipo 1: int / Integer (números enteros de 32 bits) ---
    private int edad_primitiva;          // primitivo
    private Integer edad_objeto;         // objeto (wrapper)

    // --- Tipo 2: double / Double (decimales de doble precisión) ---
    private double peso_primitivo;       // primitivo
    private Double peso_objeto;          // objeto (wrapper)

    // --- Tipo 3: float / Float (decimales de precisión simple, llevan "f" al final) ---
    protected float altura_primitiva;    // primitivo
    protected Float altura_objeto;       // objeto (wrapper)

    // --- Tipo 4: boolean / Boolean (verdadero o falso) ---
    protected boolean vacunado_primitivo; // primitivo
    protected Boolean vacunado_objeto;    // objeto (wrapper)

    // --- Tipo 5: char / Character (un solo carácter, va entre comillas simples) ---
    protected char sexo_primitivo;       // primitivo  ('M' o 'H')
    protected Character sexo_objeto;     // objeto (wrapper)

    // --- Tipo 6: long / Long (enteros muy grandes de 64 bits, llevan "L" al final) ---
    protected long numeroRegistro_primitivo; // primitivo
    protected Long numeroRegistro_objeto;    // objeto (wrapper)

    // --- Tipo 7: short / Short (enteros pequeños de 16 bits: -32,768 a 32,767) ---
    protected short numeroJaula_primitivo;   // primitivo
    protected Short numeroJaula_objeto;      // objeto (wrapper)

    // --- Tipo 8: byte / Byte (enteros muy pequeños de 8 bits: -128 a 127) ---
    protected byte nivelEnergia_primitivo;   // primitivo
    protected Byte nivelEnergia_objeto;      // objeto (wrapper)

    // =====================================================================
    // 3) COLECCIONES (todas son tipos NO primitivos)
    // =====================================================================

    // ArrayList: lista ordenada, permite duplicados, acceso rápido por índice.
    protected ArrayList<String> alimentos = new ArrayList<>();

    // LinkedList: lista doblemente enlazada; rápida para agregar/quitar al inicio o al final.
    // La usamos como historial de visitas al veterinario.
    protected LinkedList<String> historialVeterinario = new LinkedList<>();

    // HashSet: conjunto SIN duplicados y SIN orden garantizado.
    // Si agregas la misma vacuna dos veces, solo se guarda una vez.
    protected HashSet<String> vacunas = new HashSet<>();

    // HashMap: pares clave -> valor. Aquí: nombre del juguete -> cantidad.
    protected HashMap<String, Integer> juguetes = new HashMap<>();

    // =====================================================================
    // 4) CONSTRUCTOR
    //    Se ejecuta al hacer "new". Inicializa los atributos del objeto.
    // =====================================================================
    public Animal(String nombre, String especie, String codigoIdentificacion, int edad, double peso) {
        this.nombre = nombre;                              // "this" se refiere al objeto actual
        this.especie = especie;
        this.codigoIdentificacion = codigoIdentificacion;

        // Asignamos el mismo valor al primitivo y al wrapper.
        this.edad_primitiva = edad;
        this.edad_objeto = edad;           // AUTOBOXING: Java convierte int -> Integer automáticamente

        this.peso_primitivo = peso;
        this.peso_objeto = peso;           // AUTOBOXING: double -> Double

        // Valores por defecto para el resto de pares primitivo/objeto
        this.altura_primitiva = 0.5f;
        this.altura_objeto = 0.5f;

        this.vacunado_primitivo = false;
        this.vacunado_objeto = Boolean.FALSE;

        this.sexo_primitivo = 'M';
        this.sexo_objeto = 'M';

        this.numeroRegistro_primitivo = 1000000000L;
        this.numeroRegistro_objeto = 1000000000L;

        this.numeroJaula_primitivo = 1;
        this.numeroJaula_objeto = 1;

        this.nivelEnergia_primitivo = 100;
        this.nivelEnergia_objeto = 100;
    }

    // =====================================================================
    // 5) MÉTODO QUE SERÁ SOBRESCRITO (POLIMORFISMO)
    //    La clase padre da una versión genérica; cada hija la "reinterpreta"
    //    con @Override para dar su propio comportamiento.
    // =====================================================================
    public String hacerSonido() {
        return "El animal hace un sonido genérico.";
    }

    // Otro método común que las hijas HEREDAN tal cual (no lo sobrescriben).
    public void comer(String alimento) {
        alimentos.add(alimento); // agrega el alimento al ArrayList
        System.out.println(nombre + " está comiendo " + alimento + ".");
    }

    // Registra una visita al veterinario usando métodos propios de LinkedList.
    public void registrarVisita(String visita) {
        historialVeterinario.addLast(visita); // agrega al final de la lista enlazada
    }

    // Agrega una vacuna al HashSet; si ya existe, add() devuelve false y no la duplica.
    public void vacunar(String vacuna) {
        boolean esNueva = vacunas.add(vacuna);
        this.vacunado_primitivo = true;
        this.vacunado_objeto = Boolean.TRUE;
        if (!esNueva) {
            System.out.println("  (La vacuna " + vacuna + " ya estaba registrada, el HashSet no la duplica)");
        }
    }

    // Agrega juguetes al HashMap: si la clave ya existe, suma la cantidad.
    public void agregarJuguete(String juguete, int cantidad) {
        juguetes.put(juguete, juguetes.getOrDefault(juguete, 0) + cantidad);
    }

    // =====================================================================
    // 6) GETTERS Y SETTERS (ENCAPSULAMIENTO)
    //    Permiten leer/modificar atributos privados de forma controlada.
    //    Los setters pueden VALIDAR datos antes de asignarlos.
    // =====================================================================

    // Getter del atributo privado codigoIdentificacion
    public String getCodigoIdentificacion() {
        return codigoIdentificacion;
    }

    // Setter con validación: no permite códigos vacíos
    public void setCodigoIdentificacion(String codigoIdentificacion) {
        if (codigoIdentificacion == null || codigoIdentificacion.isEmpty()) {
            System.out.println("Error: el código no puede estar vacío.");
            return; // sale del método sin modificar el valor
        }
        this.codigoIdentificacion = codigoIdentificacion;
    }

    // Getter de edad (versión primitiva)
    public int getEdad_primitiva() {
        return edad_primitiva;
    }

    // Getter de edad (versión objeto)
    public Integer getEdad_objeto() {
        return edad_objeto;
    }

    // Setter de edad con validación: actualiza ambas versiones
    public void setEdad(int edad) {
        if (edad < 0) {
            System.out.println("Error: la edad no puede ser negativa.");
            return;
        }
        this.edad_primitiva = edad;
        this.edad_objeto = edad; // autoboxing
    }

    // Getter de peso (versión primitiva)
    public double getPeso_primitivo() {
        return peso_primitivo;
    }

    // Getter de peso (versión objeto)
    public Double getPeso_objeto() {
        return peso_objeto;
    }

    // Setter de peso con validación
    public void setPeso(double peso) {
        if (peso <= 0) {
            System.out.println("Error: el peso debe ser mayor a 0.");
            return;
        }
        this.peso_primitivo = peso;
        this.peso_objeto = peso;
    }

    // Getters de las colecciones
    public ArrayList<String> getAlimentos() { return alimentos; }
    public LinkedList<String> getHistorialVeterinario() { return historialVeterinario; }
    public HashSet<String> getVacunas() { return vacunas; }
    public HashMap<String, Integer> getJuguetes() { return juguetes; }

    // =====================================================================
    // 7) MÉTODO PARA MOSTRAR LOS PARES PRIMITIVO / OBJETO
    // =====================================================================
    public void mostrarTiposDeDatos() {
        System.out.println("  int       edad_primitiva           = " + edad_primitiva);
        System.out.println("  Integer   edad_objeto              = " + edad_objeto);
        System.out.println("  double    peso_primitivo           = " + peso_primitivo);
        System.out.println("  Double    peso_objeto              = " + peso_objeto);
        System.out.println("  float     altura_primitiva         = " + altura_primitiva);
        System.out.println("  Float     altura_objeto            = " + altura_objeto);
        System.out.println("  boolean   vacunado_primitivo       = " + vacunado_primitivo);
        System.out.println("  Boolean   vacunado_objeto          = " + vacunado_objeto);
        System.out.println("  char      sexo_primitivo           = " + sexo_primitivo);
        System.out.println("  Character sexo_objeto              = " + sexo_objeto);
        System.out.println("  long      numeroRegistro_primitivo = " + numeroRegistro_primitivo);
        System.out.println("  Long      numeroRegistro_objeto    = " + numeroRegistro_objeto);
        System.out.println("  short     numeroJaula_primitivo    = " + numeroJaula_primitivo);
        System.out.println("  Short     numeroJaula_objeto       = " + numeroJaula_objeto);
        System.out.println("  byte      nivelEnergia_primitivo   = " + nivelEnergia_primitivo);
        System.out.println("  Byte      nivelEnergia_objeto      = " + nivelEnergia_objeto);

        // Ejemplo de algo que SOLO pueden hacer los wrappers: usar métodos y ser null.
        System.out.println("  -> edad_objeto.toString().length() = " + edad_objeto.toString().length()
                + " (un int primitivo no tiene métodos)");
    }

    // toString() también se hereda de Object y aquí lo sobrescribimos.
    @Override
    public String toString() {
        return especie + " llamado " + nombre + " (" + edad_primitiva + " años, " + peso_primitivo + " kg)";
    }
}
