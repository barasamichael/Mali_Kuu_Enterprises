package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ProfilePicture extends JPanel {
    private BufferedImage image;

    public ProfilePicture(String filename) {
        try {
            image = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent evt)
            {
                BufferedImage resizedImage = new BufferedImage(
                        getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);

                Graphics2D g2d = resizedImage.createGraphics();
                g2d.setRenderingHint(
                        RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2d.drawImage(image, 0, 0, getWidth(), getHeight(), null);
                g2d.dispose();

                ProfilePicture.this.image = resizedImage;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, null);
        }
    }
}