package utilities;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MenuItemUtility {
    public static JMenuItem GetMenuItem(String itemName, ActionListener actionListener) {
        JMenuItem menuItem = new JMenuItem(itemName);
        menuItem.addActionListener(actionListener);
        return menuItem;
    }
}
