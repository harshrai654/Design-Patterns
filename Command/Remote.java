package Command;

public class Remote {
    private final Command increaseVolume;
    private final Command decreaseVolume;
    private final Command increaseChannel;
    private final Command decreaseChannel;

    public Remote(Command increaseVolume, Command decreaseVolume, Command increaseChannel, Command decreaseChannel) {
        this.increaseVolume = increaseVolume;
        this.decreaseVolume = decreaseVolume;
        this.increaseChannel = increaseChannel;
        this.decreaseChannel = decreaseChannel;
    }

    public void pressIncreaseVolume() {
        increaseVolume.execute();
    }

    public void pressDecreaseVolume() {
        decreaseVolume.execute();
    }

    public void pressIncreaseChannel() {
        increaseChannel.execute();
    }

    public void pressDecreaseChannel() {
        decreaseChannel.execute();
    }


}
