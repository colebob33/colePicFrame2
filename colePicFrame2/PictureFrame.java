import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.image.BufferedImage;
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PictureFrame extends JFrame{
    ArrayList<PictureData> picturedata = PictureDataReader.readPictureDataFromFile("descriptions.txt");
    ArrayList<BufferedImage> callimage = PictureLoader.callimage(picturedata);
    int currentIndex = 0;
    private PicturePanel newpanel;
    private JTextField picturedate;
    private JTextArea picturedescription;
    PictureData pictureinfo = picturedata.get(currentIndex);

    public void getpicdata(int currentIndex){
        PictureData pictureinfo = picturedata.get(currentIndex);
        picturedate.setText(pictureinfo.getPicturedate());
        picturedescription.setText(pictureinfo.getPicturedescription());           //Tutor was a big guidance here 

    }public void savetofile(String date, String description){
        picturedata.get(currentIndex).setPicturedate(date);
        picturedata.get(currentIndex).setPicturedescription(description);

    }public void pictures(int currentIndex){
        newpanel.setPicture(callimage.get(currentIndex));
        getpicdata(currentIndex);
    }

    public void setupMainMenu(){
        JMenuBar mbar = new JMenuBar();
        JMenu mnuFile = new JMenu("File");
        JMenu mnuHelp = new JMenu("Help");
        mbar.add(mnuFile);
        mbar.add(mnuHelp);                                                  //Sarah and Paula helped me here while following your notes
        JMenuItem miSave = new JMenuItem("Save");
        JMenuItem miExit = new JMenuItem("Exit");
        mnuFile.add(miSave);
        miSave.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                savetofile(picturedate.getText(), picturedescription.getText());
            }
        }
        );
        mnuFile.add(miExit);
        miExit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);}
        });
        JMenuItem miAbout = new JMenuItem("About");
        miAbout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Created by Colton Elmore in December 2021");
            }
        });
        mnuHelp.add(miAbout);
        setJMenuBar(mbar);
    }

    public void setupGUI(){
        setTitle("Picture Frame");
        setBounds(100,100,290,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setupMainMenu();
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        JPanel mainscreenpanel = new JPanel();
        mainscreenpanel.setLayout(new BorderLayout());
        JPanel panSouth = new JPanel();
        panSouth.setLayout(new FlowLayout());
        JButton previousbutton = new JButton("Prev");         
        JButton savebutton = new JButton("Save");
        JButton nextbutton = new JButton("Next");
        panSouth.add(previousbutton);
        panSouth.add(savebutton);           //Sarah Breslin and outside source Jake Filotto tried to help me here without just giving me the correct code for the button assignments to work
        panSouth.add(nextbutton);                        
        
        newpanel = new PicturePanel();
        c.add(newpanel,BorderLayout.NORTH);
        c.add(mainscreenpanel,BorderLayout.CENTER);
        picturedate = new JTextField(20);
        picturedescription = new JTextArea(1,1);
        picturedescription.setLineWrap(true);
        mainscreenpanel.add(picturedate,BorderLayout.NORTH);
        mainscreenpanel.add(picturedescription,BorderLayout.CENTER);
        mainscreenpanel.add(panSouth,BorderLayout.SOUTH);

    }
    
    public PictureFrame(){
        setupGUI();
        pictures(currentIndex);
    }

}