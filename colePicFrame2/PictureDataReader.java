import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class PictureDataReader {

    public static ArrayList<PictureData> readPictureDataFromFile(String fileread){
        try {
            ArrayList<PictureData> picdata = new ArrayList<PictureData>();
            Scanner sc = new Scanner(new File(fileread));
            String picturename, picturedate, picturedescription;                          //Like PictureData this came as a review and prior knowledge was applied
            String line;
            String[] parts;
            PictureData picturedata;
            while (sc.hasNextLine()) {
                line = sc.nextLine().trim();
                if (line.length()>0) {
                    parts = line.split("\t");
                    picturename = parts[0];
                    picturedate = parts[1];
                    picturedescription = parts[2];
                    picturedata = new PictureData(picturename, picturedate, picturedescription);
                    picdata.add(picturedata);
                }
            } return picdata;
        } catch (Exception ex) {
            return null;
        }
    }
}