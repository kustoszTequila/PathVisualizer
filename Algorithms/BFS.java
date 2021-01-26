package Algorithms;

import Field.Board;
import Field.Node;
import Field.Vector2d;
import GUI.BoardPanel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class BFS extends Algo{


    public BFS (BoardPanel boardPanel)
    {
        super(boardPanel);
    }
    public void run()
    {
        bfs();
    }
    public void  bfs()
    {
        Node node = board.getNode(startPos);
        LinkedList<Node> queue = new LinkedList<Node>();
        node.makeVisited();

        queue.add(node);

        while (queue.size() >= 1 && !found && !paused)
        {

            Node v = queue.pop();
            v.makeVisited();
            if (v.isEnd())
            {
                System.out.println("Znaleziono!");
                v.makeVisited();
                found = true;
                break;
            }
            ArrayList<Node> neigh = v.getNeighbours();
            for (int i=0;i<neigh.size();i++)
            {
                Node u = neigh.get(i);
                if (u.isVisited() == false)
                {
                    u.addRoad(v);
                    if (u.isEnd())
                    {
                        System.out.println("Znaleziono!");
                        v.makeVisited();
                        found = true;
                        break;
                    }
                    u.makeProcced();
                    queue.add(u);
                }

            }
            stay(8);

        }
        Found();
        if (found)
        {
            board.visit();
            board.drawRoad();


        }
        else
        {
            notFound();
        }
    }
}
