package Facade;

/**
 * Clase AdditionalFacade
 * Evita contaminar la fachada principal con funciones no relacionadas, 
 * ofreciendo operaciones complementarias.
 */
public class AdditionalFacade {
    
    public void anotherOperation() {
        System.out.println("[AdditionalFacade] Ejecutando operación adicional o complementaria.");
    }
}
