package essential.ui;

import essential.collection.ArrayCollection;
import essential.collection.GameCollection;
import essential.objects.abstraction.AbstractMovableObject;
import essential.objects.enums.Direction;
import essential.objects.impl.Goldman;
import essential.observer.interfaces.StepsObserver;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

public class GuiInterface extends JPanel implements StepsObserver {

    final int BF_WIDTH = 576;
    final int BF_HEIGHT = 576;

    String gameStatus = "Play Game :)";

    private ArrayCollection gameCollection = new ArrayCollection();



    void runTheGame() throws Exception {
      while (true) {
          gameCollection.moveMovableObjects(Direction.UP);
      }
    }


    // Не смотрите код, что написан ниже. Со временем Вы будете понимать этот код.


    public static void main(String[] args) throws Exception {
        GuiInterface main = new GuiInterface();
        main.runTheGame();
    }


    JTable table;
    String[] column = new String[11];
    JLabel labelScore = new JLabel();
    JLabel labelSteps = new JLabel();
    JLabel labelGameStatus = new JLabel();


    public GuiInterface() {

        gameCollection.addObserver(this);

        JFrame frame = new JFrame("Goldman");

        table = new JTable();

        table.setTableHeader(null);
        table.setEnabled(false);
        table.setSize(new Dimension(300, 300));
        table.setRowHeight(26);
        table.setRowSelectionAllowed(false);
        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(false);
        table.setUpdateSelectionOnSort(false);
        table.setVerifyInputWhenFocusTarget(false);


        for (int i = 0; i < column.length; i++) {
            column[i] = "";
        }

        drawTable();

        add(table);
        add(labelScore);
        add(labelSteps);
        add(labelGameStatus);
        frame.setMinimumSize(new Dimension(BF_WIDTH,BF_HEIGHT + 22));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.setVisible(true);
    }

    private void score(String score) {
        labelScore.setText("Score: " + score);
    }

    private void countSteps(String countSteps) {
        labelSteps.setText("Count steps: " + countSteps);
    }

    private void gameStatus() {
        labelGameStatus.setText(gameStatus);
    }

    public void drawTable() {

        table.setModel(new DefaultTableModel(gameCollection.getData(), column));

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(new ImageRenderer());
            TableColumn a = table.getColumnModel().getColumn(i);
            a.setPreferredWidth(26);
        }

    }

    @Override
    public void notify(Goldman goldman) {

        goldman.count();
        score("Score: " + goldman.getScore());
        countSteps("Count steps: " + goldman.getStepsCount());

        drawTable();

    }

    @Override
    public void notifyObject() {

        drawTable();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
