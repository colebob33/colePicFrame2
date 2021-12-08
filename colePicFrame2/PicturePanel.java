import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;



public class PicturePanel extends JPanel implements MouseListener, MouseMotionListener{
    private ArrayList<PictureData> picturedata;
    private String position;
    private int xcoord, ycoord;
    private BufferedImage picture;
    public PicturePanel(){
        setPreferredSize(new Dimension(200,200));
        position = "(x=0, y=0)";
        addMouseListener(this);
        addMouseMotionListener(this);
        xcoord = 1;
        ycoord = 10;
        picturedata = new ArrayList<PictureData>();
    }

    public void setPicture(BufferedImage picture){
        this.picture = picture;
        repaint();
     }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(picture,0,0,null);
        g.drawString(position, xcoord, ycoord);
    }

    public void mouseClicked(MouseEvent e){
        position = String.format("(x=%d, y=%d)", e.getX(), e.getY());
        xcoord = e.getX();
        ycoord = e.getY();
        repaint();
    }public void mousePressed(MouseEvent e){
    
    }public void mouseReleased(MouseEvent e){
    
    }public void mouseEntered(MouseEvent e){

    }public void mouseExited(MouseEvent e){

    }public void mouseMoved(MouseEvent e){

    }public void mouseDragged(MouseEvent e){

    }public ArrayList<PictureData> getPictureData() {
        return picturedata;
    }public void setDots(ArrayList<PictureData> picturedata) {
        this.picturedata = picturedata;
    }
    
}