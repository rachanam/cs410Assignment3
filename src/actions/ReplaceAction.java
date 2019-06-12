package actions;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ReplaceAction extends TextAction {
    public ReplaceAction(JTextPane textPane) {
        super(textPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String replaceText = JOptionPane.showInputDialog("Replace or insert with");
        this.textPane.replaceSelection(replaceText);
    }
}