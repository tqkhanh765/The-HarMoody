package HarMoody;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoadImage{
    public static ImageIcon loadImage(String imagePath) {
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            return new ImageIcon(image);
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static ImageIcon loadSongImage(String path) {
        try {
            Image img = ImageIO.read(new File(path));
            Image scaledImg = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImg);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
