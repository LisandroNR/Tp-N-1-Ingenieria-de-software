public class LoggingListener implements EventListeners {
    private String logFile;

    public LoggingListener(String logFile) {
        this.logFile = logFile;
    }

    @Override
    public void update(String filename) {
        System.out.println("[LoggingListener] Registrando en bitácora (" + logFile + 
                           "): Modificación detectada en el archivo '" + filename + "'.");
    }
}