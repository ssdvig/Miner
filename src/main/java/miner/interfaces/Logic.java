package miner.interfaces;

/**
 * Created by dvig1 on 29.06.2016.
 * It describes the logic of application
 */
public interface Logic {
    void loadBoard(Cell[][] cells);
    boolean shouldBang(int x, int y);
    boolean finish();
    void mark(int x, int y, boolean rightButton);
}
