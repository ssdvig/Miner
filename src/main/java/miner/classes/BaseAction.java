package miner.classes;

import miner.interfaces.*;

/**
 * Created by dvig1 on 01.07.2016.
 * It describes base actions of the Game: initialisation and select cell by user
 * Implement Action interface
 */
public class BaseAction implements Action{
    private final GeneratorBoard generator;
    private final Board board;
    private final Logic logic;

    public BaseAction(GeneratorBoard generator, Board board, Logic logic) {
        this.generator = generator;
        this.board = board;
        this.logic = logic;
    }

    public void init() {
        Cell[][] cells = generator.generate();
        this.board.drowBoard(cells);
        this.logic.loadBoard(cells);

    }

    public void select(int x, int y, boolean rightButton) {
        this.logic.mark(x, y, rightButton);
        this.board.drowCell(x, y);
        if (this.logic.shouldBang(x, y)) {
            this.board.drowBoom();
        }
    }
}
