package GUI;

import javax.swing.*;

public class NotFound extends JFrame {
        private JPanel panel;
        private JLabel label;


        public NotFound()
        {
            this.setSize(150, 100);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setLocationRelativeTo(null);
            panel = new JPanel();
            label = new JLabel("Nie znaleziono ścieżki!");
            panel.add(label);
            this.add(panel);
        }
}
