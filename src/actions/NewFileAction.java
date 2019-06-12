package actions;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class NewFileAction extends TextAction {
    public NewFileAction(JTextPane textPane) {
        super(textPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.textPane.setText("");
    }
}