// ============================================================================
// DEMOSTRACIÓN / CLIENTE
// ============================================================================
public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        editor.write("Hola, ");
        history.push(editor.save());
        editor.printState();

        editor.write("mundo.");
        history.push(editor.save());
        editor.printState();

        editor.write(" Este texto es un error accidental.");
        editor.printState();

        System.out.println("\n--- Ejecutando UNDO ---");
        editor.restore(history.pop());
        editor.printState();

        System.out.println("\n--- Ejecutando UNDO otra vez ---");
        editor.restore(history.pop());
        editor.printState();
    }
}