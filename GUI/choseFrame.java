package GUI;

import javax.swing.*;

public class choseFrame extends JFrame{
        private JPanel panel;
        private JLabel label;


    public choseFrame(){
        this.setSize(150, 100);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        panel = new JPanel();
        label = new JLabel("Proszę wybrać algorytm");
        panel.add(label);
        this.add(panel);    }
}