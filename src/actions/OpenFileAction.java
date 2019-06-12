package actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import utilities.RecentFilesManager;

public class OpenFileAction extends TextAction {
    private String filePath;
    private RecentFilesManager recentFilesManager;

    // For opening a file using new file menu
    public OpenFileAction(JTextPane textPane, RecentFilesManager recentFilesManager) {
        super(textPane);
        this.recentFilesManager = recentFilesManager;
    }

    // For opening file using Recent menu
    public OpenFileAction(JTextPane textPane, String filePath) {
        super(textPane);
        this.filePath = filePath;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String path = this.filePath;
        if (path == null) {
            JFileChooser fc = new JFileChooser();
            int returnVal = fc.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File fileToRead = fc.getSelectedFile();
                path = fileToRead.getAbsolutePath();
                this.recentFilesManager.AddRecentFile(path, new OpenFileAction(this.textPane, path));
            }
        }

        if (path != null) {
            try {
                String fileString = new String(Files.readAllBytes(Paths.get(path)));
                this.textPane.setText(fileString);
            } catch (IOException ex) {
            }
        }
    }
}