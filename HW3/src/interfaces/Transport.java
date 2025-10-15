package interfaces;

public interface Transport {
    void startEngine();
    void stopEngine();
    void move(double distance);
    String getInfo();
}
