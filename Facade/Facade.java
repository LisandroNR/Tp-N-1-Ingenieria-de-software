package Facade;

/**
 * Clase Facade
 * Proporciona un acceso unificado al subsistema complejo y coordina las llamadas.
 */
public class Facade {
    // Atributos que representan los enlaces a los objetos del subsistema y la fachada adicional
    private SubsystemOne subsystemOne;
    private SubsystemTwo subsystemTwo;
    private SubsystemThree subsystemThree;
    private AdditionalFacade optionalAdditionalFacade;

    public Facade() {
        this.subsystemOne = new SubsystemOne();
        this.subsystemTwo = new SubsystemTwo();
        this.subsystemThree = new SubsystemThree();
        this.optionalAdditionalFacade = new AdditionalFacade();
    }

    /**
     * Método simplificado que agrupa y coordina tareas de múltiples clases del subsistema.
     */
    public void subsystemOperation() {
        System.out.println("--- Facade: Coordinando el subsistema complejo ---");
        subsystemOne.operationOne();
        subsystemTwo.operationTwo();
        subsystemThree.operationThree();
    }

    /**
     * Permite acceder a la fachada adicional si se requiere una operación complementaria.
     */
    public void delegateToAdditionalFacade() {
        optionalAdditionalFacade.anotherOperation();
    }
}
