import java.awt.*;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable()
    {
        @Override
        public void run()
        {
            MyFrame frame = new MyFrame();
            ButtonListener listener = new ButtonListener();

            frame.setLayout(new GridLayout(2,1));
            frame.add(listener.getPanelTekst());
            frame.add(listener.getPanelPlusMinus());
            frame.revalidate();
        }
    });

    }
}
