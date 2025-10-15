package engines;

public class JetEngine implements Engine {
    private final int thrust;

    public JetEngine(int thrust) {
        this.thrust = thrust;
    }

    public int getThrust() {
        return thrust;
    }
}
