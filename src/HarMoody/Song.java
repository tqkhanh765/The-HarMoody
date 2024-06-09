package HarMoody;

import com.mpatric.mp3agic.Mp3File;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

import java.io.File;

public class Song{
    private String songTitle;
    private String songArtist;
    private String songLength;
    private String filePath;
    private String imagePath;
    private Mp3File mp3File;
    private double frameRatePerMilliseconds;

    public Song(String filePath, String imagePath) {
        this.filePath = filePath;
        this.imagePath = imagePath;
        try {
            mp3File = new Mp3File(new File(filePath));
            frameRatePerMilliseconds = (double) mp3File.getFrameCount() / mp3File.getLengthInMilliseconds();
            songLength = convertToSongLengthFormat(mp3File);

            AudioFile audioFile = AudioFileIO.read(new File(filePath));
            Tag tag = audioFile.getTag();
            if (tag != null) {
                songTitle = tag.getFirst(FieldKey.TITLE);
                songArtist = tag.getFirst(FieldKey.ARTIST);
            } else {
                songTitle = "N/A";
                songArtist = "N/A";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getSongTitle() {
        return songTitle;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public String getSongLength() {
        return songLength;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public Mp3File getMp3File() {
        return mp3File;
    }

    public double getFrameRatePerMilliseconds() {
        return frameRatePerMilliseconds;
    }

    private String convertToSongLengthFormat(Mp3File mp3File) {
        long minutes = mp3File.getLengthInSeconds() / 60;
        long seconds = mp3File.getLengthInSeconds() % 60;
        return String.format("%01d:%02d", minutes, seconds);
    }
}
