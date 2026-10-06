package ChainOfResponsibility;

/**
 * Clase Dialog
 * Ventana principal que extiende de Container y maneja la ayuda global mediante una URL de wiki.
 */
public class Dialog extends Container {
    private String wikiPageURL; // Recurso de ayuda global (wiki)

    public Dialog(String wikiPageURL) {
        this.wikiPageURL = wikiPageURL;
    }

    @Override
    public void showHelp() {
        if (wikiPageURL != null) {
            System.out.println("[Dialog] Abriendo página web de la wiki: " + wikiPageURL);
        } else {
            super.showHelp();
        }
    }
}

