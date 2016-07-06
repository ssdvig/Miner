package miner.classes;

import miner.classes.logic.Level1;
import miner.interfaces.Cell;
import miner.interfaces.GeneratorBoard;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Random;

/**
 * Created by dvig1 on 28.06.2016.
 */
public class Main implements Runnable{
    private static JPanel controlPanel = new JPanel();
    private static UBoard board = new UBoard();


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Main());
    }

     @Override
     public void run() {
        JFrame frame = new JFrame("Miner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(520,590);
        frame.add(board, BorderLayout.CENTER);
        board.setBorder(new EmptyBorder(50, 50, 50, 50));
        frame.setVisible(true);
        frame.add(controlPanel, BorderLayout.PAGE_END);
        controlPanel.setLayout(new FlowLayout());
        JButton generate = new JButton("Начать");
        Random random = new Random();
        int xSize = 10;
        int ySize = 10;
         //lambda expression generate array of cells
        GeneratorBoard generatorBoard = () -> {
            Cell[][] cell = new Cell[xSize][xSize];
            for (int i = 0; i < xSize; i++) {
                for (int j = 0; j < ySize; j++) {
                   cell[i][j] = new UCell(i, j, random.nextBoolean());
                }
            }
            return cell;
        };
        UAction act = new UAction(generatorBoard, board, new Level1());
        generate.addActionListener(act);
        controlPanel.add(generate);
    }

}

