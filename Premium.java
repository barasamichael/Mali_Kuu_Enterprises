package gui;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Premium extends JFrame {
    JLabel titleLabel, descriptionLabel;
    Premium()
    {
        this.setSize(1000, 600);
        this.setTitle("Duka - Premium");
        this.setLayout(new GridBagLayout());
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        titleLabel = new JLabel("Premium");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(10, 0, 0, 10);
        this.add(titleLabel, gbc);

        Path filePath = Path.of("C:\\Users\\user\\IdeaProjects\\untitled\\src\\gui\\premium.html");
        String content = "";
        try
        {
            content = Files.readString(filePath);
        }
        catch (java.io.IOException e)
        {
            System.out.println("Filepath is invalid");
        }
        descriptionLabel = new JLabel(content);
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        descriptionLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20),
                BorderFactory.createLineBorder(Color.BLACK, 1)));
        GridBagConstraints gbcDesc = new GridBagConstraints();
        gbcDesc.gridx = 0;
        gbcDesc.gridy = 1;
        gbcDesc.fill = GridBagConstraints.BOTH;
        gbcDesc.weightx = 1;
        gbcDesc.weighty = 1;
        gbcDesc.insets = new Insets(0, 0, 10, 10);
        this.add(descriptionLabel, gbcDesc);

        this.setVisible(true);
    }
}