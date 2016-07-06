package miner.interfaces;

/**
 * Created by dvig1 on 29.06.2016.
 * It describes the operations of the cell
 */
public interface Cell<T> {
    boolean isBomb();
    boolean isMarkBomb();
    boolean isOpen();
    void markBomb();
    void setOpen();
    void draw(T paint, boolean left);
}
