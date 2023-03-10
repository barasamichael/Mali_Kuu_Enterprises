package gui;

import javax.swing.*;
import java.awt.*;

public class CustomersPanel extends JPanel {
    JPanel registerCustomer;
    CustomerTable customerTable;
    CustomersPanel()
    {
        this.setLayout(new GridLayout(1, 2));
        customerTable = new CustomerTable();
        registerCustomer = new RegisterCustomerPanel(
                customerTable.getTable());

        this.add(registerCustomer);
        this.add(customerTable);

        this.setVisible(true);
    }
}