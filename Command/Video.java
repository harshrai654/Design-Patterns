package Command;

public class Video {
    private int channelNumber = 1;

    public void increase() {
        channelNumber = channelNumber + 1;
    }

    public void decrease() {
        channelNumber = channelNumber == 1 ? 1 : channelNumber - 1;
    }

    @Override
    public String toString() {
        return "Video{" +
                "channelNumber=" + channelNumber +
                '}';
    }
}
