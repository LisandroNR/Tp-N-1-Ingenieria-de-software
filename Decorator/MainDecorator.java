package Decorator;

/**
 * Clase Main (Client)
 * Demuestra cómo se pueden apilar múltiples decoradores dinámicamente 
 * (en este caso, compresión y encriptación juntas sobre un archivo).
 */
public class MainDecorator {
    public static void main(String[] args) {
        String datosPrueba = "ClaveSecreta123";

        // Creamos un objeto decorado en capas:
        // El FileDataSource se envuelve en un EncryptionDecorator, y a su vez en un CompressionDecorator.
        DataSource encoded = new CompressionDecorator(
                                new EncryptionDecorator(
                                    new FileDataSource("archivito.txt")
                                )
                             );

        System.out.println("--- ESCRIBIENDO DATOS CON CAPAS ---");
        encoded.writeData(datosPrueba);

        System.out.println("\n--- LEYENDO DATOS CON CAPAS ---");
        String resultado = encoded.readData();
        System.out.println("Resultado final: " + resultado);
    }
}