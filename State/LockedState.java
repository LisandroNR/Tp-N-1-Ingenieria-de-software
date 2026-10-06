package State;


class LockedState extends State {
    public LockedState(Player player) {
        super(player);
    }

    @Override
    public String onPlay() {
        return "Accion bloqueada. Desbloquee primero el dispositivo.";
    }

    @Override
    public String onNext() {
        return "Accion bloqueada. Desbloquee primero el dispositivo.";
    }

    @Override
    public String onLock() {
        if (player.isPlaying()) {
            player.changeState(new PlayingState(player));
            return "Desbloqueado -> Volviendo a reproduccion activa.";
        } else {
            player.changeState(new ReadyState(player));
            return "Desbloqueado -> Volviendo a modo de espera.";
        }
    }
}