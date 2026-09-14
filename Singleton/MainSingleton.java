// Clase que aplica el patron Singleton
class DatabaseConnection {
    private static DatabaseConnection instance;
    private String connectionStatus;

    private DatabaseConnection() {
        this.connectionStatus = "Conectado a la base de datos";
        System.out.println("Inicializando la conexion a la base de datos...");
    }

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void executeQuery(String query) {
        System.out.println("Ejecutando: " + query + " | Estado: " + connectionStatus);
    }
}

// Clase cliente para probar tu implementacion
public class MainSingleton {
    public static void main(String[] args) {
        // Se solicita la instancia por primera vez
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        db1.executeQuery("SELECT * FROM usuarios");

        // Se solicita nuevamente
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        db2.executeQuery("SELECT * FROM productos");

        // Verificacion final para la captura de pantalla
        System.out.println("¿db1 y db2 son la misma instancia? " + (db1 == db2));
    }
}