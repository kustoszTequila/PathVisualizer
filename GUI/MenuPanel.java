package GUI;

import Field.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.Flow;

public class MenuPanel extends JPanel implements MouseListener {

    private final int width,height;
    private final BoardPanel boardPanel;
    private JButton resetButton;
    private JButton resizeButton;
    private JButton randomizeButton;
    private JButton bfsButton;
    private JButton dfsButton;
    private JButton astarButton;
    private JButton startButton;
    private JButton stopButton;


    public MenuPanel(int width,int height,BoardPanel boardPanel)
    {
        this.width = width;
        this.height = height;
        this.boardPanel = boardPanel;
        this.setBackground(Color.lightGray);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10,10));
        this.setVisible(true);
        addMouseListener(this);

        resetButton = new JButton("Reset");
        resizeButton = new JButton("Resize");
        randomizeButton = new JButton("Make random walls");
        dfsButton = new JButton("DFS");
        bfsButton = new JButton("BFS");
        astarButton = new JButton("A*");
        resizeButton = new JButton("Resize");
        startButton = new JButton("Start");
    //    stopButton = new JButton("Stop");

        dfsButton.addActionListener(e -> boardPanel.setAlgo(dfsButton.getText()));
        bfsButton.addActionListener(e -> boardPanel.setAlgo(bfsButton.getText()));
        astarButton.addActionListener(e -> boardPanel.setAlgo(astarButton.getText()));


        randomizeButton.addActionListener(e -> boardPanel.randomize());
        resetButton.addActionListener(e -> boardPanel.reset());
        startButton.addActionListener(e -> boardPanel.startAlgo());
        resizeButton.addActionListener(e -> boardPanel.resize());

        this.add(resetButton);
        this.add(resizeButton);
        this.add(randomizeButton);
        this.add(dfsButton);
        this.add(bfsButton);
        this.add(astarButton);
        this.add(startButton);
      //  this.add(stopButton);
    }
    public void setStart(String algo)
    {
        startButton.setText("Start " + algo );
    }
    public void resetStart()
    {
        startButton.setText("Start ");
    }

    @Override
    public void mouseClicked (MouseEvent e)
    {


    }
    @Override
    public void mousePressed (MouseEvent e)
    {

    }
    @Override
    public void mouseReleased (MouseEvent e)
    {

    }
    @Override
    public void mouseEntered(MouseEvent e)
    {

    }
    @Override
    public void mouseExited (MouseEvent e)
    {

    }
}
