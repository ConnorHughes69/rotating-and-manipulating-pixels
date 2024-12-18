import java.awt.image.BufferedImage;

public class ShowingImages {

    public static BufferedImage rotateImageByPixels(BufferedImage image, int angle) {
        int width = image.getWidth();
        int height = image.getHeight();
        int[][] pixelArray = new int[width][height];

        // Store pixel data into a 2D array
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixelArray[x][y] = image.getRGB(x, y);
            }
        }

        BufferedImage newImage;
        if (angle == 90 || angle == -90) {
            newImage = new BufferedImage(height, width, image.getType());
        } else {
            newImage = new BufferedImage(width, height, image.getType());
        }

        // Rotate pixels based on the angle
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (angle == 90) {
                    newImage.setRGB(height - y - 1, x, pixelArray[x][y]);
                } else if (angle == -90) {
                    newImage.setRGB(y, width - x - 1, pixelArray[x][y]);
                } else if (angle == 180) {
                    newImage.setRGB(width - x - 1, height - y - 1, pixelArray[x][y]);
                }
            }
        }

        return newImage;
    }

    public static BufferedImage grayScaleing(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        // Create a 2D array to store pixel data
        int[][] grayPixels = new int[width][height];

        // Create a new grayscale image
        BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                // Get the RGB color of the current pixel
                int rgb = image.getRGB(x, y);

                // Extract color components
                int red = (rgb >> 16) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = rgb & 0xFF;

                // Calculate the grayscale value using the luminance formula
                int gray = (int) (0.299 * red + 0.587 * green + 0.114 * blue);

                // Create the new grayscale color with the same alpha value
                int alpha = (rgb >> 24) & 0xFF;
                grayPixels[x][y] = (alpha << 24) | (gray << 16) | (gray << 8) | gray;
            }
        }

        // Apply the 2D array to the new image
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                grayImage.setRGB(x, y, grayPixels[x][y]);
            }
        }

        return grayImage;
    }

    public static BufferedImage greenScaleing(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        // Create a 2D array to store pixel data
        int[][] greenPixels = new int[width][height];

        // Create a new greenscale image
        BufferedImage greenImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                // Get the RGB color of the current pixel
                int rgb = image.getRGB(x, y);

                // Extract the green component
                int green = (rgb >> 8) & 0xFF;

                // Preserve the alpha channel
                int alpha = (rgb >> 24) & 0xFF;

                // Create a new color using only the green component
                greenPixels[x][y] = (alpha << 24) | (0 << 16) | (green << 8) | 0;
            }
        }

        // Apply the 2D array to the new image
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                greenImage.setRGB(x, y, greenPixels[x][y]);
            }
        }

        return greenImage;
    }

    public static BufferedImage randomScaling(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        // Create a 2D array to store pixel data
        int[][] randomPixels = new int[width][height];

        // Create a new random-scaled image
        BufferedImage randomImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                // Get the RGB color of the current pixel
                int rgb = image.getRGB(x, y);

                // Extract the green component (shifted for randomness)
                int green = (rgb >> 13) & 0xFF;

                // Preserve the alpha channel (shifted for randomness)
                int alpha = (rgb >> 9) & 0xFF;

                // Create a new color using manipulated components
                randomPixels[x][y] = (alpha << 24) | (0 << 16) | (green << 8) | 0;
            }
        }

        // Apply the 2D array to the new image
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                randomImage.setRGB(x, y, randomPixels[x][y]);
            }
        }

        return randomImage;
    }
}
