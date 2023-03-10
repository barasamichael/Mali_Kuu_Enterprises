package gui;

import javax.swing.*;

public class MainArea extends JTabbedPane {
    JPanel stocksPanel, salesPanel, ordersPanel, customersPanel, suppliesPanel,
            summaryPanel, financesPanel, chartPanel;

    MainArea(){
        stocksPanel = new StocksPanel();
        salesPanel = new SalesPanel();
        ordersPanel = new OrdersPanel();
        customersPanel = new CustomersPanel();
        suppliesPanel = new SuppliesPanel();
        financesPanel = new FinancesPanel();
        summaryPanel = new SummaryPanel();
        chartPanel = new MultiLineGraphPanel();

        this.addTab("Stock", stocksPanel);
        this.addTab("Sales", salesPanel);
        this.addTab("Orders", ordersPanel);
        this.addTab("Customers", customersPanel);
        this.addTab("Suppliers", suppliesPanel);
        this.addTab("Finances", financesPanel);
        this.addTab("Finances Chart", chartPanel);
        this.addTab("Summary", summaryPanel);

        //this.add(this);
        this.setVisible(true);
    }
}
