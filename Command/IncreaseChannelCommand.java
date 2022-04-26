package Command;

public class IncreaseChannelCommand implements Command{
    private final Video video;

    public IncreaseChannelCommand(Video video) {
        this.video = video;
    }

    @Override
    public void execute() {
        video.increase();
    }

    @Override
    public void undo() {
        video.decrease();
    }
}
