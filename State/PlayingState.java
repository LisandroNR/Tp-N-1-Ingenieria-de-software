package State;

class PlayingState extends State {
    public PlayingState(Player player) {
        super(player);
    }

    @Override
    public String onPlay() {
        String action = player.pausePlayback();
        player.changeState(new ReadyState(player)); 
        return action;
    }

    @Override
    public String onLock() {
        player.changeState(new LockedState(player));
        return "Reproductor bloqueado (la musica sigue de fondo).";
    }

    @Override
    public String onNext() {
        return player.nextTrack();
    }
}
