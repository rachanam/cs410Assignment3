package utilities;

import javax.swing.*;
import java.awt.event.ActionListener;

public class RecentFilesManager {
    private JMenu recentFilesMenu;

    public RecentFilesManager(JMenu recentFilesMenu) {
        this.recentFilesMenu = recentFilesMenu;
    }

    public void AddRecentFile(String filePath, ActionListener actionListener) {
        this.recentFilesMenu.add(MenuItemUtility.GetMenuItem(filePath, actionListener));
    }
}
