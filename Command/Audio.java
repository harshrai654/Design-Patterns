package Command;

public class Audio {
    private int volume = 10;

    public void increase() {
        volume = volume + 1;
    }

    public void decrease() {
        volume = volume == 0 ? 0 : volume - 1;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "volume=" + volume +
                '}';
    }
}
