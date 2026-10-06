package State;
// ============================================================================
// 4. CLIENTE / DEMOSTRACION
// ============================================================================
public class Main {
    public static void main(String[] args) {
        Player player = new Player();

        System.out.println("--- 1. Iniciar reproduccion ---");
        player.clickPlay(); 

        System.out.println("\n--- 2. Cambiar de pista ---");
        player.clickNext(); 

        System.out.println("\n--- 3. Bloquear reproductor ---");
        player.clickLock(); 

        System.out.println("\n--- 4. Intentar interactuar bloqueado ---");
        player.clickPlay(); 
        player.clickNext(); 

        System.out.println("\n--- 5. Desbloquear y pausar ---");
        player.clickLock(); 
        player.clickPlay(); 
    }
}