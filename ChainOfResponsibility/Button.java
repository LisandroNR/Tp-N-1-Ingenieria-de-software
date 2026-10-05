package ChainOfResponsibility;

/**
 * Clase Button
 * Manejador concreto que hereda de Component para representar un botón en la interfaz.
 */
public class Button extends Component {

    public Button(String tooltipText) {
        this.tooltipText = tooltipText;
    }
}
