package satproje.listener;

import javax.swing.*;

import static satproje.listener.veriables.textFieldEntries;

/** TextFieldEntry sınıfı, bir metin alanı ve alan adını içeren öğeleri temsil eder.*/
public class TextFieldEntry {
    private String fieldName;
    private JTextField textField;


    public TextFieldEntry(String fieldName, JTextField textField) {
        this.fieldName = fieldName;
        this.textField = textField;
    }

    public String getFieldName() {
        return fieldName;
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextFieldValue(String value) {
        textField.setText(value);
    }

    public static TextFieldEntry findTextFieldEntry(String fieldName) {
        for (TextFieldEntry textFieldEntry : textFieldEntries) {
            if (textFieldEntry.getFieldName().equals(fieldName)) {
                return textFieldEntry;
            }
        }
        return null;
    }
}
