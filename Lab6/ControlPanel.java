package org.example.Lab6;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        add(exitBtn);
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        saveBtn.addActionListener(this::saveGame);
        exitBtn.addActionListener(this::exitGame);
        loadBtn.addActionListener(this::loadGame);
        resetBtn.addActionListener(this::resetGame);
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    private void saveGame(ActionEvent e) {
        JPanel panel = new JPanel();
        final JLabel label = new JLabel();
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(frame);
        if(option == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            label.setText("File Saved as: " + file.getName());
        }else{
            label.setText("Save command canceled");
        }
    }

    private void loadGame(ActionEvent e) {
        JPanel panel = new JPanel();
        final JLabel label = new JLabel();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);

        int option = fileChooser.showOpenDialog(frame);
        if(option == JFileChooser.APPROVE_OPTION){
            File[] files = fileChooser.getSelectedFiles();
            String fileNames = "";
            for(File file: files){
                fileNames += file.getName() + " ";
            }
            label.setText("File(s) Selected: " + fileNames);
        }else{
            label.setText("Open command canceled");
        }
    }

    private void resetGame(ActionEvent e) {
        frame.getContentPane().removeAll();
        frame.repaint();
        repaint();
        init();
    }
}