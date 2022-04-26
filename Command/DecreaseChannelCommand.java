package Command;

public class DecreaseChannelCommand implements Command{
    private final Video video;

    public DecreaseChannelCommand(Video video) {
        this.video = video;
    }

    @Override
    public void execute() {
        video.decrease();
    }

    @Override
    public void undo() {
        video.increase();
    }
}
