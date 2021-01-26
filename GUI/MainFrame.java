package GUI;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    public JFrame StartFrame;
    public BoardPanel boardPanel;
    public MenuPanel menuPanel;
    public JPanel legendPanel;
    public JPanel bottom;
    public JPanel left;

    public MainFrame(int width,int height)
    {
        StartFrame = new JFrame("Welcome to visualizer");
        StartFrame.setMinimumSize(new Dimension(600,600));
        StartFrame .setSize(1000, 800);
        StartFrame .setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StartFrame .setLocationRelativeTo(null);
        StartFrame.setLayout(new BorderLayout());
        StartFrame.setResizable(false);
        int size = Math.min(700/height,745/width);
        boardPanel = new BoardPanel(width,height,size,this);
        menuPanel = new MenuPanel(width,height,boardPanel);
        menuPanel.setPreferredSize(new Dimension(1000,100));
        legendPanel = new JPanel();
        JLabel label = new JLabel();
        ImageIcon image = new ImageIcon( getClass().getResource("legenda.png"));
        label.setIcon(image);
        legendPanel.add(label);
        legendPanel.setBackground(Color.lightGray);
        legendPanel.setVisible(true);
        legendPanel.setPreferredSize(new Dimension(245,480));
        if (660 - size*height >0 )
        {
            JPanel bottom = new JPanel();
            bottom.setBackground(Color.RED);
            if (660 - size*height <190)
            {
                bottom.setPreferredSize(new Dimension(700,660 - (size)*height));
            }
            else
            {
                bottom.setPreferredSize(new Dimension(700,190));
            }
            StartFrame.add(bottom,BorderLayout.SOUTH);
        }
        if ( 745 - size*width > 0)
        {
            JPanel left = new JPanel();
            left.setPreferredSize(new Dimension(745-width*size,700));
            left.setBackground(Color.YELLOW);
            StartFrame.add(left,BorderLayout.WEST);
        }

        StartFrame.add(menuPanel,BorderLayout.NORTH);
        StartFrame.add(legendPanel,BorderLayout.EAST);
        StartFrame.add(boardPanel,BorderLayout.CENTER);
        StartFrame.setVisible(true);
        boardPanel.start();


    }
    public void resize(int width,int height)
    {



    }

}
