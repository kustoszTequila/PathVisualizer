package Algorithms;

import Field.Node;
import GUI.BoardPanel;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Astar extends Algo{


    public Astar(BoardPanel boardPanel)
    {
        super(boardPanel);
        startNode.g = 0;
        startNode.f = h(startNode,endNode);;
    }
    public void run()
    {
        astar();

    }
    public void astar()
    {
        Queue<Node> openSet = new PriorityQueue<Node>();
        openSet.add(startNode);

        while (openSet.size() > 0 && !found  && !paused)
        {
            Node node = openSet.poll();


            if ( node.isEnd())
            {
                System.out.println("Znaleziono!");
                node.makeVisited();
                found = true;
                break;
            }
            node.makeProcced();
            ArrayList<Node> neigh = node.getNeighbours();
            for (int i=0;i<neigh.size();i++)
            {
                if (!neigh.get(i).isVisited())
                {
                    Node neighbour = neigh.get(i);
                    double tempG = node.g +1;

                    if (tempG < neighbour.g)
                    {
                        neighbour.addRoad(node);
                        neighbour.g = tempG;
                        neighbour.f = tempG+ h(neighbour,endNode);
                        openSet.add(neighbour);
                    }
                }

            }
            stay(20);
            node.makeVisited();

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
    public double h(Node n1, Node n2)
    {
        return Math.abs(n2.getPosition().x-n1.getPosition().x) + Math.abs(n2.getPosition().y-n1.getPosition().y);
    }
}
