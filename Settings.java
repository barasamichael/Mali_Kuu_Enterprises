package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame {
    JLabel titleLbl;
    JButton orgNameBtn, passwordBtn, helpBtn, aboutUsBtn, downloadsBtn,
            colorBtn;
    JToggleButton displayDateBtn, displayTimeBtn, subscribeBtn,
            darkModeBtn;
    JSeparator separator0, separator1;

    Settings()
    {
        this.setSize(450, 600);
        this.setTitle("Duka - Settings");

        GridBagLayout layout = new GridBagLayout();
        layout.columnWeights = new double[] {1.0};
        this.setLayout(layout);
        this.setLocationRelativeTo(null);

        titleLbl = new JLabel("Settings");
        orgNameBtn = new JButton("Change Business Name");
        passwordBtn = new JButton("Change Password");
        subscribeBtn = new JToggleButton("Auto Subscribe to NewsLetter");
        downloadsBtn = new JButton("View Downloads");

        separator0 = new JSeparator();
        separator0.setOrientation(SwingConstants.HORIZONTAL);

        displayDateBtn = new JToggleButton("Display Date");
        displayTimeBtn = new JToggleButton("Display Time");
        colorBtn = new JButton("Change Title Color");
        darkModeBtn = new JToggleButton("Dark Mode");

        separator1 = new JSeparator();
        separator1.setOrientation(SwingConstants.HORIZONTAL);

        helpBtn = new JButton("Help & Contacts");
        aboutUsBtn = new JButton("About Us");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(10, 50, 10, 50);
        gbc.fill = GridBagConstraints.BOTH;
        this.add(titleLbl, gbc);

        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 1;
        gbc1.weightx = 1.0;
        gbc1.insets = new Insets(10, 50, 10, 50);
        gbc1.fill = GridBagConstraints.BOTH;
        this.add(orgNameBtn, gbc1);

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 2;
        gbc2.weightx = 1.0;
        gbc2.insets = new Insets(10, 50, 10, 50);
        gbc2.fill = GridBagConstraints.BOTH;
        this.add(passwordBtn, gbc2);

        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = 3;
        gbc3.weightx = 1.0;
        gbc3.insets = new Insets(10, 50, 10, 50);
        gbc3.fill = GridBagConstraints.BOTH;
        this.add(subscribeBtn, gbc3);

        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 0;
        gbc4.gridy = 4;
        gbc4.weightx = 1.0;
        gbc4.insets = new Insets(10, 50, 10, 50);
        gbc4.fill = GridBagConstraints.BOTH;
        this.add(downloadsBtn, gbc4);

        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridx = 0;
        gbc5.gridy = 5;
        gbc5.weightx = 1.0;
        gbc5.insets = new Insets(10, 50, 10, 50);
        gbc5.fill = GridBagConstraints.BOTH;
        this.add(separator0, gbc5);

        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.gridx = 0;
        gbc6.gridy = 6;
        gbc6.weightx = 1.0;
        gbc6.insets = new Insets(10, 50, 10, 50);
        gbc6.fill = GridBagConstraints.BOTH;
        this.add(displayDateBtn, gbc6);

        GridBagConstraints gbc7 = new GridBagConstraints();
        gbc7.gridx = 0;
        gbc7.gridy = 7;
        gbc7.weightx = 1.0;
        gbc7.insets = new Insets(10, 50, 10, 50);
        gbc7.fill = GridBagConstraints.BOTH;
        this.add(displayTimeBtn, gbc7);

        GridBagConstraints gbc8 = new GridBagConstraints();
        gbc8.gridx = 0;
        gbc8.gridy = 8;
        gbc8.weightx = 1.0;
        gbc8.insets = new Insets(10, 50, 10, 50);
        gbc8.fill = GridBagConstraints.BOTH;
        this.add(darkModeBtn, gbc8);

        GridBagConstraints gbc9 = new GridBagConstraints();
        gbc9.gridx = 0;
        gbc9.gridy = 9;
        gbc9.weightx = 1.0;
        gbc9.insets = new Insets(10, 50, 10, 50);
        gbc9.fill = GridBagConstraints.BOTH;
        this.add(colorBtn, gbc9);

        GridBagConstraints gbc10 = new GridBagConstraints();
        gbc10.gridx = 0;
        gbc10.gridy = 10;
        gbc10.weightx = 1.0;
        gbc10.insets = new Insets(10, 50, 10, 50);
        gbc10.fill = GridBagConstraints.BOTH;
        this.add(separator1, gbc10);

        GridBagConstraints gbc11 = new GridBagConstraints();
        gbc11.gridx = 0;
        gbc11.gridy = 11;
        gbc11.weightx = 1.0;
        gbc11.insets = new Insets(10, 50, 10, 50);
        gbc11.fill = GridBagConstraints.BOTH;
        this.add(helpBtn, gbc11);

        GridBagConstraints gbc12 = new GridBagConstraints();
        gbc12.gridx = 0;
        gbc12.gridy = 12;
        gbc12.weightx = 1.0;
        gbc12.insets = new Insets(10, 50, 10, 50);
        gbc12.fill = GridBagConstraints.BOTH;
        this.add(aboutUsBtn, gbc12);

        this.setVisible(true);

        // set action listeners
        orgNameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                System.out.println("Trial basis");
            }
        });

        passwordBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                System.out.println("Trial basis");
            }
        });

        helpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                System.out.println("Trial basis");
            }
        });

        aboutUsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                JFrame AboutUs = new AboutUs();
            }
        });

        downloadsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                System.out.println("Trial basis");
            }
        });

        displayDateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                System.out.println("Trial basis");
            }
        });

        displayTimeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                System.out.println("Trial basis");
            }
        });

        colorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                System.out.println("Trial basis");
            }
        });

        darkModeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                System.out.println("Trial basis");
            }
        });

        subscribeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                System.out.println("Trial basis");
            }
        });

        this.setVisible(true);
    }
}