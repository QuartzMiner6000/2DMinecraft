package com.quartzy.mc.gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class ImageLoader {

    public static BufferedImage loadImage(String path){
        try {
            File file = new File(ImageLoader.class.getProtectionDomain().getCodeSource().getLocation().toURI());
            File input = new File(file.getAbsolutePath() + "/data/textures" + path);
            return ImageIO.read(input);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

}
