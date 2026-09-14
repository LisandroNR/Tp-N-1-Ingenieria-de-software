public class EmailAlertsListener implements EventListeners {
    private String email;

    public EmailAlertsListener(String email) {
        this.email = email;
    }

    @Override
    public void update(String filename) {
        System.out.println("[EmailAlertsListener] Correo enviado a " + email + 
                           ": Se ha realizado una operación sobre el archivo '" + filename + "'.");
    }
}