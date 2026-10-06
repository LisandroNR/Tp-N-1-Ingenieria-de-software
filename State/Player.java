package State;

class Player {
    private State state;
    private boolean playing = false;
    private int currentTrack = 1;

    public Player() {
        this.state = new ReadyState(this);
    }

    public void changeState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public boolean isPlaying() {
        return playing;
    }
    public void clickPlay() {
        System.out.println("[Boton Play presionado] -> " + state.onPlay());
    }

    public void clickLock() {
        System.out.println("[Boton Lock presionado] -> " + state.onLock());
    }

    public void clickNext() {
        System.out.println("[Boton Next presionado] -> " + state.onNext());
    }

    public String startPlayback() {
        this.playing = true;
        return "Reproduciendo pista " + currentTrack;
    }

    public String pausePlayback() {
        this.playing = false;
        return "Pausa en pista " + currentTrack;
    }

    public String nextTrack() {
        currentTrack++;
        return "Avanzando a pista " + currentTrack;
    }
}