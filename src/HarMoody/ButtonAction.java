package HarMoody;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ButtonAction extends TheHarMoodyGUI{
    static int songType;
    static List<Song> currentList;
    public static void addEmoButtonsAction(){
        happy.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(new Color(255,255,204));

                Visibility.removeMainComponents();
                Visibility.removeEmoComponents();
                back.setVisible(true);
                addComponents();


                List<Song> happySongs = SongLoader.loadSongsFromFolder("src/HarMoody/Happy songs");
                PlaylistManager happyList = new PlaylistManager(happySongs);
                happyList.shufflePlaylist();
                currentList = happyList.getPlaylist();

                Song playingSong = currentList.get(0);
                if (playingSong != null) {
                    musicPlayer.loadSong(playingSong);
                    musicPlayer.updateSongInformation(playingSong);
                }
            }
        });
        sad.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(new Color(51,153,255));

                Visibility.removeMainComponents();
                Visibility.removeEmoComponents();
                back.setVisible(true);
                addComponents();


                List<Song> sadSongs = SongLoader.loadSongsFromFolder("src/HarMoody/Sad songs");
                PlaylistManager sadList = new PlaylistManager(sadSongs);
                sadList.shufflePlaylist();
                currentList = sadList.getPlaylist();

                Song playingSong = currentList.get(0);
                if (playingSong != null) {
                    musicPlayer.loadSong(playingSong);
                    musicPlayer.updateSongInformation(playingSong);
                }
            }
        });
        calm.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(new Color(204,204,204));

                Visibility.removeMainComponents();
                Visibility.removeEmoComponents();
                back.setVisible(true);
                addComponents();


                List<Song> calmSongs = SongLoader.loadSongsFromFolder("src/HarMoody/Calm songs");
                PlaylistManager calmList = new PlaylistManager(calmSongs);
                calmList.shufflePlaylist();
                currentList = calmList.getPlaylist();

                Song playingSong = currentList.get(0);
                if (playingSong != null) {
                    musicPlayer.loadSong(playingSong);
                    musicPlayer.updateSongInformation(playingSong);
                    musicPlayer.updatePlaybackSlider(playingSong);
                }
            }
        });
        ener.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(new Color(255,102,102));

                Visibility.removeMainComponents();
                Visibility.removeEmoComponents();
                back.setVisible(true);
                addComponents();


                List<Song> enerSongs = SongLoader.loadSongsFromFolder("src/HarMoody/Energetic songs");
                PlaylistManager enerList = new PlaylistManager(enerSongs);
                enerList.shufflePlaylist();
                currentList = enerList.getPlaylist();

                Song playingSong = currentList.get(0);
                if (playingSong != null) {
                    musicPlayer.loadSong(playingSong);
                    musicPlayer.updateSongInformation(playingSong);
                }
            }
        });
    }
    public static List<Song> getCurrentlist(){
        return currentList;
    }
    public static void addBackButtonAction(){
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.pink);
                Visibility.showMainComponents();
                Visibility.showEmoComponents();
                Visibility.removePlaybackComponents();
                back.setVisible(false);
                musicPlayer.stopSong();
                musicPlayer.resetPlaybackSlider();
            }
        });
    }
    public static void addPlaybackButtonsAction() {
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playButton.setVisible(false);
                pauseButton.setVisible(true);

                musicPlayer.playCurrentSong();

                //System.out.println("Play Button clicked");
            }
        });

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pauseButton.setVisible(false);
                playButton.setVisible(true);

                musicPlayer.pauseSong();

                //System.out.println("Pause Button clicked");

            }
        });
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                musicPlayer.prevSong();
            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                musicPlayer.nextSong();
            }
        });
    }
    public static void addSliderAction(){
        playbackSlider.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                musicPlayer.pauseSong();
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                JSlider source = (JSlider) e.getSource();
                int frame = source.getValue();
                musicPlayer.setCurrentFrame(frame);
                musicPlayer.setCurrentTimeInMilli((int) (frame/(1.4 * musicPlayer.getCurrentSong().getFrameRatePerMilliseconds())));
                musicPlayer.playCurrentSong();
            }
        });
    }

}
