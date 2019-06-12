package actions;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CopyAction extends TextAction {
    public CopyAction(JTextPane textPane) {
        super(textPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.textPane.copy();
    }
}