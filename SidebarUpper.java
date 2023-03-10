package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SidebarUpper extends JPanel implements ActionListener {
    private JLabel searchLbl;
    private JButton searchBtn;
    private JTextField searchEntry;

    SidebarUpper()
    {
        GridBagLayout layout = new GridBagLayout();
        layout.rowWeights = new double[] {1.0, 2.0, 1.0};

        this.setLayout(layout);

        GridBagConstraints y = new GridBagConstraints();

        searchLbl = new JLabel("Main Menu");
        searchBtn = new JButton("Search");
        searchEntry = new JTextField();

        searchBtn.addActionListener(this);
        searchEntry.setBackground(Color.lightGray);

        // set position of widgets
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridy = 0;
        gbc1.gridx = 0;
        gbc1.fill = GridBagConstraints.BOTH;
        gbc1.anchor = GridBagConstraints.NORTH;
        this.add(searchLbl, gbc1);

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridy = 1;
        gbc2.gridx = 0;
        gbc2.fill = GridBagConstraints.BOTH;
        gbc2.anchor = GridBagConstraints.CENTER;
        this.add(searchEntry, gbc2);

        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridy = 2;
        gbc3.gridx = 0;
        gbc3.fill = GridBagConstraints.BOTH;
        gbc3.anchor = GridBagConstraints.CENTER;
        this.add(searchBtn, gbc3);

        // Set constraints for the container (JFrame)
        GridBagConstraints gbcContainer = new GridBagConstraints();
        gbcContainer.gridx = 0;
        gbcContainer.gridy = 0;
        gbcContainer.weightx = 1.0;
        gbcContainer.fill = GridBagConstraints.BOTH;
        add(Box.createGlue(), gbcContainer);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt)
    {
    }
}