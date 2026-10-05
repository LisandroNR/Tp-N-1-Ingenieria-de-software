package ChainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Container
 * Extiende de Component y representa un contenedor compuesto por una colección de hijos (children).
 */
public abstract class Container extends Component {
    protected List<Component> children = new ArrayList<>();

    public void add(Component child) {
        children.add(child);
        // Opcionalmente se le puede asignar este contenedor como padre al hijo
        child.setContainer(this);
    }
}
