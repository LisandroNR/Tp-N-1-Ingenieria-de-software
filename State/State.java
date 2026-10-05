package State;

// ============================================================================
// 2. INTERFAZ / CLASE ABSTRACTA STATE
// ============================================================================
abstract class State {
    protected Player player;

    public State(Player player) {
        this.player = player;
    }

    public abstract String onLock();
    public abstract String onPlay();
    public abstract String onNext();
}

