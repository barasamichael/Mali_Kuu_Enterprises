package gui;

import javax.swing.*;
import java.awt.*;

public class SuppliesPanel extends JPanel {
    JPanel registerSupplier;
    SupplierTable supplierTable;
    SuppliesPanel()
    {
        this.setLayout(new GridLayout(1, 2));

        supplierTable = new SupplierTable();
        registerSupplier = new RegisterSupplierPanel(
                supplierTable.getTable());

        this.add(registerSupplier);
        this.add(supplierTable);

        this.setVisible(true);
    }
}