/*package HarMoody;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmojiButtons{
    public EmojiButtons(){};
    static JButton happy;
    static JButton sad;
    static JButton calm;
    static JButton ener;
    static JLabel happyLabel;
    static JLabel sadLabel;
    static JLabel calmLabel;
    static JLabel enerLabel;
    public static void addEmoButtons(){
        //happy button
        happy = new JButton(loadImage("src/Assets/Images/happy.png"));
        happy.setBorderPainted(false);
        happy.setBackground(null);
        happy.setBounds(150, 200, 90, 90);
        happy.setHorizontalAlignment(SwingConstants.CENTER);
        happy.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(happy);

        //sad button
        sad = new JButton(loadImage("src/Assets/Images/sad.png"));
        sad.setBorderPainted(false);
        sad.setBackground(null);
        sad.setBounds(360, 200, 90, 90);
        sad.setHorizontalAlignment(SwingConstants.CENTER);
        sad.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(sad);

        //calm button
        calm = new JButton(loadImage("src/Assets/Images/calm.png"));
        calm.setBorderPainted(false);
        calm.setBackground(null);
        calm.setBounds(150, 350, 90, 90);
        calm.setHorizontalAlignment(SwingConstants.CENTER);
        calm.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(calm);

        //energetic button
        ener = new JButton(loadImage("src/Assets/Images/energetic.png"));
        ener.setBorderPainted(false);
        ener.setBackground(null);
        ener.setBounds(360, 350, 90, 90);
        ener.setHorizontalAlignment(SwingConstants.CENTER);
        ener.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(ener);
    }
    public static void addBackButton(){
        back = new JButton(loadImage("src/Assets/Images/Back resized 2.png"));
        back.setBorderPainted(false);
        back.setBackground(null);
        back.setBounds(10, 10, 53, 53);
        back.setHorizontalAlignment(SwingConstants.CENTER);
        back.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.pink);
                Visibility.showMainComponents();
                showEmoComponents();
                Components.removePlaybackComponents();
                back.setVisible(false);
            }
        });
    }
    public static void addEmoLabels(){
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
    }
    public static void addEmoButtonsAction(){
        happy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(new Color(255,255,204));
                addBackButton();
                removeMainComponents();
                removeEmoComponents();
                Components.addComponents();
            }
        });
        sad.addActionListener(new ActionListener() {
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
        calm.addActionListener(new ActionListener() {
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
        ener.addActionListener(new ActionListener() {
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
    public static void removeEmoComponents(){
        happy.setVisible(false);
        sad.setVisible(false);
        calm.setVisible(false);
        ener.setVisible(false);
        happyLabel.setVisible(false);
        sadLabel.setVisible(false);
        calmLabel.setVisible(false);
        enerLabel.setVisible(false);
    }
    public static void showEmoComponents(){
        happy.setVisible(true);
        sad.setVisible(true);
        calm.setVisible(true);
        ener.setVisible(true);
        happyLabel.setVisible(true);
        sadLabel.setVisible(true);
        calmLabel.setVisible(true);
        enerLabel.setVisible(true);
    }
}*/
