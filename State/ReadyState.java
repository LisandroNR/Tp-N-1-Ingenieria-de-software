package State;

// Estado 1: El reproductor esta listo y detenido
class ReadyState extends State {
    public ReadyState(Player player) {
        super(player);
    }

    @Override
    public String onPlay() {
        String action = player.startPlayback();
        player.changeState(new PlayingState(player)); // Transiciona a Playing
        return action;
    }

    @Override
    public String onLock() {
        player.changeState(new LockedState(player));  // Transiciona a Locked
        return "Reproductor bloqueado en espera.";
    }

    @Override
    public String onNext() {
        return "No se puede avanzar pista mientras esta detenido.";
    }
}

// Estado 2: El reproductor esta tocando musica
class PlayingState extends State {
    public PlayingState(Player player) {
        super(player);
    }

    @Override
    public String onPlay() {
        String action = player.pausePlayback();
        player.changeState(new ReadyState(player));   // Transiciona a Ready (pausa)
        return action;
    }

    @Override
    public String onLock() {
        player.changeState(new LockedState(player));  // Transiciona a Locked
        return "Reproductor bloqueado (la musica sigue de fondo).";
    }

    @Override
    public String onNext() {
        return player.nextTrack();
    }
}

// Estado 3: El reproductor tiene los controles bloqueados
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
        // Al tocar Lock estando bloqueado, se desbloquea al estado correspondiente
        if (player.isPlaying()) {
            player.changeState(new PlayingState(player));
            return "Desbloqueado -> Volviendo a reproduccion activa.";
        } else {
            player.changeState(new ReadyState(player));
            return "Desbloqueado -> Volviendo a modo de espera.";
        }
    }
}