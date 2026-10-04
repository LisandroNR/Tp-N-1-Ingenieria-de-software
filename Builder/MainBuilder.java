package Builder;

// 1. Clases Producto: Los objetos complejos resultantes
class Product1 {
    private String partes = "";
    public void agregarParte(String parte) {
        this.partes += parte + " ";
    }

    public void mostrar() {
        System.out.println("Producto 1 ensamblado con: " + partes);
    }
}

class Product2 {
    private String componentes = "";

    public void setFeature(String feature) {
        this.componentes += feature + " ";
    }

    public void mostrar() {
        System.out.println("Producto 2 fabricado con: " + componentes);
    }
}

// 2. Interfaz Builder: Define el contrato estándar para los pasos de construcción
interface Builder {
    void reset();
    void buildStepA();
    void buildStepB();
    void buildStepZ();
}

// 3. Constructores Concretos: Implementan la interfaz para fabricar su producto específico
class ConcreteBuilder1 implements Builder {
    private Product1 result;

    @Override
    public void reset() {
        this.result = new Product1(); // Reinicia el producto
    }

    @Override
    public void buildStepA() {
        result.agregarParte("[Paso A1]");
    }

    @Override
    public void buildStepB() {
        result.agregarParte("[Paso B1]");
    }

    @Override
    public void buildStepZ() {
        result.agregarParte("[Paso Z1]");
    }

    // Método exclusivo para retornar el producto final
    public Product1 getResult() {
        return this.result;
    }
}

class ConcreteBuilder2 implements Builder {
    private Product2 result;

    @Override
    public void reset() {
        this.result = new Product2(); 
    }

    @Override
    public void buildStepA() {
        result.setFeature("[Característica A2]");
    }

    @Override
    public void buildStepB() {
        result.setFeature("[Característica B2]");
    }

    @Override
    public void buildStepZ() {
        result.setFeature("[Característica Z2]");
    }

    public Product2 getResult() {
        return this.result;
    }
}

// 4. Director: Define el orden predeterminado en que se ejecutan los pasos
class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void changeBuilder(Builder builder) {
        this.builder = builder;
    }

    // Ejecuta pasos específicos según el tipo solicitado, tal como en el diagrama
    public void make(String type) {
        builder.reset();
        if (type.equals("simple")) {
            builder.buildStepA();
        } else {
            builder.buildStepB();
            builder.buildStepZ();
        }
    }
}

// 5. Cliente: Inicializa el proceso, elige el constructor y recupera el producto
public class MainBuilder {
    public static void main(String[] args) {
        // Inicializamos el constructor 1 y el director
        ConcreteBuilder1 b1 = new ConcreteBuilder1();
        Director director = new Director(b1);

        System.out.println("--- Fabricando Producto 1 (Simple) ---");
        director.make("simple");
        Product1 p1 = b1.getResult();
        p1.mostrar();

        System.out.println("\n--- Fabricando Producto 1 (Complejo) ---");
        director.make("complejo"); // Caerá en el bloque 'else' del director
        Product1 p1Complejo = b1.getResult();
        p1Complejo.mostrar();

        // Cambiamos al constructor 2 en tiempo de ejecución
        System.out.println("\n--- Cambiando al Constructor 2 para producto complejo ---");
        ConcreteBuilder2 b2 = new ConcreteBuilder2();
        director.changeBuilder(b2);
        
        director.make("complejo");
        Product2 p2 = b2.getResult();
        p2.mostrar();
    }
}