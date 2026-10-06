package ChainOfResponsibility;

/**
 * Clase Component
 * Implementa la interfaz y mantiene una referencia al siguiente eslabón de la cadena (container).
 * Define el comportamiento por defecto de redirección.
 */
public abstract class Component implements ComponentWithContextualHelp {
    protected Container container; // Referencia al siguiente manejador (contenedor superior)
    protected String tooltipText;  // Recurso de ayuda propio del componente

    public void setContainer(Container container) {
        this.container = container;
    }

    @Override
    public void showHelp() {
        // Si el objeto actual tiene la capacidad de manejar la solicitud, lo hace
        if (tooltipText != null) {
            System.out.println("[Component] Mostrando descripción (Tooltip): " + tooltipText);
        } 
        // De lo contrario, delega la petición al siguiente eslabón de la cadena
        else if (container != null) {
            System.out.println("[Component] Sin tooltip propio, delegando al contenedor...");
            container.showHelp();
        } else {
            System.out.println("[Component] Fin de la cadena: no hay ayuda disponible.");
        }
    }
}