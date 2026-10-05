package Decorator;

/**
 * Clase FileDataSource
 * Implementación básica que maneja la lectura y escritura de información en un archivo por defecto.
 */
public class FileDataSource implements DataSource {
    private String filename;

    public FileDataSource(String filename) {
        this.filename = filename;
    }

    @Override
    public void writeData(String data) {
        System.out.println("[FileDataSource] Escribiendo datos en el archivo: " + filename);
        // Simulación de escritura básica
    }

    @Override
    public String readData() {
        System.out.println("[FileDataSource] Leyendo datos del archivo: " + filename);
        return "Datos originales del archivo";
    }
}
