package gui;

import javax.swing.*;
import java.awt.*;

public class SummaryPanel extends JPanel {
    JPanel firstHalf, secondHalf;
    SummaryPanel()
    {
        this.setLayout(new GridLayout(1, 2));

        firstHalf = new SummaryPanelFirstHalf();
        secondHalf = new SummaryPanelSecondHalf();

        this.add(firstHalf);
        this.add(secondHalf);

        this.setVisible(true);
    }
}