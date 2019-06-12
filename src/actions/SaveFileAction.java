package actions;

import utilities.RecentFilesManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveFileAction extends TextAction {
    private RecentFilesManager recentFilesManager;

    public SaveFileAction(JTextPane textPane, RecentFilesManager recentFilesManager) {
        super(textPane);
        this.recentFilesManager = recentFilesManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        File fileToWrite = null;
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showSaveDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            fileToWrite = fc.getSelectedFile();
            String path = fileToWrite.getAbsolutePath();
            this.recentFilesManager.AddRecentFile(path, new OpenFileAction(this.textPane, path));
        }
        try {
            PrintWriter out = new PrintWriter(new FileWriter(fileToWrite));
            out.println(this.textPane.getText());
            JOptionPane.showMessageDialog(null, "File is saved successfully...");
            out.close();
        } catch (IOException ex) {
        }
    }
}