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
                addComponents();


                List<Song> happySongs = SongLoader.loadSongsFromFolder("src/HarMoody/Happy songs");
                PlaylistManager songList = new PlaylistManager(happySongs);
                songList.shufflePlaylist();
                currentList = songList.getPlaylist();

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
                addBackButton();
                ques.setVisible(false);
                title.setVisible(false);
                happy.setVisible(false);
                sad.setVisible(false);
                calm.setVisible(false);
                ener.setVisible(false);
                happyLabel.setVisible(false);
                sadLabel.setVisible(false);
                calmLabel.setVisible(false);
                enerLabel.setVisible(false);
            }
        });
        calm.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(new Color(204,204,204));
                addBackButton();
                ques.setVisible(false);
                title.setVisible(false);
                happy.setVisible(false);
                sad.setVisible(false);
                calm.setVisible(false);
                ener.setVisible(false);
                happyLabel.setVisible(false);
                sadLabel.setVisible(false);
                calmLabel.setVisible(false);
                enerLabel.setVisible(false);
            }
        });
        ener.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(new Color(255,102,102));
                addBackButton();
                ques.setVisible(false);
                title.setVisible(false);
                happy.setVisible(false);
                sad.setVisible(false);
                calm.setVisible(false);
                ener.setVisible(false);
                happyLabel.setVisible(false);
                sadLabel.setVisible(false);
                calmLabel.setVisible(false);
                enerLabel.setVisible(false);
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
                TheHarMoodyGUI.setPlaybackSliderValue(0);
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
