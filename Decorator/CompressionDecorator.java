package Decorator;

/**
 * Clase CompressionDecorator
 * Añade la funcionalidad de comprimir y descomprimir los datos en tiempo de ejecución.
 */
public class CompressionDecorator extends DataSourceDecorator {

    public CompressionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        String compressedData = comprimir(data);
        System.out.println("[CompressionDecorator] Datos comprimidos.");
        super.writeData(compressedData);
    }

    @Override
    public String readData() {
        String data = super.readData();
        System.out.println("[CompressionDecorator] Datos descomprimidos.");
        return descomprimir(data);
    }

    private String comprimir(String data) {
        return "(Compreso)" + data;
    }

    private String descomprimir(String data) {
        return data.replace("(Compreso)", "");
    }
}