package Facade;

/**
 * Clase Client (Main)
 * Interactúa únicamente con la fachada, desconociendo la complejidad interna del subsistema.
 */
public class MainFacade {
    public static void main(String[] args) {
        // El cliente instancia la fachada principal
        Facade fachada = new Facade();

        // El cliente hace una sola llamada simple y la fachada se encarga del resto
        fachada.subsystemOperation();

        System.out.println("\n--- Usando la fachada adicional ---");
        fachada.delegateToAdditionalFacade();
    }
}
