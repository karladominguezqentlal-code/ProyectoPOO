package zoologico;

import java.util.ArrayList;
import java.util.Map;

/**
 * CLASE PRINCIPAL: aquí arranca el programa (método main).
 * Demuestra herencia, polimorfismo, encapsulamiento, tipos primitivos vs objetos
 * y el uso de las colecciones.
 */
public class Main {

    public static void main(String[] args) {

        // ==================================================================
        // 1) HERENCIA
        //    Creamos objetos de las clases hijas y usamos métodos/atributos
        //    que NO están escritos en ellas, sino que los heredaron de Animal.
        // ==================================================================
        System.out.println("========== 1) HERENCIA ==========");

        Perro perro = new Perro("Firulais", "P-001", 3, 25.5, "Pastor Alemán");
        Gato gato = new Gato("Michi", "G-002", 2, 4.2, true);
        Ave ave = new Ave("Paco", "A-003", 1, 0.4, 0.6);

        // comer() está definido en Animal, pero Perro, Gato y Ave pueden usarlo: lo heredaron.
        perro.comer("croquetas");
        gato.comer("atún");
        ave.comer("semillas");

        // "nombre" es un atributo PUBLIC heredado de Animal.
        System.out.println("Nombre heredado del perro: " + perro.nombre);

        // getEdad_primitiva() es un getter heredado de Animal.
        System.out.println("Edad del gato (getter heredado): " + gato.getEdad_primitiva());

        // instanceof comprueba la relación "es un": un Perro ES UN Animal.
        System.out.println("¿perro es un Animal? " + (perro instanceof Animal));

        // Además, cada hija tiene métodos propios que el padre NO tiene.
        perro.aprenderTruco("sentarse");
        perro.aprenderTruco("dar la pata");
        System.out.println("Raza (atributo propio de Perro): " + perro.getRaza());
        System.out.println("Trucos de " + perro.nombre + ": " + perro.getTrucos());

        // ==================================================================
        // 2) POLIMORFISMO
        //    Variables declaradas con el tipo del PADRE (Animal),
        //    pero creadas con el constructor de las HIJAS.
        //    Java decide en tiempo de ejecución qué versión de hacerSonido() usar.
        // ==================================================================
        System.out.println("\n========== 2) POLIMORFISMO ==========");

        Animal animal1 = new Perro("Rocky", "P-010", 5, 30.0, "Labrador");
        Animal animal2 = new Gato("Luna", "G-011", 4, 3.8, false);
        Animal animal3 = new Ave("Kiwi", "A-012", 2, 0.3, 0.5);
        Animal animal4 = new Animal("Genérico", "Desconocida", "X-000", 1, 1.0); // objeto del padre

        // Guardamos todos en un ArrayList de tipo Animal.
        ArrayList<Animal> animales = new ArrayList<>();
        animales.add(animal1);
        animales.add(animal2);
        animales.add(animal3);
        animales.add(animal4);
        // También agregamos los objetos de la sección de herencia
        animales.add(perro);
        animales.add(gato);
        animales.add(ave);

        // Ciclo FOR que ejecuta el mismo método en TODOS los objetos.
        // Aunque todos se ven como "Animal", cada uno responde con SU propia versión.
        for (int i = 0; i < animales.size(); i++) {
            Animal a = animales.get(i);
            System.out.println((i + 1) + ". " + a.hacerSonido());
        }

        // Casting: para usar un método exclusivo de la hija desde una variable Animal,
        // hay que convertirla (después de verificar con instanceof).
        if (animal1 instanceof Perro) {
            Perro p = (Perro) animal1;   // downcasting
            p.aprenderTruco("rodar");
            System.out.println("Después del casting, " + p.nombre + " aprendió: " + p.getTrucos());
        }

        // ==================================================================
        // 3) ENCAPSULAMIENTO
        // ==================================================================
        System.out.println("\n========== 3) ENCAPSULAMIENTO ==========");

        // public -> acceso directo permitido
        perro.nombre = "Firulais Jr.";
        System.out.println("Atributo public modificado directo: " + perro.nombre);

        // private -> NO se puede: perro.codigoIdentificacion = "x"; (error de compilación)
        // Hay que usar getter y setter:
        System.out.println("Código (private, vía getter): " + perro.getCodigoIdentificacion());
        perro.setCodigoIdentificacion("P-999");
        System.out.println("Código después del setter: " + perro.getCodigoIdentificacion());

        // El setter VALIDA los datos y protege al objeto de valores incorrectos:
        perro.setCodigoIdentificacion("");   // rechazado
        perro.setEdad(-5);                   // rechazado
        perro.setPeso(0);                    // rechazado
        perro.setEdad(4);                    // aceptado
        System.out.println("Edad final: " + perro.getEdad_primitiva());

        // protected -> accesible aquí porque Main está en el MISMO paquete (zoologico).
        // Fuera del paquete solo las clases hijas podrían usarlo.
        System.out.println("Atributo protected 'especie': " + perro.especie);

        // ==================================================================
        // 4) TIPOS PRIMITIVOS vs NO PRIMITIVOS (WRAPPERS)
        // ==================================================================
        System.out.println("\n========== 4) PRIMITIVOS vs OBJETOS ==========");

        // Variables locales intercaladas (8 tipos distintos)
        int edad_primitiva = 20;               Integer edad_objeto = 20;
        double precio_primitivo = 99.99;       Double precio_objeto = 99.99;
        float temperatura_primitiva = 36.5f;   Float temperatura_objeto = 36.5f;
        boolean activo_primitivo = true;       Boolean activo_objeto = true;
        char inicial_primitiva = 'T';          Character inicial_objeto = 'T';
        long poblacion_primitiva = 8000000000L; Long poblacion_objeto = 8000000000L;
        short anio_primitivo = 2026;           Short anio_objeto = 2026;
        byte nivel_primitivo = 10;             Byte nivel_objeto = 10;

        System.out.println("int/Integer        : " + edad_primitiva + " / " + edad_objeto);
        System.out.println("double/Double      : " + precio_primitivo + " / " + precio_objeto);
        System.out.println("float/Float        : " + temperatura_primitiva + " / " + temperatura_objeto);
        System.out.println("boolean/Boolean    : " + activo_primitivo + " / " + activo_objeto);
        System.out.println("char/Character     : " + inicial_primitiva + " / " + inicial_objeto);
        System.out.println("long/Long          : " + poblacion_primitiva + " / " + poblacion_objeto);
        System.out.println("short/Short        : " + anio_primitivo + " / " + anio_objeto);
        System.out.println("byte/Byte          : " + nivel_primitivo + " / " + nivel_objeto);

        // Diferencias prácticas:
        // a) Los wrappers pueden ser null; los primitivos no.
        Integer sinValor = null;   // válido
        // int sinValorPrim = null; // ERROR de compilación
        System.out.println("Un Integer puede ser null: " + sinValor);

        // b) Los wrappers tienen métodos útiles.
        System.out.println("Character.isLetter('T'): " + Character.isLetter(inicial_objeto));
        System.out.println("Integer.toBinaryString(20): " + Integer.toBinaryString(edad_objeto));
        System.out.println("Double.compare(precio, 100): " + Double.compare(precio_objeto, 100.0));

        // c) Las colecciones SOLO aceptan objetos: ArrayList<int> no existe, se usa ArrayList<Integer>.

        // Pares primitivo/objeto guardados como atributos dentro del objeto
        System.out.println("\nAtributos primitivo/objeto dentro de " + gato.nombre + ":");
        gato.mostrarTiposDeDatos();

        // ==================================================================
        // 5) COLECCIONES: ArrayList, LinkedList, HashSet, HashMap
        // ==================================================================
        System.out.println("\n========== 5) COLECCIONES ==========");

        // ArrayList (heredado de Animal): alimentos
        perro.comer("hueso");
        System.out.println("ArrayList alimentos de " + perro.nombre + ": " + perro.getAlimentos());

        // LinkedList (heredada): historial veterinario
        perro.registrarVisita("Revisión general");
        perro.registrarVisita("Limpieza dental");
        perro.getHistorialVeterinario().addFirst("Primera consulta"); // método propio de LinkedList
        System.out.println("LinkedList historial: " + perro.getHistorialVeterinario());
        System.out.println("  Primera visita: " + perro.getHistorialVeterinario().getFirst());
        System.out.println("  Última visita : " + perro.getHistorialVeterinario().getLast());

        // HashSet (heredado): vacunas sin repetir
        gato.vacunar("Rabia");
        gato.vacunar("Triple felina");
        gato.vacunar("Rabia"); // repetida -> el HashSet la ignora
        System.out.println("HashSet vacunas de " + gato.nombre + ": " + gato.getVacunas());

        // HashMap (heredado): juguetes -> cantidad
        perro.agregarJuguete("Pelota", 2);
        perro.agregarJuguete("Hueso de goma", 1);
        perro.agregarJuguete("Pelota", 1); // suma a la existente
        System.out.println("HashMap juguetes de " + perro.nombre + ":");
        for (Map.Entry<String, Integer> entrada : perro.getJuguetes().entrySet()) {
            System.out.println("  " + entrada.getKey() + " -> " + entrada.getValue());
        }

        // Colecciones propias de las hijas
        gato.agregarLugarFavorito("Sofá");
        gato.agregarLugarFavorito("Ventana");
        gato.agregarLugarFavorito("Sofá"); // repetido, no se agrega
        System.out.println("HashSet lugares favoritos del gato: " + gato.getLugaresFavoritos());

        ave.volarA("Árbol");
        ave.volarA("Techo");
        ave.volarA("Jaula");
        System.out.println("LinkedList ruta de vuelo del ave: " + ave.getRutaDeVuelo());

        ave.decirPalabra("Hola");
        ave.decirPalabra("Hola");
        ave.decirPalabra("Paco");
        System.out.println("HashMap palabras del ave: " + ave.getPalabrasAprendidas());

        // ==================================================================
        // Resumen final usando toString() sobrescrito
        // ==================================================================
        System.out.println("\n========== RESUMEN ==========");
        for (Animal a : animales) {   // for-each: recorre la lista sin índices
            System.out.println("- " + a);
        }
    }
}
