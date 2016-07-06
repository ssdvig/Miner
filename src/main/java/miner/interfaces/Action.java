package miner.interfaces;

/**
 * Created by dvig1 on 01.07.2016.
 */
public interface Action {
    void init();
    void select(int x, int y, boolean bomb);
}
