package HarMoody;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ButtonAction extends TheHarMoodyGUI{
    public static void addEmoButtonsAction(){
        happy.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(new Color(255,255,204));
                Visibility.showBackButton();
                Visibility.removeMainComponents();
                Visibility.removeEmoComponents();
                addComponents();

                List<Song> happySongs = SongLoader.loadSongsFromFolder("src/HarMoody/Happy songs");
                Song randomSong = SongSelector.getRandomSong(happySongs);
                if (randomSong != null) {
                    musicPlayer.loadSong(randomSong);
                    musicPlayer.playCurrentSong();

                    // Update the GUI with song details
                    songTitle.setText(randomSong.getSongTitle());
                    songArtist.setText(randomSong.getSongArtist());
                    // Set the song image if available
                    if (randomSong.getImagePath() != null) {
                        songImage.setIcon(loadImage(randomSong.getImagePath()));
                    } else {
                        songImage.setIcon(loadImage("src/HarMoody/Images/record.png")); // Use a default image if no specific image is found
                    } // You might need to customize this
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
    public static void addBackButtonAction(){
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.pink);
                Visibility.showMainComponents();
                Visibility.showEmoComponents();
                Visibility.removePlaybackComponents();
                back.setVisible(false);
            }
        });
    }
    public static void addPlaybackButtonsAction() {
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playButton.setVisible(false);
                pauseButton.setVisible(true);
                musicPlayer.resumeSong();
            }
        });

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pauseButton.setVisible(false);
                playButton.setVisible(true);
                musicPlayer.pauseSong();
            }
        });
    }
}
