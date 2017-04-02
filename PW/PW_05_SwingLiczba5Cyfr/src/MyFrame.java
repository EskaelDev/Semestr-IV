import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tomek on 02.04.2017.
 */
public class MyFrame extends JFrame {
    public MyFrame() {
        super("5 cyfr");//Nazwa okna
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int Width = (int)(screenSize.width*0.25);
        int Height = (int)(screenSize.height*0.25);
        int x = (int) (screenSize.width/2-Width/2);
        int y = (int) (screenSize.height/2-Height/2);
        // ważne
        getContentPane().setBackground(new Color(19,24,36));
        // ważne
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Width, Height);
        setLocation(x, y);
        setResizable(true);
        setVisible(true);
    }

}
