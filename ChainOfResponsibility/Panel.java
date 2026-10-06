package ChainOfResponsibility;

/**
 * Clase Panel
 * Extiende de Container y verifica si posee recursos de ayuda modal propios.
 */
public class Panel extends Container {
    private String modalHelpText; // Recurso de ayuda específico del panel

    public Panel(String modalHelpText) {
        this.modalHelpText = modalHelpText;
    }

    @Override
    public void showHelp() {
        if (modalHelpText != null) {
            System.out.println("[Panel] Mostrando ventana modal con texto de ayuda: " + modalHelpText);
        } else {
            // Si carece de recursos, invoca el comportamiento de la clase padre (super/parent)
            super.showHelp();
        }
    }
}
