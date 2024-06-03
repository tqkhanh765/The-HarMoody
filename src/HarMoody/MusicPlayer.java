package HarMoody;

import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class MusicPlayer extends PlaybackListener {
    private Song currentSong;
    private AdvancedPlayer advancedPlayer;
    private boolean isPlaying;
    private boolean isPaused;
    private Thread musicThread;
    private long pausedFrame;
    public MusicPlayer(){

    }
    public void loadSong(Song song){
        currentSong = song;
        if (currentSong != null) {
            playCurrentSong();
        }
    }
    public void playCurrentSong(){
        try {
            FileInputStream fileInputStream = new FileInputStream(currentSong.getFilePath());
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            advancedPlayer = new AdvancedPlayer(bufferedInputStream);
            advancedPlayer.setPlayBackListener(this);

            startMusicThread();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public void startMusicThread(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    advancedPlayer.play();
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public void pauseSong() {
        if (advancedPlayer!= null && isPlaying) {
            try {
                pausedFrame = advancedPlayer.getPosition();
                advancedPlayer.pause();
                isPlaying = false;
                isPaused = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void resumeSong() {
        if (advancedPlayer!= null && isPaused) {
            try {
                advancedPlayer.seek(pausedFrame);
                advancedPlayer.play();
                isPlaying = true;
                isPaused = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void stopSong() {
        if (advancedPlayer != null) {
            advancedPlayer.stop();
            advancedPlayer.close();
            advancedPlayer = null;
        }
        if (musicThread != null) {
            musicThread.interrupt();
            musicThread = null;
        }
    }

    @Override
    public void playbackStarted(PlaybackEvent evt) {
        System.out.println("Playback Started");
    }

    @Override
    public void playbackFinished(PlaybackEvent evt) {
        System.out.println("Playback Finished");
    }


}
