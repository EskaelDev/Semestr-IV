import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import static javax.swing.JOptionPane.showMessageDialog;

/**
 * Created by tomek on 02.04.2017.
 */
public class ButtonListener implements ActionListener {

    JPanel panelPlusMinus, panelTekst;
    JLabel field;
    int[] liczby;
    JButton[] buttons;
    JTextField[] textField;
    JTextField textBlank;
    Object clear;

    public ButtonListener() {
        panelPlusMinus = new JPanel();
        panelTekst = new JPanel();
        panelPlusMinus.setLayout(new GridLayout(2, 6));
        panelTekst.setLayout(new GridLayout(1, 6));

        textBlank = new JTextField();

        liczby = new int[5];
        textField = new JTextField[5];
        Border emptyBorder = BorderFactory.createEmptyBorder();

        for (int i = 0; i < 5; i++) {
            liczby[i] = 0;
            textField[i] = new JTextField();
            textField[i].setHorizontalAlignment(SwingConstants.CENTER);
            textField[i].setText(Integer.toString(liczby[i]));
            textField[i].setEditable(false);
            textField[i].setBackground(new Color(19, 39, 60));
            textField[i].setForeground(new Color(188, 238, 177));
            textField[i].setBorder(emptyBorder);


            panelTekst.add(textField[i], BorderLayout.CENTER);

        }
        textBlank.setBackground(new Color(19, 39, 60));

        textBlank.setBorder(emptyBorder);
        panelTekst.add(textBlank);

        buttons = new JButton[12];
        for (int i = 0; i < 5; i++)
            buttons[i] = new JButton("+");

        for (int i = 6; i < 11; i++)
            buttons[i] = new JButton("-");


        buttons[5] = new JButton("Reset");
        buttons[11] = new JButton("Suma");

        panelTekst.setOpaque(false);
        //panelTekst.setBackground(new Color(19,24,36));


        for (int i = 0; i < 12; i++) {
            buttons[i].addActionListener(this);
            panelPlusMinus.add(buttons[i]);
            buttons[i].setBackground(new Color(20, 52, 91));
            buttons[i].setForeground(new Color(188, 238, 177));
        }


    }


    public JPanel getPanelPlusMinus() {
        return panelPlusMinus;
    }

    public JPanel getPanelTekst() {
        return panelTekst;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton ButtonPressed = (JButton) e.getSource();
        if (ButtonPressed == buttons[5])
            for (int i = 0; i < 5; i++)
                liczby[i] = 0;
        if (ButtonPressed == buttons[11]) {
            int suma = 0;
            for (int i = 0; i < 5; i++)
                suma += liczby[i];
            showMessageDialog(null, Integer.toString(suma));
        } else {
            for (int i = 0; i < 5; i++)
                if (ButtonPressed == buttons[i]) {
                if(liczby[i]<9)
                    liczby[i]++;
                }

            for (int i = 6; i < 11; i++)
                if (ButtonPressed == buttons[i]) {
                    if(liczby[i-6]>0)
                        liczby[i-6]--;
                }

        }
        for (int i = 0; i < 5; i++)
        textField[i].setText(Integer.toString(liczby[i]));
    }
}
