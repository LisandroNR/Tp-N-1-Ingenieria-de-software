/**
 * Clase Main
 * Clase de prueba o cliente que instancia el contexto y va alternando 
 * entre las distintas estrategias concretas (A, B y C) en tiempo de ejecución.
 */

public class MainStrategy {
    public static void main(String[] args) {

        // Se crea el objeto contexto

        Context contexto = new Context();

        // Se le asigna la estrategia A y se ejecuta

        System.out.println("--- Probando Strategy A ---");
        contexto.setStrategy(new ConcreteStrategyA());
        contexto.executeStrategy();

        // Se cambia dinámicamente a la estrategia B en tiempo de ejecución y se ejecuta

        System.out.println("\n--- Cambiando a Strategy B en tiempo de ejecución ---");
        contexto.setStrategy(new ConcreteStrategyB());
        contexto.executeStrategy();

        // Se cambia a la estrategia C y se ejecuta

        System.out.println("\n--- Cambiando a Strategy C ---");
        contexto.setStrategy(new ConcreteStrategyC());
        contexto.executeStrategy();
    }
}

