package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RegisterUser extends JFrame {
    JLabel titleLbl;

    JLabel firstNameLbl, middleNameLbl, lastNameLbl, emailAddressLbl, phoneNoLbl,
            locationAddressLbl, genderLbl, roleLbl, passcodeLbl, nationalIDLbl;

    JPasswordField passcodeEntry;
    JTextField firstNameEntry, middleNameEntry, lastNameEntry, emailAddressEntry,
            phoneNoEntry, locationAddressEntry, nationalIDEntry;
    JComboBox genderEntry, roleEntry;
    JButton submitBtn;

    Map<String, Integer> mapRoleId = null;
    ArrayList<Object> widgets;
    UserDatabaseManager userManager= new UserDatabaseManager();

    RegisterUser()
    {
        mapRoleId = new HashMap<>();

        DatabaseResult databaseResult = userManager.query("SELECT title, roleId FROM tbl_Role ORDER BY title DESC");

        ResultSet resultSet = databaseResult.getResultSet();
        Connection connection = databaseResult.getConnection();
        Statement statement = databaseResult.getStatement();

        try
        {
            while(resultSet.next())
            {
                String key = resultSet.getString("title");
                int value = resultSet.getInt("roleId");
                mapRoleId.put(key, value);
            }
            resultSet.close();
            databaseResult.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        this.setSize(550, 600);
        this.setLocationRelativeTo(null);
        this.setTitle("Duka - Register User");

        titleLbl = new JLabel("Register User");

        firstNameLbl = new JLabel("First Name");
        middleNameLbl = new JLabel("Middle Name");
        lastNameLbl = new JLabel("Last Name");
        genderLbl = new JLabel("Gender");
        emailAddressLbl = new JLabel("Email Address");
        phoneNoLbl = new JLabel("Phone Number");
        locationAddressLbl = new JLabel("Location Address");
        nationalIDLbl = new JLabel("National ID Number");
        roleLbl = new JLabel("Select Role");
        passcodeLbl = new JLabel("Passcode");

        firstNameEntry = new JTextField();
        middleNameEntry = new JTextField();
        lastNameEntry = new JTextField();
        emailAddressEntry = new JTextField();
        phoneNoEntry = new JTextField();
        locationAddressEntry = new JTextField();
        nationalIDEntry = new JTextField();
        passcodeEntry = new JPasswordField();

        widgets = new ArrayList<Object>();

        widgets.add(firstNameEntry);
        widgets.add(middleNameEntry);
        widgets.add(lastNameEntry);
        widgets.add(emailAddressEntry);
        widgets.add(phoneNoEntry);
        widgets.add(locationAddressEntry);
        widgets.add(nationalIDEntry);
        widgets.add(passcodeEntry);
        widgets.add(genderEntry);
        widgets.add(roleEntry);

        String[] gender = {"Male", "Female"};
        genderEntry = new JComboBox(gender);

        roleEntry = new JComboBox(mapRoleId.keySet().toArray(new String[0]));

        submitBtn = new JButton("submit");
        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                if (action()) {
                    JOptionPane.showMessageDialog(null, "User Registration Successful!",
                            "User Registration", JOptionPane.INFORMATION_MESSAGE);
                    FieldValidator.cleanUp(widgets);
                }
            }
        });

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        layout.rowWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
                1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
        layout.columnWeights = new double[] {0.2, 0.8};

        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.fill = GridBagConstraints.BOTH;
        gbc1.insets = new Insets(10, 50, 10, 50);
        gbc1.gridwidth = 2;
        this.add(titleLbl, gbc1);

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gbc2.fill = GridBagConstraints.BOTH;
        gbc2.insets = new Insets(10, 50, 10, 10);
        this.add(firstNameLbl, gbc2);
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 1;
        gbc3.gridy = 1;
        gbc3.fill = GridBagConstraints.BOTH;
        gbc3.insets = new Insets(10, 10, 10, 50);
        this.add(firstNameEntry, gbc3);

        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 0;
        gbc4.gridy = 2;
        gbc4.fill = GridBagConstraints.BOTH;
        gbc4.insets = new Insets(10, 50, 10, 10);
        this.add(middleNameLbl, gbc4);
        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridx = 1;
        gbc5.gridy = 2;
        gbc5.fill = GridBagConstraints.BOTH;
        gbc5.insets = new Insets(10, 10, 10, 50);
        this.add(middleNameEntry, gbc5);

        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.gridx = 0;
        gbc6.gridy = 3;
        gbc6.fill = GridBagConstraints.BOTH;
        gbc6.insets = new Insets(10, 50, 10, 10);
        this.add(lastNameLbl, gbc6);
        GridBagConstraints gbc7 = new GridBagConstraints();
        gbc7.gridx = 1;
        gbc7.gridy = 3;
        gbc7.fill = GridBagConstraints.BOTH;
        gbc7.insets = new Insets(10, 10, 10, 50);
        this.add(lastNameEntry, gbc7);

        GridBagConstraints gbc8 = new GridBagConstraints();
        gbc8.gridx = 0;
        gbc8.gridy = 4;
        gbc8.fill = GridBagConstraints.BOTH;
        gbc8.insets = new Insets(10, 50, 10, 10);
        this.add(genderLbl, gbc8);
        GridBagConstraints gbc9 = new GridBagConstraints();
        gbc9.gridx = 1;
        gbc9.gridy = 4;
        gbc9.fill = GridBagConstraints.BOTH;
        gbc9.insets = new Insets(10, 10, 10, 50);
        this.add(genderEntry, gbc9);

        GridBagConstraints gbc10 = new GridBagConstraints();
        gbc10.gridx = 0;
        gbc10.gridy = 5;
        gbc10.fill = GridBagConstraints.BOTH;
        gbc10.insets = new Insets(10, 50, 10, 10);
        this.add(emailAddressLbl, gbc10);
        GridBagConstraints gbc11 = new GridBagConstraints();
        gbc11.gridx = 1;
        gbc11.gridy = 5;
        gbc11.fill = GridBagConstraints.BOTH;
        gbc11.insets = new Insets(10, 10, 10, 50);
        this.add(emailAddressEntry, gbc11);

        GridBagConstraints gbc12 = new GridBagConstraints();
        gbc12.gridx = 0;
        gbc12.gridy = 6;
        gbc12.fill = GridBagConstraints.BOTH;
        gbc12.insets = new Insets(10, 50, 10, 10);
        this.add(phoneNoLbl, gbc12);
        GridBagConstraints gbc13 = new GridBagConstraints();
        gbc13.gridx = 1;
        gbc13.gridy = 6;
        gbc13.fill = GridBagConstraints.BOTH;
        gbc13.insets = new Insets(10, 10, 10, 50);
        this.add(phoneNoEntry, gbc13);

        GridBagConstraints gbc14 = new GridBagConstraints();
        gbc14.gridx = 0;
        gbc14.gridy = 7;
        gbc14.fill = GridBagConstraints.BOTH;
        gbc14.insets = new Insets(10, 50, 10, 10);
        this.add(locationAddressLbl, gbc14);
        GridBagConstraints gbc15 = new GridBagConstraints();
        gbc15.gridx = 1;
        gbc15.gridy = 7;
        gbc15.fill = GridBagConstraints.BOTH;
        gbc15.insets = new Insets(10, 10, 10, 50);
        this.add(locationAddressEntry, gbc15);

        GridBagConstraints gbc16 = new GridBagConstraints();
        gbc16.gridx = 0;
        gbc16.gridy = 8;
        gbc16.fill = GridBagConstraints.BOTH;
        gbc16.insets = new Insets(10, 50, 10, 10);
        this.add(nationalIDLbl, gbc16);
        GridBagConstraints gbc17 = new GridBagConstraints();
        gbc17.gridx = 1;
        gbc17.gridy = 8;
        gbc17.fill = GridBagConstraints.BOTH;
        gbc17.insets = new Insets(10, 10, 10, 50);
        this.add(nationalIDEntry, gbc17);

        GridBagConstraints gbc18 = new GridBagConstraints();
        gbc18.gridx = 0;
        gbc18.gridy = 9;
        gbc18.fill = GridBagConstraints.BOTH;
        gbc18.insets = new Insets(10, 50, 10, 10);
        this.add(roleLbl, gbc18);
        GridBagConstraints gbc19 = new GridBagConstraints();
        gbc19.gridx = 1;
        gbc19.gridy = 9;
        gbc19.fill = GridBagConstraints.BOTH;
        gbc19.insets = new Insets(10, 10, 10, 50);
        this.add(roleEntry, gbc19);

        GridBagConstraints gbc20 = new GridBagConstraints();
        gbc20.gridx = 0;
        gbc20.gridy = 10;
        gbc20.fill = GridBagConstraints.BOTH;
        gbc20.insets = new Insets(10, 50, 10, 10);
        this.add(passcodeLbl, gbc20);
        GridBagConstraints gbc21 = new GridBagConstraints();
        gbc21.gridx = 1;
        gbc21.gridy = 10;
        gbc21.fill = GridBagConstraints.BOTH;
        gbc21.insets = new Insets(10, 10, 10, 50);
        this.add(passcodeEntry, gbc21);

        GridBagConstraints gbc22 = new GridBagConstraints();
        gbc22.gridx = 0;
        gbc22.gridy = 11;
        gbc22.insets = new Insets(10, 50, 10, 50);
        gbc22.fill = GridBagConstraints.BOTH;
        gbc22.gridwidth = 2;
        this.add(submitBtn, gbc22);

        this.setVisible(true);
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
            String nationalID = nationalIDEntry.getText().trim();
            String passcode = new String(passcodeEntry.getPassword()).trim();
            String gender = (String) genderEntry.getSelectedItem();

            String role = (String) roleEntry.getSelectedItem();
            int roleId = mapRoleId.get(role);

            success = userManager.registerUser(firstName, middleName, lastName,
                    emailAddress, phoneNo, locationAddress, nationalID,
                    passcode, gender, roleId);

            if (!(success))
            {
                JOptionPane.showMessageDialog(null, "User Registration Failed!",
                        "User Registration", JOptionPane.WARNING_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please fill in all required fields",
                    "User Registration", JOptionPane.WARNING_MESSAGE);
        }
        return success;
    }
}