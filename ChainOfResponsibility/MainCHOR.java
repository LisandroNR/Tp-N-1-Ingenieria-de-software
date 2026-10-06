package ChainOfResponsibility;

/**
 * Clase Main
 * Simula al cliente armando la jerarquía y probando cómo la solicitud 
 * asciende por la cadena de responsabilidad si el componente actual no la resuelve.
 */
public class MainCHOR {
    public static void main(String[] args) {
        // 1. Creamos la ventana principal (Dialog) en la cima de la cadena
        Dialog mainWindow = new Dialog("https://wiki.miaplicacion.com/ayuda-general");

        // 2. Creamos un Panel intermedio y lo agregamos a la ventana
        Panel panelConfig = new Panel(null); // Panel sin ayuda modal propia para probar que suba
        mainWindow.add(panelConfig);

        // 3. Creamos botones: uno con tooltip y otro sin tooltip
        Button botonConTooltip = new Button("Guarda la configuración actual del sistema.");
        Button botonSinTooltip = new Button(null); // No tiene ayuda, forzará a subir en la cadena
        
        panelConfig.add(botonConTooltip);
        panelConfig.add(botonSinTooltip);

        System.out.println("--- CASO 1: Presionar ayuda en botón CON tooltip propio ---");
        botonConTooltip.showHelp();

        System.out.println("\n--- CASO 2: Presionar ayuda en botón SIN tooltip (sube al Dialog) ---");
        botonSinTooltip.showHelp();
    }
}
