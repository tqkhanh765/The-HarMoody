package HarMoody;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SliderAction extends TheHarMoodyGUI{
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