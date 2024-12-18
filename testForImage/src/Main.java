import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main extends JFrame {
    private BufferedImage originalImage;
    private BufferedImage rotatedImage;
    private JLabel imageLabel;

    public Main(String imagePath) {
        // Load the image
        try {
            originalImage = ImageIO.read(new File(imagePath));
            rotatedImage = originalImage;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Image not found!", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        // Set up the JFrame
        setTitle("Image Rotator");
        setSize(800, 600);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JLabel to display the image
        imageLabel = new JLabel(new ImageIcon(rotatedImage));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        add(imageLabel, BorderLayout.CENTER);

        // Buttons panel
        JPanel buttonPanel = new JPanel();


        JButton rotate90Button = new JButton("Rotate 90°");
        JButton rotate180Button = new JButton("Rotate 180°");
        JButton rotateNeg90Button = new JButton("Rotate -90°");
        JButton grayScale = new JButton("Gray Scale");
        JButton GreenScale = new JButton("green Scale");
        JButton randomScale = new JButton("random Scale");

        buttonPanel.add(rotate90Button);
        buttonPanel.add(rotate180Button);
        buttonPanel.add(rotateNeg90Button);
        buttonPanel.add(grayScale);
        buttonPanel.add(GreenScale);
        buttonPanel.add(randomScale);

        add(buttonPanel, BorderLayout.SOUTH);

        // Button actions
        rotate90Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rotatedImage = ShowingImages.rotateImageByPixels(rotatedImage, 90);
                updateImage();
            }
        });

        rotate180Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rotatedImage = ShowingImages.rotateImageByPixels(rotatedImage, 180);
                updateImage();
            }
        });

        rotateNeg90Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rotatedImage = ShowingImages.rotateImageByPixels(rotatedImage, -90);
                updateImage();
            }
        });


        grayScale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rotatedImage = ShowingImages.grayScaleing(rotatedImage);
                updateImage();
            }
        });

        GreenScale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rotatedImage = ShowingImages.greenScaleing(rotatedImage);
                updateImage();
            }
        });

        randomScale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rotatedImage = ShowingImages.randomScaling(rotatedImage);
                updateImage();
            }
        });

        setVisible(true);
    }

    // Method to update the displayed image
    private void updateImage() {
        imageLabel.setIcon(new ImageIcon(rotatedImage));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String imagePath = "images/balba.png"; // Your specified image path
            new Main(imagePath);
        });
    }
}
