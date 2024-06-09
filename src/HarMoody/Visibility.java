package HarMoody;

public class Visibility extends TheHarMoodyGUI{
    public static void removeMainComponents(){
        ques.setVisible(false);
        title.setVisible(false);
    }
    public static void showMainComponents(){
        ques.setVisible(true);
        title.setVisible(true);
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
    public static void showBackButton(){
        back.setVisible(true);
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
        songLength.setVisible(false);
        songStart.setVisible(false);
    }

}
