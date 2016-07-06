package miner.classes.logic;

import miner.interfaces.Cell;
import miner.interfaces.Logic;

/**
 * Created by dvig1 on 29.06.2016.
 * The class describes the logic of the game. Implement interface Logic
 */
public class Level1 implements Logic {
    private Cell[][] cells;

    public void loadBoard(Cell[][] cells) {
        this.cells = cells;

    }
    /**
     * Check the cell should bang or not
     *
     * @return true if the cell should bang
     */
    public boolean shouldBang(int x, int y) {
        Cell selected = this.cells[x][y];
        return selected.isBomb() && !(selected.isMarkBomb());
    }

    /**
     * Check the game finished or not
     *
     * @return true if the game was finished
     */
    public boolean finish() {
        boolean result = true;
        for (Cell[] row:this.cells) {
            if (!result) {
                break;
            }
            for (Cell cell:row) {
                result = !(cell.isBomb() && !cell.isMarkBomb());
                if (!result) {
                    break;
                }
            }
        }
        return result;
    }
    /**
     * Open or mark the cell
     *
     * @return
     */
    public void mark(int x, int y, boolean rightButton) {
        if (rightButton){
            this.cells[x][y].markBomb();
        }else{
            this.cells[x][y].setOpen();
        }
    }
}
