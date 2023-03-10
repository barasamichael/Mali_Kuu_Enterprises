package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SidebarMiddle extends JPanel {
    private JButton premiumBtn, signInBtn, signUpBtn, aboutUsBtn, settingsBtn;
    SidebarMiddle()
    {
        this.setLayout(new GridLayout(5, 1));

        this.premiumBtn = new JButton("Premium");
        this.signUpBtn = new JButton("Sign Up");
        this.signInBtn = new JButton("Sign In");
        this.settingsBtn = new JButton("Settings");
        this.aboutUsBtn = new JButton("About Us");

        this.premiumBtn.addActionListener(new PremiumListener());
        this.signUpBtn.addActionListener(new signUpListener());
        this.signInBtn.addActionListener(new signInListener());
        this.settingsBtn.addActionListener(new settingsListener());
        this.aboutUsBtn.addActionListener(new aboutUsListener());

        this.add(this.premiumBtn);
        this.add(this.signUpBtn);
        this.add(this.signInBtn);
        this.add(this.settingsBtn);
        this.add(this.aboutUsBtn);

        this.setVisible(true);
    }
    class PremiumListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt)
        {
            JFrame premium = new Premium();
        }
    }

    class signUpListener implements ActionListener {
        public void actionPerformed(ActionEvent evt)
        {
            JFrame signUp = new RegisterUser();
        }
    }

    class signInListener implements ActionListener {
        public void actionPerformed(ActionEvent evt)
        {
            SignIn signIn = new SignIn();
        }
    }

    class settingsListener implements ActionListener {
        public void actionPerformed(ActionEvent evt)
        {
            JFrame settings = new Settings();
        }
    }

    class aboutUsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt)
        {
            JFrame aboutUs = new AboutUs();
        }

    }
}
