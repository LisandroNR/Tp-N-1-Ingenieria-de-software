package Decorator;

/**
 * Clase DataSourceDecorator
 * Decorador base que implementa la interfaz y mantiene una referencia (wrappee) 
 * a otro objeto DataSource para envolverlo.
 */
public class DataSourceDecorator implements DataSource {
    protected DataSource wrappee; // Referencia al objeto envuelto

    public DataSourceDecorator(DataSource source) {
        this.wrappee = source;
    }

    @Override
    public void writeData(String data) {
        wrappee.writeData(data); // Delega la ejecución por defecto
    }

    @Override
    public String readData() {
        return wrappee.readData(); // Delega la ejecución por defecto
    }
}