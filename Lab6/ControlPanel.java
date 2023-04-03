package org.example.Lab6;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

import static java.awt.BorderLayout.CENTER;
import static org.example.Lab6.ConfigPanel.*;
import static org.example.Lab6.DrawingPanel.image;
import static org.example.Lab6.MainFrame.canvas;

public class ControlPanel extends JPanel implements Serializable {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exportBtn = new JButton("Export");

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
        add(exportBtn);
        saveBtn.addActionListener(this::saveGame);
        exitBtn.addActionListener(this::exitGame);
        loadBtn.addActionListener(this::loadGame);
        resetBtn.addActionListener(this::resetGame);
        exportBtn.addActionListener(this::exportGame);
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
    private void exportGame(ActionEvent e)
    {
        JPanel panel = new JPanel();
        final JLabel label = new JLabel();
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(frame);
        if(option == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            label.setText("File Saved as: " + file.getName());
            try {
                ImageIO.write(image, "png", file);
            }
            catch(Exception ex)
            {
                System.out.println("Nu se poate salva");
            }
        }else{
            label.setText("Save command canceled");
        }
    }

    private void saveGame(ActionEvent e) {
        File file1 = new File("./fileTest.txt");
        OutputStream fos = null;
        try {
            fos = new FileOutputStream(file1);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(fos);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        DrawingPanel canvas2 = canvas;
        System.out.println(canvas2.toString());
        try {
            oos.writeObject(canvas2);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
//        oos.flush();
//        oos.close();
//        fos.flush();
//        fos.close();
    }

    private void loadGame(ActionEvent e) {
//        JPanel panel = new JPanel();
//        final JLabel label = new JLabel();
//        JFileChooser fileChooser = new JFileChooser();
//        fileChooser.setMultiSelectionEnabled(true);
//
//        int option = fileChooser.showOpenDialog(frame);
//        if(option == JFileChooser.APPROVE_OPTION){
//            File[] files = fileChooser.getSelectedFiles();
//            String fileNames = "";
//            for(File file: files){
//                fileNames += file.getName() + " ";
//            }
//            label.setText("File(s) Selected: " + fileNames);
//        }else{
//            label.setText("Open command canceled");
//        }
        File file = new File("./fileTest.txt");
        InputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        try {
            remove(frame);
            remove(canvas);
            canvas=null;
           canvas = (DrawingPanel) ois.readObject();
            System.out.println(canvas.toString());
            updateData();
           // System.out.println(canvas.getNumVertices());
            canvas.createBoard(canvas.getNumVertices(), canvas.getEdgeProbability(),1);
            ////System.out.println(canvas.getLineColor());
//            canvas.colorLines();
            canvas.repaint();
            frame.repaint();
            //add(canvas,CENTER);
        } catch (IOException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        // fis.close();
    }

    private void resetGame(ActionEvent e) {
        remove(frame);
//        canvas.repaint();
//        canvas=null;
//      canvas=new DrawingPanel(frame);
//        canvas.repaint();
//        SwingUtilities.invokeLater( new Runnable() {
//
//            public void run() {
//                canvas.requestFocusInWindow();
//            }
//        } );
        updateData();
//        frame.setVisible(true);
        canvas.createBoard(numVertices,edgeProbability,0);
        canvas.repaint();
        frame.repaint();
    }
}