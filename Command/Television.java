package Command;

public class Television {
    private final Audio audio;
    private final Video video;

    public Television(Audio audio, Video video) {
        this.audio = audio;
        this.video = video;
    }

    public Audio getAudio() {
        return audio;
    }

    public Video getVideo() {
        return video;
    }

    @Override
    public String toString() {
        return "Television{" +
                "audio=" + audio +
                ", video=" + video +
                '}';
    }
}
