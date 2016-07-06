package miner.classes;

import miner.interfaces.Cell;

import java.awt.*;
import static miner.classes.UBoard.FIELD_SIZE;

/**
 * Created by dvig1 on 29.06.2016.
 * This class describes operations of cell. Implements interface Cell.
 */
public class UCell implements Cell<Graphics> {
    private boolean bomb;
    private boolean markBomb;
    private boolean open;


    private int x;
    private int y;

    public UCell(int x, int y, boolean bomb){
        this.bomb = bomb;
        this.x = x;
        this.y = y;
    }


    public boolean isBomb() {
        return this.bomb;
    }

    public boolean isOpen(){
        return this.open;
    }

    public void setOpen(){
        this.open = true;
    }

    public boolean isMarkBomb() {
        return this.markBomb;
    }

    public void markBomb() {
        this.markBomb = true;

    }
    /**
     * Draw the cell in depending of the conditions
     *
     * @return
     */
    public void draw(Graphics paint, boolean boom) {
        if (boom){
            if (isBomb()){
                drawBomb(this.x, this.y, paint);
            }else  drawOpenCell(this.x, this.y, paint);
        }else {
            if (isOpen()) {
                if (isBomb()) {
                    drawBomb(this.x, this.y, paint);
                } else {
                    drawOpenCell(this.x, this.y, paint);
                }
            } else {
                if (isMarkBomb()) {
                    drawFlag(this.x, this.y, paint);
                } else {
                    drawEmptyCell(this.x, this.y, paint);
                }
            }
        }
    }

    private void drawFlag(int x, int y, Graphics g) {
        this.drawEmptyCell(x,y,g);
        g.setColor(Color.pink);
        g.drawString("√", x*FIELD_SIZE+FIELD_SIZE/2, y*FIELD_SIZE+FIELD_SIZE/2);
    }
    private void drawBomb(int x, int y, Graphics g){
        this.drawEmptyCell(x,y,g);
        g.setColor(Color.red);
        g.drawString("*",x*FIELD_SIZE+FIELD_SIZE/2,y*FIELD_SIZE+FIELD_SIZE/2);
}
    private void drawEmptyCell(int x, int y, Graphics g){
        g.setColor(Color.white);
        g.fillRect(x*FIELD_SIZE,y*FIELD_SIZE,FIELD_SIZE,FIELD_SIZE);
        g.setColor(Color.black);
        g.drawRect(x*FIELD_SIZE,y*FIELD_SIZE,FIELD_SIZE,FIELD_SIZE);
    }

    private void drawOpenCell(int x, int y, Graphics g){
        g.setColor(Color.blue);
        g.fillRect(x*FIELD_SIZE,y*FIELD_SIZE,FIELD_SIZE,FIELD_SIZE);
        g.setColor(Color.black);
        g.drawRect(x*FIELD_SIZE,y*FIELD_SIZE,FIELD_SIZE,FIELD_SIZE);
    }
}
