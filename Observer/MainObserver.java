public class MainObserver {
    public static void main(String[] args) {
        //Instanciamos el objeto central (Editor)
        Editor editor = new Editor();

        //Creamos observadores concretos
        LoggingListener logger = new LoggingListener("app.log");
        EmailAlertsListener emailAlert = new EmailAlertsListener("admin@empresa.com");

        //Suscripciones selectivas según tipo de evento:
        // - El logger escuchará aperturas ("open") y guardados ("save")
        editor.events.subscribe("open", logger);
        editor.events.subscribe("save", logger);

        // - La alerta por email solo se activará al guardar ("save")
        editor.events.subscribe("save", emailAlert);

        //Simulamos acciones del editor
        editor.openFile("documento_trabajo.txt");
        editor.saveFile("documento_trabajo.txt");

        //Desuscribir observador
        System.out.println("\n--- Cancelando suscripción del correo para guardados ---");
        editor.events.unsubscribe("save", emailAlert);

        //Nuevo guardado (solo logger debe responder)
        editor.saveFile("documento_trabajo.txt");
    }
}