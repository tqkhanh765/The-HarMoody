package HarMoody;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SongLoader {
    public static List<Song> loadSongsFromFolder(String folderPath) {
        List<Song> songs = new ArrayList<>();
        File folder = new File(folderPath);
        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".mp3"));
        if (files != null) {
            for (File file : files) {
                String imagePath = file.getAbsolutePath().replace(".mp3", ".jpg");
                if (!new File(imagePath).exists()) {
                    imagePath = null; // If the image doesn't exist, set imagePath to null
                }
                songs.add(new Song(file.getAbsolutePath(), imagePath));
            }
        }
        return songs;
    }
}
