// ============================================================================
// ORIGINATOR (El creador)
// Posee el estado real. Sabe cómo guardarse en un Memento y cómo restaurarse.
// ============================================================================
class TextEditor {
    private String content = "";
    private int cursorPosition = 0;

    public void write(String text) {
        this.content += text;
        this.cursorPosition = this.content.length();
    }

    public TextEditorMemento save() {
        return new TextEditorMemento(this.content, this.cursorPosition);
    }

    public void restore(TextEditorMemento memento) {
        if (memento != null) {
            this.content = memento.getContent();
            this.cursorPosition = memento.getCursorPosition();
        }
    }

    public void printState() {
        System.out.println("Texto actual: \"" + content + "\" | Cursor en: " + cursorPosition);
    }
}