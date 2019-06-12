package actions;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PasteAction extends TextAction {
    public PasteAction(JTextPane textPane) {
        super(textPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.textPane.paste();
    }
}
