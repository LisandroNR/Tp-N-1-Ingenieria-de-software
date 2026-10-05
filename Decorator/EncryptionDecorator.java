package Decorator;

/**
 * Clase EncryptionDecorator
 * Añade la funcionalidad adicional de encriptar y desencriptar los datos de manera dinámica.
 */
public class EncryptionDecorator extends DataSourceDecorator {

    public EncryptionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        String encryptedData = encriptar(data);
        System.out.println("[EncryptionDecorator] Datos encriptados.");
        super.writeData(encryptedData); // Envía los datos encriptados al siguiente objeto envuelto
    }

    @Override
    public String readData() {
        String data = super.readData();
        System.out.println("[EncryptionDecorator] Datos desencriptados.");
        return desencriptar(data);
    }

    private String encriptar(String data) {
        return "[ENCRYPTED: " + data + "]";
    }

    private String desencriptar(String data) {
        return data.replace("[ENCRYPTED: ", "").replace("]", "");
    }
}
