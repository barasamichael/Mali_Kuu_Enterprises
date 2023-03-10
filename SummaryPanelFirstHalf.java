package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SummaryPanelFirstHalf extends JPanel {
    JLabel titleLbl, monthLbl;
    JComboBox monthEntry, yearEntry;
    JLabel revenueLbl, COGSLbl, grossProfitLbl, OPEXLbl, salesLbl,
            marketingLbl, otherIncomeLbl, otherExpensesLbl,
            interestTaxLbl, operatingProfitLbl, netProfitLbl, genLbl;

    JLabel vRevenueLbl, vCOGSLbl, vGrossProfitLbl, vOPEXLbl, vSalesLbl,
            vMarketingLbl, vOtherIncomeLbl, vOtherExpensesLbl, vGenLbl,
            vInterestTaxLbl, vOperatingProfitLbl, vNetProfitLbl;
    JButton saveBtn;

    SummaryPanelFirstHalf()
    {
        titleLbl = new JLabel("Monthly Summary");
        monthLbl = new JLabel("January 2022");

        monthEntry = new JComboBox();
        yearEntry = new JComboBox();

        revenueLbl = new JLabel("Revenue");
        COGSLbl = new JLabel("COGS");
        grossProfitLbl = new JLabel("Gross Profit");
        OPEXLbl = new JLabel("OPEX");
        salesLbl = new JLabel("Sales");
        marketingLbl = new JLabel("Marketing");
        genLbl = new JLabel("General and Administration");
        otherIncomeLbl = new JLabel("Other Income");
        otherExpensesLbl = new JLabel("Other Expenses");
        interestTaxLbl = new JLabel("Interest and Tax");
        operatingProfitLbl = new JLabel("Operating Profit");
        netProfitLbl = new JLabel("Net Profit");

        vRevenueLbl = new JLabel();
        vCOGSLbl = new JLabel();
        vGrossProfitLbl = new JLabel();
        vOPEXLbl = new JLabel();
        vSalesLbl = new JLabel();
        vMarketingLbl = new JLabel();
        vGenLbl = new JLabel();
        vOtherIncomeLbl = new JLabel();
        vOtherExpensesLbl = new JLabel();
        vInterestTaxLbl = new JLabel();
        vOperatingProfitLbl = new JLabel();
        vNetProfitLbl = new JLabel();

        saveBtn = new JButton("Save Report");

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        layout.rowWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
                1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
        layout.columnWeights = new double[] {0.7, 0.3};

        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.fill = GridBagConstraints.BOTH;
        gbc1.insets = new Insets(10, 10, 10, 10);
        gbc1.gridwidth = 2;
        this.add(titleLbl, gbc1);

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gbc2.fill = GridBagConstraints.BOTH;
        gbc2.insets = new Insets(10, 10, 10, 10);
        this.add(monthEntry, gbc2);
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 1;
        gbc3.gridy = 1;
        gbc3.fill = GridBagConstraints.BOTH;
        gbc3.insets = new Insets(10, 10, 10, 10);
        this.add(yearEntry, gbc3);

        GridBagConstraints gbc29 = new GridBagConstraints();
        gbc29.gridx = 0;
        gbc29.gridy = 2;
        gbc29.fill = GridBagConstraints.BOTH;
        gbc29.gridwidth = 2;
        gbc29.insets = new Insets(10, 10, 10, 10);
        this.add(monthLbl, gbc29);

        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 0;
        gbc4.gridy = 3;
        gbc4.fill = GridBagConstraints.BOTH;
        gbc4.insets = new Insets(10, 10, 10, 10);
        this.add(revenueLbl, gbc4);
        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridx = 1;
        gbc5.gridy = 3;
        gbc5.fill = GridBagConstraints.BOTH;
        gbc5.insets = new Insets(10, 10, 10, 10);
        this.add(vRevenueLbl, gbc5);

        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.gridx = 0;
        gbc6.gridy = 4;
        gbc6.fill = GridBagConstraints.BOTH;
        gbc6.insets = new Insets(10, 10, 10, 10);
        this.add(COGSLbl, gbc6);
        GridBagConstraints gbc7 = new GridBagConstraints();
        gbc7.gridx = 1;
        gbc7.gridy = 4;
        gbc7.fill = GridBagConstraints.BOTH;
        gbc7.insets = new Insets(10, 10, 10, 10);
        this.add(vCOGSLbl, gbc7);

        GridBagConstraints gbc8 = new GridBagConstraints();
        gbc8.gridx = 0;
        gbc8.gridy = 5;
        gbc8.fill = GridBagConstraints.BOTH;
        gbc8.insets = new Insets(10, 10, 10, 10);
        this.add(grossProfitLbl, gbc8);
        GridBagConstraints gbc9 = new GridBagConstraints();
        gbc9.gridx = 1;
        gbc9.gridy = 5;
        gbc9.fill = GridBagConstraints.BOTH;
        gbc9.insets = new Insets(10, 10, 10, 10);
        this.add(vGrossProfitLbl, gbc9);

        GridBagConstraints gbc10 = new GridBagConstraints();
        gbc10.gridx = 0;
        gbc10.gridy = 6;
        gbc10.fill = GridBagConstraints.BOTH;
        gbc10.insets = new Insets(10, 10, 10, 10);
        this.add(OPEXLbl, gbc10);
        GridBagConstraints gbc11 = new GridBagConstraints();
        gbc11.gridx = 1;
        gbc11.gridy = 6;
        gbc11.fill = GridBagConstraints.BOTH;
        gbc11.insets = new Insets(10, 10, 10, 10);
        this.add(vOPEXLbl, gbc11);

        GridBagConstraints gbc12 = new GridBagConstraints();
        gbc12.gridx = 0;
        gbc12.gridy = 7;
        gbc12.fill = GridBagConstraints.BOTH;
        gbc12.insets = new Insets(10, 10, 10, 10);
        this.add(salesLbl, gbc12);
        GridBagConstraints gbc13 = new GridBagConstraints();
        gbc13.gridx = 1;
        gbc13.gridy = 7;
        gbc13.fill = GridBagConstraints.BOTH;
        gbc13.insets = new Insets(10, 10, 10, 10);
        this.add(vSalesLbl, gbc13);

        GridBagConstraints gbc14 = new GridBagConstraints();
        gbc14.gridx = 0;
        gbc14.gridy = 8;
        gbc14.fill = GridBagConstraints.BOTH;
        gbc14.insets = new Insets(10, 10, 10, 10);
        this.add(marketingLbl, gbc14);
        GridBagConstraints gbc15 = new GridBagConstraints();
        gbc15.gridx = 1;
        gbc15.gridy = 8;
        gbc15.fill = GridBagConstraints.BOTH;
        gbc15.insets = new Insets(10, 10, 10, 10);
        this.add(vMarketingLbl, gbc15);

        GridBagConstraints gbc16 = new GridBagConstraints();
        gbc16.gridx = 0;
        gbc16.gridy = 9;
        gbc16.fill = GridBagConstraints.BOTH;
        gbc16.insets = new Insets(10, 10, 10, 10);
        this.add(otherIncomeLbl, gbc16);
        GridBagConstraints gbc17 = new GridBagConstraints();
        gbc17.gridx = 1;
        gbc17.gridy = 9;
        gbc17.fill = GridBagConstraints.BOTH;
        gbc17.insets = new Insets(10, 10, 10, 10);
        this.add(vOtherIncomeLbl, gbc17);

        GridBagConstraints gbc18 = new GridBagConstraints();
        gbc18.gridx = 0;
        gbc18.gridy = 10;
        gbc18.fill = GridBagConstraints.BOTH;
        gbc18.insets = new Insets(10, 10, 10, 10);
        this.add(otherExpensesLbl, gbc18);
        GridBagConstraints gbc19 = new GridBagConstraints();
        gbc19.gridx = 1;
        gbc19.gridy = 10;
        gbc19.fill = GridBagConstraints.BOTH;
        gbc19.insets = new Insets(10, 10, 10, 10);
        this.add(vOtherExpensesLbl, gbc19);

        GridBagConstraints gbc20 = new GridBagConstraints();
        gbc20.gridx = 0;
        gbc20.gridy = 11;
        gbc20.fill = GridBagConstraints.BOTH;
        gbc20.insets = new Insets(10, 10, 10, 10);
        this.add(interestTaxLbl, gbc20);
        GridBagConstraints gbc21 = new GridBagConstraints();
        gbc21.gridx = 1;
        gbc21.gridy = 11;
        gbc21.fill = GridBagConstraints.BOTH;
        gbc21.insets = new Insets(10, 10, 10, 10);
        this.add(vInterestTaxLbl, gbc21);

        GridBagConstraints gbc22 = new GridBagConstraints();
        gbc22.gridx = 0;
        gbc22.gridy = 12;
        gbc22.fill = GridBagConstraints.BOTH;
        gbc22.insets = new Insets(10, 10, 10, 10);
        this.add(operatingProfitLbl, gbc22);
        GridBagConstraints gbc23 = new GridBagConstraints();
        gbc23.gridx = 1;
        gbc23.gridy = 12;
        gbc23.fill = GridBagConstraints.BOTH;
        gbc23.insets = new Insets(10, 10, 10, 10);
        this.add(vOperatingProfitLbl, gbc23);

        GridBagConstraints gbc24 = new GridBagConstraints();
        gbc24.gridx = 0;
        gbc24.gridy = 13;
        gbc24.fill = GridBagConstraints.BOTH;
        gbc24.insets = new Insets(10, 10, 10, 10);
        this.add(genLbl, gbc24);
        GridBagConstraints gbc25 = new GridBagConstraints();
        gbc25.gridx = 1;
        gbc25.gridy = 13;
        gbc25.fill = GridBagConstraints.BOTH;
        gbc25.insets = new Insets(10, 10, 10, 10);
        this.add(vGenLbl, gbc25);

        GridBagConstraints gbc26 = new GridBagConstraints();
        gbc26.gridx = 0;
        gbc26.gridy = 14;
        gbc26.fill = GridBagConstraints.BOTH;
        gbc26.insets = new Insets(10, 10, 10, 10);
        this.add(netProfitLbl, gbc26);
        GridBagConstraints gbc27 = new GridBagConstraints();
        gbc27.gridx = 1;
        gbc27.gridy = 14;
        gbc27.fill = GridBagConstraints.BOTH;
        gbc27.insets = new Insets(10, 10, 10, 10);
        this.add(vNetProfitLbl, gbc27);

        GridBagConstraints gbc28 = new GridBagConstraints();
        gbc28.gridx = 0;
        gbc28.gridy = 15;
        gbc28.fill = GridBagConstraints.BOTH;
        gbc28.insets = new Insets(10, 10, 10, 10);
        gbc28.gridwidth = 2;
        this.add(saveBtn, gbc28);

        saveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                System.out.print("Saving to PDF");
            }
        });

        this.setVisible(true);
    }
}