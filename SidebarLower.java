package gui;

import javax.swing.*;
import java.awt.*;

public class SidebarLower extends JPanel {
    private JLabel companyLbl;

    SidebarLower()
    {
        this.setLayout(new GridBagLayout());

        GridBagConstraints y = new GridBagConstraints();
        y.insets = new Insets(10, 10, 10, 10);

        companyLbl = new JLabel("ourdigitaltimes");

        // set position of widgets
        y.gridy = 0;
        y.gridx = 0;
        y.gridwidth = 1;
        y.weightx = 1.0;
        add(companyLbl, y);

        this.setVisible(true);
    }
}