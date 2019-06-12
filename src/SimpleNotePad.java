import actions.*;
import utilities.*;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class SimpleNotePad extends JFrame {
    JMenuBar mb = new JMenuBar();
    JMenu filesMenu = new JMenu("File");
    JMenu recentFilesMenu = new JMenu("Recent");
    JMenu editMenu = new JMenu("Edit");
    JTextPane textPane = new JTextPane();

    RecentFilesManager recentFilesManager = new RecentFilesManager(recentFilesMenu);

    public SimpleNotePad() {
        setTitle("A Simple Notepad Tool");
        filesMenu.add(MenuItemUtility.GetMenuItem("Open", new OpenFileAction(textPane, recentFilesManager)));
        filesMenu.add(MenuItemUtility.GetMenuItem("New File", new NewFileAction(textPane)));
        filesMenu.add(MenuItemUtility.GetMenuItem("Save File", new SaveFileAction(textPane, recentFilesManager)));
        filesMenu.add(MenuItemUtility.GetMenuItem("Print File", new PrintFileAction(textPane)));
        filesMenu.add(recentFilesMenu);
        editMenu.add(MenuItemUtility.GetMenuItem("Replace", new ReplaceAction(textPane)));
        editMenu.add(MenuItemUtility.GetMenuItem("Copy", new CopyAction(textPane)));
        editMenu.add(MenuItemUtility.GetMenuItem("Paste", new PasteAction(textPane)));
        mb.add(filesMenu);
        mb.add(editMenu);
        setJMenuBar(mb);
        add(new JScrollPane(textPane));
        setPreferredSize(new Dimension(600,600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    public static void main(String[] args) {
        SimpleNotePad app = new SimpleNotePad();
    }
}