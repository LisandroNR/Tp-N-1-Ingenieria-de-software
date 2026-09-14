import java.util.ArrayList;
import java.util.List;

// 1. Interfaz Observer: Define como se actualizaran los dependientes
interface Observador {
    void actualizar(String mensaje);
}

// 2. Interfaz Subject (Sujeto): Define metodos para suscribir, desuscribir y notificar
interface Sujeto {
    void agregar(Observador o);
    void eliminar(Observador o);
    void notificar();
}

// 3. Clase Concreta Subject: El objeto que cambia de estado
class CanalDeNoticias implements Sujeto {
    private List<Observador> observadores = new ArrayList<>();
    private String ultimaNoticia;

    public void setNuevaNoticia(String noticia) {
        this.ultimaNoticia = noticia;
        notificar(); // Se dispara la notificacion automatica al cambiar el estado
    }

    @Override
    public void agregar(Observador o) {
        observadores.add(o);
    }

    @Override
    public void eliminar(Observador o) {
        observadores.remove(o);
    }

    @Override
    public void notificar() {
        for (Observador o : observadores) {
            o.actualizar(ultimaNoticia);
        }
    }
}

// 4. Clase Concreta Observer: Los dependientes que reaccionan a los cambios
class Suscriptor implements Observador {
    private String nombre;

    public Suscriptor(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println(nombre + " recibio la noticia de ultimo momento: " + mensaje);
    }
}

// 5. Clase cliente para probar el patron
public class MainObserver {
    public static void main(String[] args) {
        CanalDeNoticias canal = new CanalDeNoticias();

        // Creamos los observadores
        Suscriptor suscriptor1 = new Suscriptor("Juan");
        Suscriptor suscriptor2 = new Suscriptor("Maria");

        // Los suscribimos al sujeto
        canal.agregar(suscriptor1);
        canal.agregar(suscriptor2);

        System.out.println("Publicando primera noticia...");
        canal.setNuevaNoticia("!El patron Observer funciona a la perfeccion!");
    }
}