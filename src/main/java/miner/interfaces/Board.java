package miner.interfaces;

/**
 * Created by dvig1 on 29.06.2016.
 * It describes methods of the board;
 */
public interface Board {
    void drowBoard(Cell[][] cells);
    void drowCell(int x, int y);
    void drowBoom();
}
