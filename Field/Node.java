package Field;

import java.awt.*;
import java.util.ArrayList;

public class Node implements Comparable<Node>{

    private final int row,column,size;
    private final Vector2d position;
    private ArrayList<Node> neighbours;
    private Color color;
    private Node road;
    public double g=Double.POSITIVE_INFINITY;
    public double f=Double.POSITIVE_INFINITY;

    public Node(int row, int column, int size,int total)
    {
        this.row = row;
        this.column = column;
        this.size = size;
        this.position = new Vector2d(column*size,row*size);
        this.neighbours = new ArrayList<Node>();
        this.color = Color.WHITE;
    }
    public Vector2d getPosition()
    {
        return this.position;
    }
    public void addNeighbour(Node node)
    {
        this.neighbours.add(node);
    }
    public ArrayList<Node> getNeighbours()
    {
        return this.neighbours;
    }
    public boolean isStart()
    {
        return this.color == Color.YELLOW;
    }
    public boolean isEnd()
    {
        return this.color == Color.RED;
    }
    public boolean isWall()
    {
        return this.color == Color.blue;
    }
    public boolean isVisited()
    {
        return this.color == Color.CYAN || this.color == Color.YELLOW || this.color == Color.blue || this.color == Color.MAGENTA;
    }
    public void reset()
    {
        this.color = Color.WHITE;
    }
    public void makeStart()
    {
        this.color = Color.YELLOW;
    }
    public void makeEnd()
    {
        this.color = Color.RED;
    }
    public void makeWall()
    {
        this.color = Color.blue;
    }
    public void makeVisited()
    {
        this.color = Color.CYAN;
    }
    public void makeProcced()
    {
        this.color = Color.MAGENTA;
    }
    public void makeRoad()
    {
        this.color = Color.GREEN;
    }
    public Color getColor()
    {
        return this.color;
    }
    public void draw(Graphics2D g2)
    {
        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.gray);
        g2.drawRect(this.position.x,this.position.y,size,size);
        g2.setColor(this.getColor());
        g2.fillRect(this.position.x,this.position.y,size,size);
    }
    public void addRoad(Node node)
    {
        this.road = node;
    }
    public Node getRoad()
    {
        return this.road;
    }
    public void changeColor(int r, int g,int b)
    {
        this.color= new Color(r,g,b);
    }
    @Override
    public int compareTo(Node other) {
        if (this.f> other.f) {
            return 1;
        } else if (this.f< other.f) {
            return -1;
        } else {
            return 0;
        }
    }
}
