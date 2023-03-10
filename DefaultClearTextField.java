package gui;

import javax.swing.*;

public class DefaultClearTextField extends JTextField implements ClearTextField {
    private boolean hasDefaultValue = true;
    private String defaultValue;

    public DefaultClearTextField(String defaultValue) {
        super(defaultValue);
        this.defaultValue = defaultValue;

        // Add a focus listener to clear the default value when the field is clicked
        this.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (hasDefaultValue) {
                    setText("");
                    hasDefaultValue = false;
                }
            }
        });
    }

    @Override
    public void setText(String text) {
        // Only set the text if it is not the default value
        if (defaultValue == null || !defaultValue.equals(text)) {
            super.setText(text);
            hasDefaultValue = false;
        }
    }

    @Override
    public void focusLost(java.awt.event.FocusEvent evt) {
        // If the field loses focus and the text is empty, set it back to the default value
        if (getText().isEmpty()) {
            super.setText(defaultValue);
            hasDefaultValue = true;
        }
    }
}
