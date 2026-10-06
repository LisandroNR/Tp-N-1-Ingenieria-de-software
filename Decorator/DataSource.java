package Decorator;
/**
 * Interfaz DataSource
 * Define el contrato estándar que deben seguir tanto los objetos básicos como los decoradores.
 */
public interface DataSource {
    void writeData(String data);
    String readData();
}
