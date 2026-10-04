package Prototype;

import java.util.HashMap;
import java.util.Map;

// 1. Interfaz Prototype: Define el contrato estándar para ser clonable
interface Prototype {
    Prototype clone();
}

// 2. ConcretePrototype1: Implementación específica de la interfaz
class ConcretePrototype1 implements Prototype {
    private String attribute; // Estado interno del objeto

    public ConcretePrototype1(String attribute) {
        this.attribute = attribute;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    // La clase se clona a sí misma retornando una nueva instancia con sus mismos datos
    @Override
    public Prototype clone() {
        return new ConcretePrototype1(this.attribute);
    }
}

// 3. PrototypeRegistry: Catálogo centralizado donde se guardan las instancias
class PrototypeRegistry {
    // Usamos un Map en lugar de un array simple para poder buscar por el ID (string)
    private Map<String, Prototype> items = new HashMap<>();

    public void addItem(String id, Prototype p) {
        items.put(id, p);
    }

    // El cliente busca por ID y el registro retorna un CLON, no el objeto original
    public Prototype getById(String id) {
        Prototype p = items.get(id);
        if (p != null) {
            return p.clone(); 
        }
        return null;
    }
}

// 4. Client: Clase que interactúa con el registro para solicitar copias
public class MainPrototype {
    public static void main(String[] args) {
        PrototypeRegistry registry = new PrototypeRegistry();

        // Se crea un prototipo inicial (modelo a copiar) y se guarda en el registro
        ConcretePrototype1 prototipoOriginal = new ConcretePrototype1("Configuración Base");
        registry.addItem("boton-rojo", prototipoOriginal);

        System.out.println("--- Solicitando clon desde el registro ---");
        // El cliente pide una copia sin usar la palabra 'new' ni saber cómo se construye
        ConcretePrototype1 clon = (ConcretePrototype1) registry.getById("boton-rojo");

        System.out.println("Atributo del original: " + prototipoOriginal.getAttribute());
        System.out.println("Atributo del clon: " + clon.getAttribute());

        System.out.println("\n--- Modificando el clon ---");
        clon.setAttribute("Configuración Modificada");

        // Verificamos que modificar el clon no afecta al objeto original guardado
        System.out.println("Atributo del original: " + prototipoOriginal.getAttribute());
        System.out.println("Atributo del clon: " + clon.getAttribute());
    }
}