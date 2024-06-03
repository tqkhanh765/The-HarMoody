/*package HarMoody;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Components{
    public Components(){};
    static JSlider playbackSlider;
    static JPanel playbackButtons;
    static JButton playButton;
    static JButton prevButton;
    static JButton nextButton;
    static JButton pauseButton;
    static JLabel songImage;
    static JLabel songTitle;
    static JLabel songArtist;
    static JLabel songStart;
    public static void addComponents(){
        //slider
        playbackSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        playbackSlider.setBounds(100,425,400,40);
        playbackSlider.setBackground(null);
        TheHarMoodyGUI.panel.add(playbackSlider);

        //song start time
        songStart = new JLabel("0:00");
        songStart.setBounds(55,420,40,40);
        songStart.setFont(new Font("Cambria",Font.BOLD,15));
        songStart.setVerticalAlignment(SwingConstants.CENTER);
        songStart.setHorizontalAlignment(SwingConstants.CENTER);
        TheHarMoodyGUI.panel.add(songStart);

        //panel
        playbackButtons = new JPanel();
        playbackButtons.setBounds(100,455,400,80);
        playbackButtons.setBackground(null);
        TheHarMoodyGUI.panel.add(playbackButtons);

        //prev button
        prevButton = new JButton(loadImage("src/HarMoody/Images/prev 2.png"));
        prevButton.setBorderPainted(false);
        prevButton.setBackground(null);
        playbackButtons.add(prevButton);

        //play button
        playButton = new JButton(loadImage("src/HarMoody/Images/play 2.png"));
        playButton.setBorderPainted(false);
        playButton.setBackground(null);
        playButton.setVisible(false);
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playButton.setVisible(false);
                pauseButton.setVisible(true);
            }
        });
        playbackButtons.add(playButton);


        //pause button
        pauseButton = new JButton(loadImage("src/HarMoody/Images/pause 3.png"));
        pauseButton.setBorderPainted(false);
        pauseButton.setBackground(null);
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pauseButton.setVisible(false);
                playButton.setVisible(true);
                musicPlayer.pauseSong();
            }
        });
        playbackButtons.add(pauseButton);

        //next button
        nextButton = new JButton(loadImage("src/HarMoody/Images/next 2.png"));
        nextButton.setBorderPainted(false);
        nextButton.setBackground(null);
        playbackButtons.add(nextButton);

        //song image
        songImage = new JLabel();
        songImage.setBounds(100,50,400,300);
        songImage.setHorizontalAlignment(SwingConstants.CENTER);
        songImage.setVerticalAlignment(SwingConstants.CENTER);
        TheHarMoodyGUI.panel.add(songImage);

        //song title
        songTitle = new JLabel("TITLE");
        songTitle.setBounds(100,350,400,50);
        songTitle.setFont(new Font("Cambria",Font.BOLD,25));
        songTitle.setHorizontalAlignment(SwingConstants.CENTER);
        songTitle.setVerticalAlignment(SwingConstants.CENTER);
        TheHarMoodyGUI.panel.add(songTitle);

        //song artist
        songArtist = new JLabel("ARTIST");
        songArtist.setBounds(100,385,400,50);
        songArtist.setFont(new Font("Cambria",Font.BOLD,20));
        songArtist.setHorizontalAlignment(SwingConstants.CENTER);
        songArtist.setVerticalAlignment(SwingConstants.CENTER);
        TheHarMoodyGUI.panel.add(songArtist);
    }
    public static void removePlaybackComponents(){
        playbackSlider.setVisible(false);
        playbackButtons.setVisible(false);
        playButton.setVisible(false);
        prevButton.setVisible(false);
        nextButton.setVisible(false);
        pauseButton.setVisible(false);
        songArtist.setVisible(false);
        songTitle.setVisible(false);
        songImage.setVisible(false);
    }
}*/
