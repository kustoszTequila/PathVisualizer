package Algorithms;

import Field.Node;
import GUI.BoardPanel;

import java.util.ArrayList;

public class DFS extends Algo{

    public DFS(BoardPanel boardPanel)
    {
        super(boardPanel);
    }
    public void run()
    {
        dfs();
    }
    public void dfs()
    {
        dfsUtil(board.getNode(startPos));
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
    public void dfsUtil(Node node)
    {
        if (found)
            return;
        node.makeVisited();
        ArrayList<Node> neigh = node.getNeighbours();
        for (int i=0;i<neigh.size();i++)
        {
            Node v = neigh.get(i);
            if (!v.isVisited())
            {
                v.addRoad(node);
                if (v.isEnd())
                {
                    System.out.println("Znaleziono!");
                    v.makeVisited();
                    found = true;
                    break;
                }
                else
                {
                    v.makeProcced();
                    stay(6);
                    if (!paused)
                        dfsUtil(v);

                }
            }
        }
    }
}
