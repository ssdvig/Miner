package miner.classes;

import miner.interfaces.Board;
import miner.interfaces.Cell;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dvig1 on 29.06.2016.
 * Draw Board and cells
 */
public class UBoard extends JPanel implements Board {
    public static final int FIELD_SIZE = 50;
    private boolean boom = false;
    private Cell<Graphics>[][] cells;

    @Override
    protected void paintComponent(Graphics g){
        //The first we have to call the method of the parent class
        super.paintComponent(g);
            if (cells != null) {
                for (int x = 0; x != cells.length; x++) {
                    for (int y = 0; y != cells[x].length; y++) {
                        cells[x][y].draw(g, boom);
                    }
                }
            }
    }

    public void drowBoard(Cell[][] cells) {
        this.cells = cells;
        this.boom = false;
        this.repaint();
    }

    public void drowCell(int x, int y) {
        this.repaint();

    }

    public void drowBoom() {
        this.boom = true;
        this.repaint();

    }

}
