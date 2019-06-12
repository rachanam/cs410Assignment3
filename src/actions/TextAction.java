package actions;

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class TextAction implements ActionListener {
    protected JTextPane textPane;

    public TextAction(JTextPane textPane) {
        this.textPane = textPane;
    }
}
