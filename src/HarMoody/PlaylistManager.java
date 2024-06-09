package HarMoody;

import java.util.Collections;
import java.util.List;

public class PlaylistManager {
    private List<Song> playlist;

    public PlaylistManager(List<Song> playlist) {
        this.playlist = playlist;
    }

    public void shufflePlaylist() {
        Collections.shuffle(playlist);
    }

    public List<Song> getPlaylist() {
        return playlist;
    }
}
