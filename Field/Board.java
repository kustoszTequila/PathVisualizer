package Field;

import Algorithms.BFS;
import GUI.BoardPanel;

import java.awt.*;
import java.util.ArrayList;

public class Board {

    private final int width,height;
    public Node[][] board;
    private final int size ;
    private Vector2d startPos;
    private Vector2d endPos;
    private BoardPanel boardPanel;

    public Board(int width, int height,int size,BoardPanel boardPanel)

    {
        this.boardPanel = boardPanel;
        this.width = width;
        this.height = height;
        this.size = size;
        board = new Node[height][width];
        for (int i =0;i<height;i++)
        {
            for (int j =0;j<width;j++)
            {
                board[i][j] = new Node(i,j,size,i*j);
            }
        }
        setStartEnd();
        addNeighbours();;

    }
    public void setStartEnd()
    {
        board[height/2][width/4].makeStart();
        board[height/2][width*3/4].makeEnd();
        startPos = new Vector2d(width/4,height/2);
        endPos = new Vector2d(width*3/4,height/2);
    }
    public void addNeighbours()
    {
        for (int i =0;i<height;i++)
        {
            for (int j =0;j<width;j++)
            {
                Node node = board[i][j];
                if (i-1 >=0)
                {
                    node.addNeighbour(board[i-1][j]);
                }
                if (j-1>=0)
                {
                    node.addNeighbour(board[i][j-1]);
                }
                if(i+1<height)
                {
                    node.addNeighbour(board[i+1][j]);
                }
                if(j+1<width)
                {
                    node.addNeighbour(board[i][j+1]);
                }

            }
        }
    }
    public Node getNode(int x,int y)
    {
        return board[y][x];
    }
    public Node getNode(Vector2d vector)
    {
        return board[vector.y][vector.x];
    }
    public void  draw(Graphics2D g2)
    {
        for (int i =0;i<height;i++)
        {
            for (int j =0;j<width;j++)
            {
                board[i][j].draw(g2);
            }
        }
        Vector2d pos = board[startPos.y][startPos.x].getPosition();
        g2.setColor(Color.YELLOW);
        g2.fillOval(pos.x, pos.y,size,size);
        pos = board[endPos.y][endPos.x].getPosition();
        g2.setColor(Color.RED);
        g2.fillOval(pos.x, pos.y,size,size);
    }
    public Node getNodeOnClick(int x, int y)
    {
        x = (int) (x/size);
        y = (int) (y/size);
        if (y <=height && x <=width)
            if (board[y][x].getColor() != Color.YELLOW && board[y][x].getColor() != Color.RED)
                return board[y][x];
            else
                return null;
        else
            return null;
    }
    public Vector2d getStartPos()
    {
        return startPos;
    }
    public Vector2d getEndPos()
    {
        return endPos;
    }
    public BoardPanel getBoardPanel()
    {
        return this.boardPanel;
    }
    public void drawRoad()
    {
        int i = 80;
        Node node = this.getNode(endPos);
        while (node.getRoad() != null)
        {

            node.changeColor(i/10,i ,i/10);
            node = node.getRoad();
            try
            {
                Thread.sleep(10);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
            i++;
            i = i %255;
            if (i <80)
                i=80;
        }
        getNode(startPos).changeColor(i/10,i,i/10);
    }
    public void randomWalls(int num)
    {
        int counter = 0;
        int n =0;
        while (n < num)
        {
            counter = 0;
            while (counter < width*height*2)
            {
                int x = (int) (Math.random() * width);
                int y = (int) (Math.random() * height);
                if (!board[y][x].isVisited())
                {
                    board[y][x].makeWall();
                    n++;
                    break;
                }
                counter++;
            }
        }
    }
    public int getWidth()
    {
        return this.width;
    }
    public int getHeight()
    {
        return this.height;
    }
    public void visit()
    {
        for (int i =0;i<height;i++)
        {
            for (int j =0;j<width;j++)
            {
               if( board[i][j].getColor() == Color.MAGENTA)
                   board[i][j].makeVisited();
            }
        }
    }
}
