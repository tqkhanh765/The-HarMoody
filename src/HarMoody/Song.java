package HarMoody;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

import java.io.File;

public class Song {
    private String songTitle;
    private String songArtist;
    private String songLength;
    private String filePath;
    private String imagePath;

    public Song(String filePath, String imagePath) {
        this.filePath = filePath;
        this.imagePath = imagePath;
        try {
            AudioFile audioFile = AudioFileIO.read(new File(filePath));
            Tag tag = audioFile.getTag();
            AudioHeader audioHeader = audioFile.getAudioHeader();
            if (tag != null) {
                songTitle = tag.getFirst(FieldKey.TITLE);
                songArtist = tag.getFirst(FieldKey.ARTIST);
            } else {
                songTitle = "N/A";
                songArtist = "N/A";
            }
            if (audioHeader != null) {
                songLength = audioHeader.getTrackLength() / 60 + ":" + audioHeader.getTrackLength() % 60;
            } else {
                songLength = "N/A";
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
}
