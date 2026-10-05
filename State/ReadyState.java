package State;

class ReadyState extends State {
    public ReadyState(Player player) {
        super(player);
    }

    @Override
    public String onPlay() {
        String action = player.startPlayback();
        player.changeState(new PlayingState(player)); 
        return action;
    }

    @Override
    public String onLock() {
        player.changeState(new LockedState(player)); 
        return "Reproductor bloqueado en espera.";
    }

    @Override
    public String onNext() {
        return "No se puede avanzar pista mientras esta detenido.";
    }
}


