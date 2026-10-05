public class Editor {
    public EventManager events;

    public Editor() {
        this.events = new EventManager("open", "save");
    }

    public void openFile(String filePath) {
        System.out.println("\n[Editor] Abriendo archivo: " + filePath);
        events.notify("open", filePath);
    }

    public void saveFile(String filePath) {
        System.out.println("\n[Editor] Guardando cambios en el archivo: " + filePath);
        events.notify("save", filePath);
    }
}