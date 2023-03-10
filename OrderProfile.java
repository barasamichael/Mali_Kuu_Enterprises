package gui;

import javax.swing.*;
import java.awt.*;

public class OrderProfile extends JFramePopUp {
    OrderItemsTable itemsTable;
    JPanel profilePicture;
    public OrderSearchItem searchItem;
    OrderStockTable stockTable;

    OrderProfile(int id)
    {
        super(id);
        this.setSize(1000, 600);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.setTitle("Duka - Order Profile");
        this.setLayout(new GridLayout(2, 2));

        itemsTable = new OrderItemsTable(this);
        stockTable = new OrderStockTable(this);
        searchItem = new OrderSearchItem(this,
                itemsTable.getTable(), stockTable.getTable());
        profilePicture = new ProfilePicture("C:\\Users\\user\\IdeaProjects\\untitled\\src\\gui\\customer_2.png");

        this.add(profilePicture);
        this.add(itemsTable);
        this.add(searchItem);
        this.add(stockTable);

        this.setVisible(true);
    }
}
