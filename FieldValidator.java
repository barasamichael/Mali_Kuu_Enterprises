package gui;

import javax.swing.*;
import java.util.ArrayList;

public class FieldValidator {
    public static boolean validate(ArrayList<Object> fieldsList) {
        boolean flag = true;
        for (Object field : fieldsList) {
            if (field instanceof JTextField) {
                JTextField textField = (JTextField) field;
                if (textField.getText() == null ||
                        textField.getText().isEmpty())
                {
                    flag = false;
                    return flag;
                }
            } else if (field instanceof JComboBox) {
                JComboBox comboBox = (JComboBox) field;
                if (comboBox.getSelectedItem() == null) {
                    flag = false;
                    return flag;
                }
            }
        }
        return flag;
    }

    public static void cleanUp(ArrayList<Object> widgets)
    {
        for (Object item : widgets) {
            if (item instanceof JTextField)
            {
                ((JTextField) item).setText("");
            }
            else if (item instanceof JComboBox)
            {
                ((JComboBox<?>) item).setSelectedItem(null);
            }
        }
    }

}
