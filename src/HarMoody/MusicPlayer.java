package HarMoody;

import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MusicPlayer extends PlaybackListener {
    private TheHarMoodyGUI theHarMoodyGUI;
    private static final Object playSignal = new Object();
    private Song currentSong;
    private AdvancedPlayer advancedPlayer;
    private boolean isPaused;
    private boolean songFinished;
    private boolean pressedNext, pressedPrev;
    private volatile boolean stopSliderThread = false;
    private int currentFrame;
    private int currentTimeInMilli;
    private int currentPlaylistIndex;
    private List<Song> playlist;
    private Set<String> playedSongs = new HashSet<>();
    public MusicPlayer(TheHarMoodyGUI theHarMoodyGUI){
        this.theHarMoodyGUI = theHarMoodyGUI;
    }

    public void loadSong(Song song){
        currentSong = song;
        playlist = ButtonAction.getCurrentlist();
        if (currentSong != null) {
            updatePlaybackSlider(currentSong);
            playCurrentSong();
        }
    }
    public void playCurrentSong(){
        if (currentSong == null) return;
        try {
            FileInputStream fileInputStream = new FileInputStream(currentSong.getFilePath());
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            advancedPlayer = new AdvancedPlayer(bufferedInputStream);
            advancedPlayer.setPlayBackListener(this);

            startMusicThread();

            startPlaybackSliderThread();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public void startMusicThread(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (isPaused){
                        synchronized (playSignal) {
                            isPaused = false;

                            playSignal.notify();
                        }
                        advancedPlayer.play(currentFrame, Integer.MAX_VALUE);
                    } else {
                        advancedPlayer.play();
                    }
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
    @Override
    public void playbackStarted(PlaybackEvent evt) {
        System.out.println("Playback Started");
        songFinished = false;
        pressedNext = false;
        pressedPrev = false;
    }

    @Override
    public void playbackFinished(PlaybackEvent evt) {
        System.out.println("Playback Finished");
        System.out.println("Actual stop" + evt.getFrame());

        if (isPaused) {
            currentFrame += (int) ((double)evt.getFrame() * currentSong.getFrameRatePerMilliseconds());
        } else {
            if (pressedNext || pressedPrev) return;
            songFinished = true;
            if (playlist == null) {
                theHarMoodyGUI.playButton.setVisible(true);
                theHarMoodyGUI.pauseButton.setVisible(false);
            } else {
                if (currentPlaylistIndex == playlist.size() - 1){
                    theHarMoodyGUI.playButton.setVisible(true);
                    theHarMoodyGUI.pauseButton.setVisible(false);
                } else {
                    nextSong();
                }
            }
        }
    }
    public void pauseSong() {
        if (advancedPlayer != null) {
            isPaused = true;
            stopSong();
        }
    }

    public void stopSong() {
        if (advancedPlayer != null) {
            advancedPlayer.stop();
            advancedPlayer.close();
            advancedPlayer = null;
        }
    }
    private void playSong(Song songFile) {
        currentSong = new Song(songFile.getFilePath(), songFile.getImagePath());
        currentTimeInMilli = 0;
        isPaused = false;
        startPlaybackSliderThread();
        //loadSong(currentSong);
    }
    public void nextSong(){
        if (playlist == null) return;

        if (currentPlaylistIndex + 1 > playlist.size() - 1) return;

        pressedNext = true;

        if (!songFinished) {
            stopSong();
        }
        currentPlaylistIndex++;
        currentSong = playlist.get(currentPlaylistIndex);
        currentFrame = 0;
        currentTimeInMilli = 0;

        updateSongInformation(currentSong);
        updatePlaybackSlider(currentSong);

        playCurrentSong();


    }

    public void prevSong(){
        if (playlist == null) return;

        if (currentPlaylistIndex - 1 < 0) return;

        pressedPrev = true;

        stopSong();

        currentPlaylistIndex--;
        currentSong = playlist.get(currentPlaylistIndex);
        currentFrame = 0;
        currentTimeInMilli = 0;

        updateSongInformation(currentSong);
        updatePlaybackSlider(currentSong);

        playCurrentSong();


    }
    public void updatePlaybackSlider(Song song){
        TheHarMoodyGUI.playbackSlider.setMaximum(song.getMp3File().getFrameCount());
        TheHarMoodyGUI.playbackSlider.setValue(0);
        System.out.println("Max value: " + TheHarMoodyGUI.playbackSlider.getMaximum());
    }
    public void resetPlaybackSlider(){
        currentFrame = 0;
        currentTimeInMilli = 0;
        TheHarMoodyGUI.playbackSlider.setValue(0);
        songFinished = false;
    }
    private void startPlaybackSliderThread(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (isPaused) {
                    try{
                        synchronized (playSignal) {
                            playSignal.wait();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                System.out.println("songFinished = " + songFinished);
                System.out.println("pressedNext = " + pressedNext);
                System.out.println("pressedPrev = " + pressedPrev);
                while (!isPaused && !songFinished && !pressedNext && !pressedPrev) {
                    try {
                        currentTimeInMilli++;
                        int calculatedFrame = (int) ((double) currentTimeInMilli * 1.4 * currentSong.getFrameRatePerMilliseconds());
                        theHarMoodyGUI.setPlaybackSliderValue(calculatedFrame);
                        Thread.sleep(1);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    public static void updateSongInformation(Song song){
        TheHarMoodyGUI.songTitle.setText(song.getSongTitle());
        TheHarMoodyGUI.songArtist.setText(song.getSongArtist());
        TheHarMoodyGUI.songLength.setText(song.getSongLength());
        if (song.getImagePath() != null) {
            TheHarMoodyGUI.songImage.setIcon(LoadImage.loadSongImage(song.getImagePath()));
        } else {
            TheHarMoodyGUI.songImage.setIcon(LoadImage.loadSongImage("src/HarMoody/Images/record.png")); // Use a default image if no specific image is found
        }
    }
    public void setCurrentFrame(int frame) {
        currentFrame = frame;
    }
    public void setCurrentTimeInMilli(int timeInMilli){
        currentTimeInMilli = timeInMilli;
    }
    public Song getCurrentSong(){
        return currentSong;
    }
}
