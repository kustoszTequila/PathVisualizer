package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResizeWindow implements ActionListener {

    private BoardPanel boardPanel;
    private JFrame resizeFrame;
    private MainFrame mainFrame;
    private JPanel resizePanel;
    private JLabel widthLabel;
    private JLabel heightLabel;

    private JTextField widthText;
    private JTextField heightText;
    private Integer[] defaultValues = new Integer[]{40,30};
    private int numOfColumns = 2;

    private JButton resizeButton;

    public ResizeWindow(BoardPanel boardPanel)

    {
        this.boardPanel = boardPanel;
        mainFrame = boardPanel.getFrame();
        resizeFrame = new JFrame("Resize");
        resizeFrame.setSize(200,200);
        resizeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        resizeFrame.setVisible(true);

        resizePanel = new JPanel();
        resizePanel.setPreferredSize(new Dimension(200,200));
        resizePanel.setLayout(new BoxLayout(resizePanel,BoxLayout.Y_AXIS));
        resizePanel.setVisible(true);

        resizeFrame.add(resizePanel);

        widthLabel = new JLabel("Width of the map:  ");
        heightLabel = new JLabel("Height of the map:    ");

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

        resizePanel.add(p1);
        resizePanel.add(p2);

        resizeButton = new JButton("Resize");
        resizeButton.addActionListener(this);
        resizePanel.add(resizeButton);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == resizeButton)
        {

            int width = Integer.parseInt(widthText.getText());
            int height = Integer.parseInt(heightText.getText());
            int size = Math.min(700/height,745/width);
            if (700 - size*height >0) {
               // mainFrame.bottom = new JPanel();
                if (mainFrame.bottom != null)
                {
                    System.out.println("resajzuje dol");
                    mainFrame.bottom.setPreferredSize(new Dimension(700, 700 - size * height));
                    mainFrame.bottom.setBackground(Color.RED);
                    mainFrame.StartFrame.add(mainFrame.bottom,BorderLayout.SOUTH);
                }

            }
            if ( 745 - size*width > 0)
            {
               // mainFrame.left = new JPanel();
                if (mainFrame.left != null)
                {
                    System.out.println("resajzuje l");
                    mainFrame.left.setPreferredSize(new Dimension(745-width*size,700));
                    mainFrame.left.setBackground(Color.YELLOW);
                    mainFrame.StartFrame.add(mainFrame.left,BorderLayout.WEST);
                }

            }
           /* if (width/5*15 < 40 )
            {
                width = 40;
            }
            if(height/10 * 15 < 20)
            {
                height = 1;
            }*/
            //mainFrame. StartFrame .setSize((width+16)*15, (height+5)*15);
            //mainFrame.boardPanel.setSize(new Dimension(width,height));

            //mainFrame.menuPanel.setSize(new Dimension(width/5*15,height/10*15));
            boardPanel.newBoard(width,height,size);
            mainFrame = new MainFrame(width,height);
            this.resizeFrame.dispose();
        }
    }
}
