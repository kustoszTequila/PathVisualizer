package Algorithms;

import Field.Board;
import Field.Node;
import Field.Status;
import Field.Vector2d;
import GUI.BoardPanel;
import GUI.NotFound;

public abstract class Algo implements Runnable{
    protected BoardPanel boardPanel;
    protected Vector2d startPos;
    protected Vector2d endPos;
    protected Node endNode;
    protected Node startNode;
    protected Board board;
    protected boolean found = false;
    public boolean paused = false;

    public Algo(BoardPanel boardPanel)
    {
        this.boardPanel = boardPanel;
        board = boardPanel.getBoard();
        startPos = board.getStartPos();
        endPos = board.getEndPos();
        endNode = board.getNode(endPos);
        startNode = board.getNode(startPos);

    }
    public abstract void run();
    public void stay(int delay)
    {
        try
        {
            Thread.sleep(delay);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
    public void pause()
    {
        synchronized(this)
        {
            try
            {
                this.wait();
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
    }
    public void Found()
    {
        boardPanel.menuPanel.resetStart();
        if (!paused)
        {
            boardPanel.changeStatus(Status.FINISHED);

        }

    }
    public void notFound()
    {
        if (!paused)
        {
            NotFound notFound = new NotFound();
            notFound.setVisible(true);
            boardPanel.algo = null;
            boardPanel.menuPanel.resetStart();
        }

    }

}
