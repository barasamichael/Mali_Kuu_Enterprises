package gui;

import javax.swing.*;
import java.awt.*;

public class CustomerProfile extends JFramePopUp {
    OrdersTable ordersTable;
    JPanel profilePicture;
    JPanel createOrder;
    JPanel compositePanel;

    CustomerProfile(int id)
    {
        super(id);

        this.setSize(1000, 600);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.setTitle("Duka - Customer Profile");
        this.setLayout(new GridLayout(1, 2));

        ordersTable = new OrdersTable(this);
        profilePicture = new ProfilePicture("C:\\Users\\user\\IdeaProjects\\untitled\\src\\gui\\customer_3.png");
        createOrder = new CreateOrder(ordersTable.getTable(), this);

        compositePanel = new JPanel();
        compositePanel.setLayout(new GridLayout(2, 1));
        compositePanel.add(profilePicture);
        compositePanel.add(createOrder);
        compositePanel.setVisible(true);

        this.add(compositePanel);
        this.add(ordersTable);

        this.setVisible(true);
    }
}