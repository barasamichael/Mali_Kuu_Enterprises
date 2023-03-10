package gui;

import javax.swing.*;
import java.awt.*;

public class StocksPanel extends JPanel {
    StocksPanelFirstHalf firstHalf;
    StocksPanelSecondHalf secondHalf;
    StocksPanelFullHalf fullHalf;

    JPanel compositeHalf;
    StocksPanel()
    {
        this.setLayout(new GridLayout(1, 2));

        secondHalf = new StocksPanelSecondHalf();
        fullHalf = new StocksPanelFullHalf();

        firstHalf = new StocksPanelFirstHalf(secondHalf.getTable(), fullHalf.getTable());
        compositeHalf = new JPanel();
        compositeHalf.setLayout(new GridLayout(2, 1));
        compositeHalf.add(firstHalf);
        compositeHalf.add(secondHalf);
        compositeHalf.setVisible(true);

        this.add(compositeHalf);
        this.add(fullHalf);

        this.setVisible(true);
    }
}