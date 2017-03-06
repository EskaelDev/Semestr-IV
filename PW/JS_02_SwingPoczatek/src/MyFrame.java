import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame(){
        super("Not Hello World");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(1920/2,1080/2-300);
        setSize(400,400);
        setLayout(new GridLayout(3, 3));
        //setResizable(false);

        for(int i = 0; i<9;i++)
            add(new JButton(""+(i+1)));

    }
}