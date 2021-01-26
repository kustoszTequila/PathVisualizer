package GUI;

import Algorithms.Algo;
import Algorithms.Astar;
import Algorithms.BFS;
import Algorithms.DFS;
import Field.Board;
import Field.Node;
import Field.Status;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Map;

public class BoardPanel extends JPanel implements MouseListener,ActionListener, MouseMotionListener {
        private Board board;
        private int size;
        private int width;
        private int height;
        private Timer timer;
        public Algo algo;
        private Thread t;
        private Status status;
        private boolean paused = false;
        private MainFrame mainFrame;
        public MenuPanel menuPanel;

        public BoardPanel(int width, int height, int size, MainFrame mf) {

                this.width = width;
                this.height = height;
                this.size =size;
                this.mainFrame = mf;
                this.status = Status.PAINTING;
                board = new Board(width, height, size, this);

                this.setBackground(Color.darkGray);
                this.setVisible(true);
                addMouseListener(this);
                addMouseMotionListener(this);

        }

        public void start() {
                this.menuPanel=mainFrame.menuPanel;
                timer = new Timer(10, this);
                timer.start();
        }

        @Override
        public void paint(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                board.draw(g2);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
                if (status == Status.PAINTING) {
                        if (SwingUtilities.isLeftMouseButton(e)) {

                                int x = e.getX();
                                int y = e.getY();
                                Node node = board.getNodeOnClick(x, y);
                                if (node == null) {
                                        System.out.println("nie można tu postawić ściany");
                                } else {
                                        node.makeWall();
                                }

                        } else if (SwingUtilities.isRightMouseButton(e)) {
                                int x = e.getX();
                                int y = e.getY();
                                Node node = board.getNodeOnClick(x, y);
                                if (node == null) {
                                        System.out.println("nie można tu postawić ściany debilu");
                                } else {
                                        node.reset();
                                }
                        }
                }

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }

        @Override
        public void mouseClicked(MouseEvent e) {


        }

        @Override
        public void mousePressed(MouseEvent e) {
                if (status == Status.PAINTING) {
                        if (SwingUtilities.isLeftMouseButton(e)) {
                                int x = e.getX();
                                int y = e.getY();
                                Node node = board.getNodeOnClick(x, y);
                                if (node == null) {
                                        System.out.println("nie można tu postawić ściany debilu");
                                } else {
                                        node.makeWall();
                                }
                        } else if (SwingUtilities.isRightMouseButton(e)) {
                                int x = e.getX();
                                int y = e.getY();
                                Node node = board.getNodeOnClick(x, y);
                                if (node == null) {
                                        System.out.println("nie można tu postawić ściany debilu");
                                } else {
                                        node.reset();
                                }
                        }

                }


        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
                repaint();
        }

        public Board getBoard() {
                return this.board;
        }

        public void setAlgo(String algo) {

                if (algo.equals("DFS")) {

                        this.algo = new DFS(this);
                        menuPanel.setStart("DFS");
                } else if (algo.equals("BFS")) {
                        this.algo = new BFS(this);
                        menuPanel.setStart("BFS");
                } else if (algo.equals("A*")) {

                        this.algo = new Astar(this);
                        menuPanel.setStart("A*");
                }
        }

        public void startAlgo() {
                if (algo == null)
                {
                        choseFrame cframe = new choseFrame();
                        cframe.setVisible(true);
                }

                else if (this.algo != null && this.status == Status.PAINTING) {

                        status = Status.SEARCHING;
                        t = new Thread(algo);
                        t.start();


                }

        }

        public void changeStatus(Status status) {
                this.status = status;
        }

        public void reset() {

                        t = null;
                        if (algo != null)
                        algo.paused = true;
                        algo = null;
                        this.board = new Board(width, height, size, this);
                        this.status = Status.PAINTING;



        }

        public void randomize() {
                if (status == Status.PAINTING) {
                        board.randomWalls(25);
                }
        }

        public void resize()
        {
                ResizeWindow resWin = new ResizeWindow(this);

        }
        public MainFrame getFrame()
        {
                return this.mainFrame;
        }
        public void newBoard(int width,int height,int size)
        {
                board = new Board(width,height,size,this);
                repaint();
        }


}
