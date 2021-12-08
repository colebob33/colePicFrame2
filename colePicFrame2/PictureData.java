public class PictureData {
    private String picturename, picturedate, picturedescription;
    
    public String getPicturename() {
        return picturename;
    }public void setPictureName(String picturename) {                                     //All of PictureData was a review from previous assignments.... no problems
        this.picturename = picturename;
    }
    public String getPicturedate() {
        return picturedate;
    }public void setPicturedate(String picturedate) {
        this.picturedate = picturedate;
    }
    public String getPicturedescription() {
        return picturedescription;
    }public void setPicturedescription(String picturedescription) {
        this.picturedescription = picturedescription;
    }

    public PictureData(String picturename, String picturedate, String picturedescription) {
        this.picturename = picturename;
        this.picturedate = picturedate;
        this.picturedescription = picturedescription;
    }


    public String toString() {
        return String.format("%d %d %d", picturename, picturedate, picturedescription);
    }
    
}