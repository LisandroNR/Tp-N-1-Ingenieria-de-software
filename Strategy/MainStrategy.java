// 1. Interfaz Strategy: Declara el metodo comun para todos los algoritmos
interface EstrategiaRuta {
    void calcularRuta(String puntoA, String puntoB);
}

// 2. Estrategias Concretas: Implementan variantes del algoritmo
class RutaAuto implements EstrategiaRuta {
    @Override
    public void calcularRuta(String puntoA, String puntoB) {
        System.out.println("Calculando ruta en AUTO de " + puntoA + " a " + puntoB + ".");
        System.out.println("-> Evitando peajes. Tiempo estimado: 15 min.\n");
    }
}

class RutaCaminando implements EstrategiaRuta {
    @Override
    public void calcularRuta(String puntoA, String puntoB) {
        System.out.println("Calculando ruta CAMINANDO de " + puntoA + " a " + puntoB + ".");
        System.out.println("-> Priorizando calles peatonales. Tiempo estimado: 45 min.\n");
    }
}

// 3. Contexto: Mantiene una referencia a la estrategia y delega la ejecucion
class NavegadorGPS {
    private EstrategiaRuta estrategia;

    // Metodo setter para inyectar o cambiar la estrategia dinamicamente
    public void setEstrategia(EstrategiaRuta estrategia) {
        this.estrategia = estrategia;
    }

    public void ejecutarCalculo(String puntoA, String puntoB) {
        if (estrategia == null) {
            System.out.println("Por favor, selecciona un medio de transporte primero.");
            return;
        }
        // El contexto no sabe COMO se calcula, solo ejecuta el metodo de la interfaz
        estrategia.calcularRuta(puntoA, puntoB);
    }
}

// 4. Clase cliente para probar el patron
public class MainStrategy {
    public static void main(String[] args) {
        NavegadorGPS gps = new NavegadorGPS();

        // El cliente decide usar la estrategia de Auto
        gps.setEstrategia(new RutaAuto());
        gps.ejecutarCalculo("Casa", "Universidad");

        // El cliente cambia la estrategia a Caminando en tiempo de ejecucion
        gps.setEstrategia(new RutaCaminando());
        gps.ejecutarCalculo("Casa", "Universidad");
    }
}