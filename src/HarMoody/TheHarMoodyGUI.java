package HarMoody;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class TheHarMoodyGUI {
    static JFrame frame;
    static JPanel panel;
    static JLabel title;
    static JLabel ques;
    static JButton back;
    static MusicPlayer musicPlayer;
    private JFileChooser jFileChooser;
    static JButton happy;
    static JButton sad;
    static JButton calm;
    static JButton ener;
    static JLabel happyLabel;
    static JLabel sadLabel;
    static JLabel calmLabel;
    static JLabel enerLabel;
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
    public TheHarMoodyGUI() {
        musicPlayer = new MusicPlayer();
        createMainGUI();
        addEmoButtonsAndLabels();
        addBackButton();
        ButtonAction.addPlaybackButtonsAction();
    }
    private void createMainGUI (){
        //frame
        frame = new JFrame();
        frame.setTitle("The K-HarMoody [ENGLISH]");
        frame.setVisible(true);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        //panel
        panel = new JPanel();
        panel.setBackground(Color.pink);
        panel.setLayout(null);
        frame.getContentPane().add(panel);

        //title
        title = new JLabel("THE K-HARMOODY");
        title.setFont(new Font("Cambria",Font.BOLD,50));
        title.setBounds(50, 50, 500, 60);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(title);

        //question
        ques = new JLabel("How are you feeling now?");
        ques.setFont(new Font("Cambria",Font.BOLD,20));
        ques.setBounds(100, 100, 400, 60);
        ques.setHorizontalAlignment(SwingConstants.CENTER);
        ques.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(ques);



        jFileChooser = new JFileChooser();
        jFileChooser.setCurrentDirectory(new File("src/Assets"));

    }
    private void addMusicPlayerGUI(){

    }
    public static void addEmoButtonsAndLabels(){
        //happy button
        happy = new JButton(loadImage("src/HarMoody/Images/happy.png"));
        happy.setBorderPainted(false);
        happy.setBackground(null);
        happy.setBounds(150, 200, 90, 90);
        happy.setHorizontalAlignment(SwingConstants.CENTER);
        happy.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(happy);

        //sad button
        sad = new JButton(loadImage("src/HarMoody/Images/sad.png"));
        sad.setBorderPainted(false);
        sad.setBackground(null);
        sad.setBounds(360, 200, 90, 90);
        sad.setHorizontalAlignment(SwingConstants.CENTER);
        sad.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(sad);

        //calm button
        calm = new JButton(loadImage("src/HarMoody/Images/calm.png"));
        calm.setBorderPainted(false);
        calm.setBackground(null);
        calm.setBounds(150, 350, 90, 90);
        calm.setHorizontalAlignment(SwingConstants.CENTER);
        calm.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(calm);

        //energetic button
        ener = new JButton(loadImage("src/HarMoody/Images/energetic.png"));
        ener.setBorderPainted(false);
        ener.setBackground(null);
        ener.setBounds(360, 350, 90, 90);
        ener.setHorizontalAlignment(SwingConstants.CENTER);
        ener.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(ener);

        //happy label
        happyLabel = new JLabel("HAPPY");
        happyLabel.setFont(new Font("Cambria",Font.BOLD,17));
        happyLabel.setBounds(150, 260, 90, 90);
        happyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        happyLabel.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(happyLabel);

        //sad label
        sadLabel = new JLabel("SAD");
        sadLabel.setFont(new Font("Cambria",Font.BOLD,17));
        sadLabel.setBounds(360, 260, 90, 90);
        sadLabel.setHorizontalAlignment(SwingConstants.CENTER);
        sadLabel.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(sadLabel);

        //calm label
        calmLabel = new JLabel("CALM");
        calmLabel.setFont(new Font("Cambria",Font.BOLD,17));
        calmLabel.setBounds(150, 410, 90, 90);
        calmLabel.setHorizontalAlignment(SwingConstants.CENTER);
        calmLabel.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(calmLabel);

        //energetic label
        enerLabel = new JLabel("ENERGETIC");
        enerLabel.setFont(new Font("Cambria",Font.BOLD,17));
        enerLabel.setBounds(355, 410, 100, 90);
        enerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        enerLabel.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(enerLabel);

        ButtonAction.addEmoButtonsAction();
    }

    public static void addBackButton(){
        back = new JButton(loadImage("src/HarMoody/Images/Back resized 2.png"));
        back.setBorderPainted(false);
        back.setBackground(null);
        back.setBounds(10, 10, 53, 53);
        back.setHorizontalAlignment(SwingConstants.CENTER);
        back.setVerticalAlignment(SwingConstants.CENTER);
        back.setVisible(false);
        panel.add(back);

        ButtonAction.addBackButtonAction();
    }
    public static void addComponents(){
        //slider
        playbackSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        playbackSlider.setBounds(100,425,400,40);
        playbackSlider.setBackground(null);
        panel.add(playbackSlider);

        //song start time
        songStart = new JLabel("0:00");
        songStart.setBounds(55,420,40,40);
        songStart.setFont(new Font("Cambria",Font.BOLD,15));
        songStart.setVerticalAlignment(SwingConstants.CENTER);
        songStart.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(songStart);

        //panel
        playbackButtons = new JPanel();
        playbackButtons.setBounds(100,455,400,80);
        playbackButtons.setBackground(null);
        panel.add(playbackButtons);

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
        playbackButtons.add(playButton);


        //pause button
        pauseButton = new JButton(loadImage("src/HarMoody/Images/pause 3.png"));
        pauseButton.setBorderPainted(false);
        pauseButton.setBackground(null);
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
        panel.add(songImage);

        //song title
        songTitle = new JLabel("TITLE");
        songTitle.setBounds(100,350,400,50);
        songTitle.setFont(new Font("Cambria",Font.BOLD,25));
        songTitle.setHorizontalAlignment(SwingConstants.CENTER);
        songTitle.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(songTitle);

        //song artist
        songArtist = new JLabel("ARTIST");
        songArtist.setBounds(100,385,400,50);
        songArtist.setFont(new Font("Cambria",Font.BOLD,20));
        songArtist.setHorizontalAlignment(SwingConstants.CENTER);
        songArtist.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(songArtist);
    }

    public static ImageIcon loadImage(String imagePath) {
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            return new ImageIcon(image);
        } catch(Exception e){
            System.out.println("Error loading image: " + imagePath);
            e.printStackTrace();
        }
        return null;
    }
}
