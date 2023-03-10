package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class RegisterCustomerPanel extends JPanel {
    JLabel titleLbl, searchLbl;
    JLabel firstNameLbl, middleNameLbl, lastNameLbl, emailAddressLbl, phoneNoLbl,
            locationAddressLbl, genderLbl;
    JTextField firstNameEntry, middleNameEntry, lastNameEntry, emailAddressEntry,
            phoneNoEntry, locationAddressEntry, searchEntry;
    JComboBox genderEntry;
    JSeparator separator;
    JButton submitBtn, searchBtn;

    ArrayList<Object> widgets;
    CustomerDatabaseManager customerManager= new CustomerDatabaseManager();
    CustomTable customersTable;
    RegisterCustomerPanel(CustomTable customersTable)
    {
        this.customersTable = customersTable;
        titleLbl = new JLabel("Register Customer");

        // user registration form
        firstNameLbl = new JLabel("First Name");
        middleNameLbl = new JLabel("Middle Name");
        lastNameLbl = new JLabel("Last Name");
        genderLbl = new JLabel("Gender");
        emailAddressLbl = new JLabel("Email Address");
        phoneNoLbl = new JLabel("Phone Number");
        locationAddressLbl = new JLabel("Location Address");

        firstNameEntry = new JTextField();
        middleNameEntry = new JTextField();
        lastNameEntry = new JTextField();
        emailAddressEntry = new JTextField();
        phoneNoEntry = new JTextField();
        locationAddressEntry = new JTextField();

        String[] gender = {"Male", "Female"};
        genderEntry = new JComboBox(gender);

        submitBtn = new JButton("submit");
        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                if (action()) {
                    JOptionPane.showMessageDialog(null,
                            "Customer Registration Successful!",
                            "Customer Registration",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    FieldValidator.cleanUp(widgets);
                    Object[][] tableDataArray = customersTable.tableData(
                            customersTable.reset());
                    DefaultTableModel model = new DefaultTableModel(tableDataArray,
                            customersTable.tableColumns);
                    customersTable.setModel(model);
                }
            }
        });

        // add a separator
        separator = new JSeparator();
        separator.setOrientation(SwingConstants.HORIZONTAL);

        // search section
        searchLbl = new JLabel("SEARCH");
        searchEntry = new JTextField();
        searchBtn = new JButton("submit");
        searchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                actionSearchCustomer();
            }
        });

        widgets = new ArrayList<Object>();

        widgets.add(firstNameEntry);
        widgets.add(middleNameEntry);
        widgets.add(lastNameEntry);
        widgets.add(genderEntry);
        widgets.add(emailAddressEntry);
        widgets.add(phoneNoEntry);
        widgets.add(locationAddressEntry);

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        layout.rowWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
                1.0, 0.2, 1.0, 1.0, 1.0};
        layout.columnWeights = new double[] {0.5, 0.5};

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
        this.add(firstNameLbl, gbc2);
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 1;
        gbc3.gridy = 1;
        gbc3.fill = GridBagConstraints.BOTH;
        gbc3.insets = new Insets(10, 10, 10, 10);
        this.add(firstNameEntry, gbc3);

        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 0;
        gbc4.gridy = 2;
        gbc4.fill = GridBagConstraints.BOTH;
        gbc4.insets = new Insets(10, 10, 10, 10);
        this.add(middleNameLbl, gbc4);
        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridx = 1;
        gbc5.gridy = 2;
        gbc5.fill = GridBagConstraints.BOTH;
        gbc5.insets = new Insets(10, 10, 10, 10);
        this.add(middleNameEntry, gbc5);

        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.gridx = 0;
        gbc6.gridy = 3;
        gbc6.fill = GridBagConstraints.BOTH;
        gbc6.insets = new Insets(10, 10, 10, 10);
        this.add(lastNameLbl, gbc6);
        GridBagConstraints gbc7 = new GridBagConstraints();
        gbc7.gridx = 1;
        gbc7.gridy = 3;
        gbc7.fill = GridBagConstraints.BOTH;
        gbc7.insets = new Insets(10, 10, 10, 10);
        this.add(lastNameEntry, gbc7);

        GridBagConstraints gbc8 = new GridBagConstraints();
        gbc8.gridx = 0;
        gbc8.gridy = 4;
        gbc8.fill = GridBagConstraints.BOTH;
        gbc8.insets = new Insets(10, 10, 10, 10);
        this.add(genderLbl, gbc8);
        GridBagConstraints gbc9 = new GridBagConstraints();
        gbc9.gridx = 1;
        gbc9.gridy = 4;
        gbc9.fill = GridBagConstraints.BOTH;
        gbc9.insets = new Insets(10, 10, 10, 10);
        this.add(genderEntry, gbc9);

        GridBagConstraints gbc10 = new GridBagConstraints();
        gbc10.gridx = 0;
        gbc10.gridy = 5;
        gbc10.fill = GridBagConstraints.BOTH;
        gbc10.insets = new Insets(10, 10, 10, 10);
        this.add(emailAddressLbl, gbc10);
        GridBagConstraints gbc11 = new GridBagConstraints();
        gbc11.gridx = 1;
        gbc11.gridy = 5;
        gbc11.fill = GridBagConstraints.BOTH;
        gbc11.insets = new Insets(10, 10, 10, 10);
        this.add(emailAddressEntry, gbc11);

        GridBagConstraints gbc12 = new GridBagConstraints();
        gbc12.gridx = 0;
        gbc12.gridy = 6;
        gbc12.fill = GridBagConstraints.BOTH;
        gbc12.insets = new Insets(10, 10, 10, 10);
        this.add(phoneNoLbl, gbc12);
        GridBagConstraints gbc13 = new GridBagConstraints();
        gbc13.gridx = 1;
        gbc13.gridy = 6;
        gbc13.fill = GridBagConstraints.BOTH;
        gbc13.insets = new Insets(10, 10, 10, 10);
        this.add(phoneNoEntry, gbc13);

        GridBagConstraints gbc14 = new GridBagConstraints();
        gbc14.gridx = 0;
        gbc14.gridy = 7;
        gbc14.fill = GridBagConstraints.BOTH;
        gbc14.insets = new Insets(10, 10, 10, 10);
        this.add(locationAddressLbl, gbc14);
        GridBagConstraints gbc15 = new GridBagConstraints();
        gbc15.gridx = 1;
        gbc15.gridy = 7;
        gbc15.fill = GridBagConstraints.BOTH;
        gbc15.insets = new Insets(10, 10, 10, 10);
        this.add(locationAddressEntry, gbc15);

        GridBagConstraints gbc16 = new GridBagConstraints();
        gbc16.gridx = 0;
        gbc16.gridy = 8;
        gbc16.fill = GridBagConstraints.BOTH;
        gbc16.insets = new Insets(10, 10, 10, 10);
        gbc16.gridwidth = 2;
        this.add(submitBtn, gbc16);

        GridBagConstraints gbc17 = new GridBagConstraints();
        gbc17.gridx = 0;
        gbc17.gridy = 9;
        gbc17.fill = GridBagConstraints.BOTH;
        gbc17.insets = new Insets(10, 10, 10, 10);
        gbc17.gridwidth = 2;
        this.add(separator, gbc17);

        GridBagConstraints gbc18 = new GridBagConstraints();
        gbc18.gridx = 0;
        gbc18.gridy = 10;
        gbc18.fill = GridBagConstraints.BOTH;
        gbc18.insets = new Insets(10, 10, 10, 10);
        gbc18.gridwidth = 2;
        this.add(searchLbl, gbc18);

        GridBagConstraints gbc19 = new GridBagConstraints();
        gbc19.gridx = 0;
        gbc19.gridy = 11;
        gbc19.fill = GridBagConstraints.BOTH;
        gbc19.insets = new Insets(10, 10, 10, 10);
        gbc19.gridwidth = 2;
        this.add(searchEntry, gbc19);

        GridBagConstraints gbc20 = new GridBagConstraints();
        gbc20.gridx = 0;
        gbc20.gridy = 12;
        gbc20.insets = new Insets(10, 10, 10, 10);
        gbc20.fill = GridBagConstraints.BOTH;
        gbc20.gridwidth = 2;
        this.add(searchBtn, gbc20);

        this.setVisible(true);
        customersTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                CustomTable target = (CustomTable) e.getSource();
                int row = target.getSelectedRow();
                int column = 0;
                int id = (int) target.getValueAt(row, column);

                if (e.getClickCount() == 1) {
                    //
                } else if (e.getClickCount() == 2) {
                    JFramePopUp major = new CustomerProfile(id);
                    major.setVisible(true);
                }
            }
        });
    }

    private boolean action()
    {
        boolean success = false;
        if (FieldValidator.validate(widgets))
        {
            String firstName = firstNameEntry.getText().trim();
            String middleName = middleNameEntry.getText().trim();
            String lastName = lastNameEntry.getText().trim();
            String emailAddress = emailAddressEntry.getText().trim();
            String phoneNo = phoneNoEntry.getText().trim();
            String locationAddress = locationAddressEntry.getText().trim();
            String gender = (String) genderEntry.getSelectedItem();

            success = customerManager.registerCustomer(firstName, middleName, lastName,
                    emailAddress, phoneNo, locationAddress, gender);

            if (!(success))
            {
                JOptionPane.showMessageDialog(null, "Customer Registration Failed!",
                        "Customer Registration", JOptionPane.WARNING_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please fill in all required fields",
                    "Customer Registration", JOptionPane.WARNING_MESSAGE);
        }
        return success;
    }

    private void actionSearchCustomer()
    {
        String search = searchEntry.getText().trim();
        String SQL = "SELECT customerId, CONCAT(firstName, ' ', " +
                "IFNULL(middleName, ''), ' ', lastName) " +
                "AS name, emailAddress, phoneNumber, locationAddress " +
                "FROM tbl_Customer WHERE " +
                " firstName LIKE '%" + search + "%' OR" +
                " middleName LIKE '%" + search + "%' OR " +
                " lastName LIKE '%" + search + "%' OR " +
                " emailAddress LIKE '%" + search + "%' OR " +
                " locationAddress LIKE '%" + search + "%' OR " +
                " phoneNumber LIKE ";

        Object[][] tableDataArray = customersTable.tableData(customersTable.filterTable(SQL, search));
        DefaultTableModel model = new DefaultTableModel(tableDataArray, customersTable.tableColumns);
        customersTable.setModel(model);
    }
}