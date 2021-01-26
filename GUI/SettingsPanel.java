package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsPanel extends JPanel implements ActionListener {

    private int width,height;

    private JLabel widthLabel;
    private JLabel heightLabel;

    private JTextField widthText;
    private JTextField heightText;

    private JButton playButton;

    private Integer[] defaultValues = new Integer[]{40,30};
    private int numOfColumns = 2;

    private MainFrame mainFrame;

    public SettingsPanel (int width,int height)
    {
        this.width = width;
        this.height = height;

        this.setPreferredSize(new Dimension(width,height));
        this.setBackground(Color.lightGray);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10,10));
        this.setVisible(true);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        widthLabel = new JLabel("Width of the map (number of nodes):  ");
        heightLabel = new JLabel("Height of the map (number of nodes):    ");

        widthLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        heightLabel.setFont(new Font("Serif", Font.PLAIN, 20));

        widthText = new JTextField();
        widthText.setColumns(numOfColumns);
        heightText = new JTextField();
        heightText.setColumns(numOfColumns);
        widthLabel.setLabelFor(widthText);
        heightLabel.setLabelFor(heightText);
        widthText.setText(defaultValues[0].toString());
        heightText.setText(defaultValues[1].toString());
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        p1.add(widthLabel);
        p1.add(widthText);
        p2.add(heightLabel);
        p2.add(heightText);
        this.add(p1);
        this.add(p2);
        playButton = new JButton("Play Visualizer");
        playButton.addActionListener(this);
        JPanel playButtonPanel = new JPanel();
        playButtonPanel.add(playButton);
        this.add(playButtonPanel);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == playButton)
        {
            mainFrame= new MainFrame(Integer.parseInt(widthText.getText()),
                    Integer.parseInt(heightText.getText()));
        }
    }
}
