package Command;

public class DecreaseVolumeCommand implements Command{
    private final Audio audio;

    public DecreaseVolumeCommand(Audio audio) {
        this.audio = audio;
    }

    @Override
    public void execute() {
        audio.decrease();
    }

    @Override
    public void undo() {
        audio.increase();
    }
}
