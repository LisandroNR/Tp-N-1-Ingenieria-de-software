// ============================================================================
// MEMENTO (La instantánea)
// Objeto inmutable que almacena el estado interno del Originator.
// ============================================================================
class TextEditorMemento {
    private final String content;
    private final int cursorPosition;

    public TextEditorMemento(String content, int cursorPosition) {
        this.content = content;
        this.cursorPosition = cursorPosition;
    }

    public String getContent() {
        return content;
    }

    public int getCursorPosition() {
        return cursorPosition;
    }
}