package Adapter;

// 1. Client Interface: Define la interfaz que el código cliente espera utilizar
interface ClientInterface {
    void method(String data);
}

// 2. Service: La clase existente útil, pero con una interfaz incompatible
class Service {
    // Este método espera un número entero (specialData), no un String
    public void serviceMethod(int specialData) {
        System.out.println("Servicio ejecutado correctamente con el dato numérico: " + specialData);
    }
}

// 3. Adapter: Implementa la interfaz del cliente y envuelve al servicio
class Adapter implements ClientInterface {
    private Service adaptee; // Composición: referencia al objeto del servicio

    public Adapter(Service adaptee) {
        this.adaptee = adaptee;
    }

    // Traduce las llamadas del cliente al formato que el servicio entiende
    @Override
    public void method(String data) {
        System.out.println("Adaptador recibe dato del cliente en formato String: '" + data + "'");
        
        try {
            // Lógica de traducción: convierte el String a int (specialData)
            int specialData = Integer.parseInt(data);
            System.out.println("Adaptador tradujo el dato a int exitosamente.");
            
            // Llama al método del servicio envuelto
            adaptee.serviceMethod(specialData);
        } catch (NumberFormatException e) {
            System.out.println("Error: El adaptador no pudo traducir el formato de los datos.");
        }
    }
}

// 4. Client (Main): Lógica de negocio que utiliza la funcionalidad del servicio
public class MainAdapter {
    public static void main(String[] args) {
        System.out.println("--- Inicio del Cliente ---");
        String datosDelCliente = "2026"; // Dato en formato texto (incompatible)

        // 1. Instanciamos el servicio original
        Service servicioIncompatible = new Service();

        // 2. Instanciamos el adaptador y le pasamos el servicio por constructor
        ClientInterface adaptador = new Adapter(servicioIncompatible);

        // 3. El cliente trabaja con el adaptador usando el método que conoce
        adaptador.method(datosDelCliente);
    }
}