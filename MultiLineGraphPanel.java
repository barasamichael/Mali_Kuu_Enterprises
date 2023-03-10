package gui;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MultiLineGraphPanel extends JPanel {
    ResultSet resultSet;
    MultiLineGraphPanel() {
        setLayout(new BorderLayout());
        String sql = "SELECT YEAR(tbl_Order.dateCreated) AS year, " +
                "MONTH(tbl_Order.dateCreated) AS month, " +
                "SUM(CASE WHEN tbl_Supply.completed = false THEN " +
                "tbl_ItemInstance.buyingPrice * tbl_ItemInstance.quantity " +
                "ELSE 0 END) AS AccountsPayable, " +
                "SUM(CASE WHEN tbl_Order.completed = false THEN " +
                "tbl_ItemInstance.sellingPrice * tbl_OrderAssignment.quantity " +
                "ELSE 0 END) AS AccountsReceivable, " +
                "SUM(CASE WHEN tbl_Supply.completed = true THEN " +
                "tbl_ItemInstance.buyingPrice * tbl_ItemInstance.quantity ELSE " +
                "0 END) AS AccountsPaid, " +
                "SUM(CASE WHEN tbl_Order.completed = true THEN " +
                "tbl_ItemInstance.sellingPrice * tbl_OrderAssignment.quantity " +
                "ELSE 0 END) AS AccountsReceived, " +
                "SUM(tbl_OrderAssignment.quantity) AS QuantitiesSold, " +
                "SUM(tbl_ItemInstance.quantity) AS QuantitiesBought, " +
                "SUM(CASE WHEN tbl_Order.completed = true THEN " +
                "tbl_ItemInstance.sellingPrice * tbl_OrderAssignment.quantity " +
                "ELSE 0 END) - SUM(CASE WHEN tbl_Supply.completed = true THEN " +
                "tbl_ItemInstance.buyingPrice * tbl_ItemInstance.quantity ELSE 0 " +
                "END) AS GrossProfit FROM tbl_Order " +
                "INNER JOIN tbl_OrderAssignment ON tbl_Order.orderId = " +
                "tbl_OrderAssignment.orderId " +
                "INNER JOIN tbl_ItemInstance ON tbl_OrderAssignment.itemInstanceId " +
                "= tbl_ItemInstance.itemInstanceId " +
                "INNER JOIN tbl_Supply ON tbl_ItemInstance.supplyId = " +
                "tbl_Supply.supplyId GROUP BY year, month";

        ItemDatabaseManager itemManager = new ItemDatabaseManager();
        DatabaseResult databaseResult = itemManager.query(sql);
        resultSet = databaseResult.getResultSet();

        // create a dataset for the graph
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try
        {
            // iterate over the result set and add data points to the dataset
            while (resultSet.next()) {
                int year = resultSet.getInt("year");
                int month = resultSet.getInt("month");
                double accountsPayable = resultSet.getDouble("AccountsPayable");
                double accountsReceivable = resultSet.getDouble("AccountsReceivable");
                double accountsPaid = resultSet.getDouble("AccountsPaid");
                double accountsReceived = resultSet.getDouble("AccountsReceived");
                double grossProfit = resultSet.getDouble("GrossProfit");

                // add data points to the dataset
                dataset.addValue(accountsPayable, "Accounts Payable", year + "-" + month);
                dataset.addValue(accountsReceivable, "Accounts Receivable", year + "-" + month);
                dataset.addValue(accountsPaid, "Accounts Paid", year + "-" + month);
                dataset.addValue(accountsReceived, "Accounts Received", year + "-" + month);
                dataset.addValue(grossProfit, "Gross Profit", year + "-" + month);
            }
        }
        catch (SQLException err)
        {
            err.printStackTrace();
        }

        try {
            databaseResult.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        JFreeChart chart = ChartFactory.createLineChart(
                "Financial Metrics", // chart title
                "Month", // x-axis label
                "Amount", // y-axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips
                false // urls
        );
        ChartPanel chartPanel = new ChartPanel(chart);
        this.add(chartPanel, BorderLayout.CENTER);
    }
}