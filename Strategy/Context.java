public class Context {
    private Strategy strategy;
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    public void executeStrategy() {
        if (strategy != null) {
            strategy.algorithm();
        } else {
            System.out.println("No hay ninguna estrategia definida todavía.");
        }
    }
}
