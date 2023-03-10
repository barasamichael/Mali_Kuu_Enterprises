package gui;

import javax.swing.*;
import java.awt.*;

public class Sidebar extends JPanel {
    private JPanel upper, middle , lower;

    Sidebar(){
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        // set ratios for JLabels
        layout.rowWeights = new double[] {2.0, 7.0, 1.0};

        // create widgets
        upper = new SidebarUpper();
        middle = new SidebarMiddle();
        lower = new SidebarLower();

        // Set constraints for the first panel
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.fill = GridBagConstraints.BOTH;
        gbc1.anchor = GridBagConstraints.NORTH;
        add(upper, gbc1);

        // Set constraints for the second panel
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gbc2.fill = GridBagConstraints.BOTH;
        gbc1.anchor = GridBagConstraints.CENTER;
        add(middle, gbc2);

        // Set constraints for the third panel
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = 2;
        gbc3.fill = GridBagConstraints.BOTH;
        gbc3.anchor = GridBagConstraints.SOUTH;
        add(lower, gbc3);

        // Set constraints for the container (JFrame)
        GridBagConstraints gbcContainer = new GridBagConstraints();
        gbcContainer.gridx = 0;
        gbcContainer.gridy = 0;
        gbcContainer.weightx = 1.0;
        gbcContainer.fill = GridBagConstraints.BOTH;
        add(Box.createGlue(), gbcContainer);

        this.setVisible(true);
    }
}