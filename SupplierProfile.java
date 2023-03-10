package gui;

import gui.CreateSupply;
import gui.JFramePopUp;
import gui.ProfilePicture;
import gui.SupplyTable;

import javax.swing.*;
import java.awt.*;

public class SupplierProfile extends JFramePopUp {
    SupplyTable supplyTable;
    JPanel profilePicture;
    JPanel createSupply;
    JPanel compositePanel;

    SupplierProfile(int id)
    {
        super(id);

        this.setSize(1000, 600);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.setTitle("Duka - Supplier Profile");
        this.setLayout(new GridLayout(1, 2));

        supplyTable = new SupplyTable(this);
        profilePicture = new ProfilePicture("C:\\Users\\user\\IdeaProjects\\untitled\\src\\gui\\Orders.png");
        createSupply = new CreateSupply(supplyTable.getTable(), this);

        compositePanel = new JPanel();
        compositePanel.setLayout(new GridLayout(2, 1));
        compositePanel.add(profilePicture);
        compositePanel.add(createSupply);
        compositePanel.setVisible(true);

        this.add(compositePanel);
        this.add(supplyTable);

        this.setVisible(true);
    }
}
