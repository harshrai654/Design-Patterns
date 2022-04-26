package Command;

public class Driver {
    public static void main(String[] args) {
        Audio audio = new Audio();
        Video video = new Video();

        Television television = new Television(audio, video);
        Remote remote = new Remote(new IncreaseVolumeCommand(audio), new DecreaseVolumeCommand(audio), new IncreaseChannelCommand(video), new DecreaseChannelCommand(video));

        System.out.println(television);
        remote.pressIncreaseVolume();

        System.out.println(television);
        remote.pressIncreaseChannel();

        System.out.println(television);
        remote.pressDecreaseVolume();

        System.out.println(television);
        remote.pressDecreaseChannel();

        System.out.println(television);

    }
}
