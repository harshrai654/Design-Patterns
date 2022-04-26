package Command;

public class IncreaseVolumeCommand implements Command{
    private final Audio audio;

    public IncreaseVolumeCommand(Audio audio) {
        this.audio = audio;
    }

    @Override
    public void execute() {
        audio.increase();
    }

    @Override
    public void undo() {
        audio.decrease();
    }
}
