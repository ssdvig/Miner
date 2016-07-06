package miner.classes;

import miner.interfaces.Board;
import miner.interfaces.GeneratorBoard;
import miner.interfaces.Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by dvig1 on 01.07.2016.
 * It describes user's actions
 */
public class UAction extends BaseAction implements ActionListener, MouseListener {
    public UAction(GeneratorBoard generator, UBoard board, Logic logic) {
        super(generator, board, logic);
        board.addMouseListener(this);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        this.init();
    }

    public void mouseClicked(MouseEvent mouseEvent) {
        int X = mouseEvent.getX();
        int Y = mouseEvent.getY();
        int buttonID = mouseEvent.getButton();
        this.select(X/50, Y/50, buttonID !=1);
    }

    public void mousePressed(MouseEvent mouseEvent) {

    }

    public void mouseReleased(MouseEvent mouseEvent) {

    }

    public void mouseEntered(MouseEvent mouseEvent) {

    }

    public void mouseExited(MouseEvent mouseEvent) {

    }
}
