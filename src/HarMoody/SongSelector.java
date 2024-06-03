package HarMoody;

import java.util.List;
import java.util.Random;

public class SongSelector {
    public static Song getRandomSong(List<Song> songs) {
        if (songs.isEmpty()) {
            return null;
        }
        Random random = new Random();
        return songs.get(random.nextInt(songs.size()));
    }
}