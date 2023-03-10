package gui;

import javax.swing.*;
import java.awt.*;

public class SupplyProfile extends JFramePopUp {
    SupplyItemsTable itemsTable;
    JPanel profilePicture;
    public SupplySearchItem searchItem;
    SupplySupplyTable supplyTable;

    SupplyProfile(int id)
    {
        super(id);

        this.setSize(1000, 600);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.setTitle("Duka - Supply Profile");
        this.setLayout(new GridLayout(2, 2));

        supplyTable = new SupplySupplyTable(this);
        itemsTable = new SupplyItemsTable(this);
        searchItem = new SupplySearchItem(this, itemsTable.getTable(), supplyTable.getTable());

        profilePicture = new ProfilePicture("C:\\Users\\user\\IdeaProjects\\untitled\\src\\gui\\customer_1.png");

        this.add(profilePicture);
        this.add(itemsTable);
        this.add(searchItem);
        this.add(supplyTable);

        this.setVisible(true);
    }
}