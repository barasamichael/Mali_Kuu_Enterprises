package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignIn extends JFrame {
    JLabel emailLbl, passcodeLbl, rememberLbl;
    JPasswordField passcodeEntry;
    JCheckBox rememberEntry;
    JTextField emailEntry;
    JButton loginBtn;

    SignIn()
    {
        this.setSize(550, 300);
        this.setLocationRelativeTo(null);
        this.setTitle("Duka - User Sign In");

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        layout.columnWeights = new double[] {0.1, 0.9};

        emailLbl = new JLabel("Enter email address");
        passcodeLbl = new JLabel("Enter passcode");
        rememberLbl = new JLabel("Remember me?");

        emailEntry = new JTextField();
        passcodeEntry = new JPasswordField();
        rememberEntry = new JCheckBox();

        loginBtn = new JButton("Login");
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                System.out.println("Hi guys");
            }
        });

        GridBagConstraints gbc0 = new GridBagConstraints();
        gbc0.gridx = 0;
        gbc0.gridy = 0;
        gbc0.fill = GridBagConstraints.BOTH;
        gbc0.weightx = 1.0;
        gbc0.insets = new Insets(10, 50, 10, 10);
        this.add(emailLbl, gbc0);
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 1;
        gbc1.gridy = 0;
        gbc1.fill = GridBagConstraints.BOTH;
        gbc1.insets = new Insets(10, 10, 10, 50);
        gbc1.weightx = 1.0;
        this.add(emailEntry, gbc1);

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gbc2.fill = GridBagConstraints.BOTH;
        gbc2.insets = new Insets(10, 50, 10, 10);
        gbc2.weightx = 1.0;
        this.add(passcodeLbl, gbc2);
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 1;
        gbc3.gridy = 1;
        gbc3.fill = GridBagConstraints.BOTH;
        gbc3.insets = new Insets(10, 10, 10, 50);
        gbc3.weightx = 1.0;
        this.add(passcodeEntry, gbc3);

        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 0;
        gbc4.gridy = 2;
        gbc4.fill = GridBagConstraints.BOTH;
        gbc4.insets = new Insets(10, 50, 10, 10);
        gbc4.weightx = 1.0;
        this.add(rememberLbl, gbc4);
        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridx = 1;
        gbc5.gridy = 2;
        gbc5.fill = GridBagConstraints.BOTH;
        gbc5.insets = new Insets(10, 10, 10, 50);
        gbc5.weightx = 1.0;
        this.add(rememberEntry, gbc5);

        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.gridx = 0;
        gbc6.gridy = 3;
        gbc6.fill = GridBagConstraints.BOTH;
        gbc6.gridwidth = 2;
        gbc6.insets = new Insets(10, 50, 10, 50);
        gbc6.weightx = 1.0;
        this.add(loginBtn, gbc6);

        this.setVisible(true);
    }
}