import java.util.ArrayList;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class PictureLoader {

    public static ArrayList<BufferedImage> callimage(ArrayList<PictureData> picdata){         //This is where the pictures are loaded into the program for display
        try {
            ArrayList<BufferedImage> buffimage = new ArrayList<BufferedImage>();
            for (PictureData pic : picdata) {
                BufferedImage image = ImageIO.read(new File(pic.getPicturename()));
                buffimage.add(image);     
            }
            return buffimage;
        } catch (Exception ex) {
            return null;
        }
    }
    
}