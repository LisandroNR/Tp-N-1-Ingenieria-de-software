import java.util.ArrayDeque;
import java.util.Deque;

// ============================================================================
// CARETAKER (El conserje / administrador del historial)
// Guarda los mementos en una pila. NUNCA inspecciona ni modifica su contenido.
// ============================================================================
class History {
    private final Deque<TextEditorMemento> checkpoints = new ArrayDeque<>();

    public void push(TextEditorMemento memento) {
        checkpoints.push(memento);
    }

    public TextEditorMemento pop() {
        if (checkpoints.isEmpty()) {
            return null;
        }
        return checkpoints.pop();
    }
}