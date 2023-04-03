package org.example.Lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static java.awt.geom.Line2D.ptSegDistSq;

public class DrawingPanel extends JLayeredPane implements Serializable, MouseListener {
    Line2D line;
    List<Line2D> listOfLines = new ArrayList<>();

    List<Line2D> listRed = new ArrayList<>();
    List<Line2D> listBlue = new ArrayList<>();
    List<Color> lineColor=new ArrayList<>();
    final MainFrame frame;
    final static int W = 800, H = 600;
    private int numVertices;
    private int color = 0;
    private double edgeProbability;
    private int[] x, y;
    static BufferedImage image; //the offscreen image
    static Graphics2D graphics; //the tools needed to draw in the image

    public DrawingPanel(MainFrame frame, Integer numVertices, Double edgeProbability) {
        this.frame = frame;
//        this.numVertices = numVertices;
//        this.edgeProbability = edgeProbability;
       // createOffscreenImage();
        initPanel();
        createBoard(numVertices, edgeProbability,0);
    }

    public int getNumVertices() {
        return numVertices;
    }

    public double getEdgeProbability() {
        return edgeProbability;
    }

    public void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        addMouseListener(this);
    }

    public List<Color> getLineColor() {
        return lineColor;
    }

    public void colorLines()
    {
        for(int i=0;i<listOfLines.size();i++)
        {
            graphics.setColor(lineColor.get(i));
            graphics.draw(listOfLines.get(i));
            validate();
            repaint();
        }
    }
    private void checkTriangleRed() {
        double x1, x2, y1, y2;
        double x3, x4, y3, y4;
        double x5, x6, y5, y6;
        for (int i = 0; i < listRed.size(); i++) {
            x1 = listRed.get(i).getX1();
            x2 = listRed.get(i).getX2();
            y1 = listRed.get(i).getY1();
            y2 = listRed.get(i).getY2();
            for (int j = 0; j < listRed.size(); j++) {
                if (j != i) {
                    x3 = listRed.get(j).getX1();
                    x4 = listRed.get(j).getX2();
                    y3 = listRed.get(j).getY1();
                    y4 = listRed.get(j).getY2();
                    if (x1 == x3 && y1 == y3) {
                        for (int z = 0; z < listRed.size(); z++) {
                            if (z != i && z != j) {
                                x5 = listRed.get(z).getX1();
                                x6 = listRed.get(z).getX2();
                                y5 = listRed.get(z).getY1();
                                y6 = listRed.get(z).getY2();
                                if (x2 == x6 && y2 == y6 && x4 == x5 && y4 == y5) {
                                    // System.out.println("triunghi");
                                    graphics.setColor(Color.WHITE);
                                    graphics.fillRect(0, 0, 800, 600);
                                    graphics.setColor(Color.red);
                                    graphics.drawString("Red Won!", 400, 400);
                                }
                            }
                        }
                    }

                }

            }
        }

    }

    private void checkTriangleBlue() {
        double x1, x2, y1, y2;
        double x3, x4, y3, y4;
        double x5, x6, y5, y6;
        for (int i = 0; i < listBlue.size(); i++) {
            x1 = listBlue.get(i).getX1();
            x2 = listBlue.get(i).getX2();
            y1 = listBlue.get(i).getY1();
            y2 = listBlue.get(i).getY2();
            for (int j = 0; j < listBlue.size(); j++) {
                if (j != i) {
                    x3 = listBlue.get(j).getX1();
                    x4 = listBlue.get(j).getX2();
                    y3 = listBlue.get(j).getY1();
                    y4 = listBlue.get(j).getY2();
                    if (x1 == x3 && y1 == y3) {
                        for (int z = 0; z < listBlue.size(); z++) {
                            if (z != i && z != j) {
                                x5 = listBlue.get(z).getX1();
                                x6 = listBlue.get(z).getX2();
                                y5 = listBlue.get(z).getY1();
                                y6 = listBlue.get(z).getY2();
                                if (x2 == x6 && y2 == y6 && x4 == x5 && y4 == y5) {
                                    //System.out.println("triunghi");
                                    graphics.setColor(Color.WHITE);
                                    graphics.fillRect(0, 0, 800, 600);
                                    graphics.setColor(Color.blue);
                                    graphics.drawString("Blue Won!", 400, 400);
                                }
                            }
                        }
                    }

                }

            }
        }

    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);
    }

    final void createBoard(Integer numVertices, Double edgeProbability,int load) {
        if(load==0)
        {
          listOfLines = new ArrayList<>();
          listRed = new ArrayList<>();
          listBlue = new ArrayList<>();
          lineColor=new ArrayList<>();
            color=0;
        }
        this.numVertices = numVertices;
        this.edgeProbability = edgeProbability;
//        addMouseListener(this);
        createOffscreenImage();
        if(load==0)
        {
            createVertices();
            drawVertices();
            drawLines();
        }
        if(load==1) {
            drawVertices();
            colorLines();
        }
        repaint(); // trigger JPanel's paintComponent method
    }

    private void drawVertices() {
        for (int i = 0; i < numVertices; i++) {
            graphics.setColor(Color.BLACK);
            graphics.fillOval(x[i], y[i], 3, 3);
            graphics.drawOval(x[i], y[i], 3, 3);
        }
    }

    private void createVertices() {
        int x0 = W / 2;
        int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / numVertices; // the angle
        x = new int[numVertices];
        y = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
        }
    }

    private void drawLines() {
        Random rd = new Random();
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (rd.nextFloat() <= edgeProbability) {
                    line = new Line2D.Double(x[i], y[i], x[j], y[j]);
                    listOfLines.add(line);
                    graphics.setColor(Color.BLACK);
                    lineColor.add(Color.BLACK);
                    graphics.draw(line);
                    rd.nextFloat();
                }
            }
        }

    }

    //Draw the offscreen image, using the original graphics
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
       // System.out.println(lineColor);
       // colorLines();
        graphics.drawImage(image, 0, 0, this);
        this.repaint();
    }

    @Override
    public String toString() {
        return "DrawingPanel{" +
                "numVertices=" + numVertices +
                ", color=" + color +
                ", edgeProbability=" + edgeProbability +
                ", lineColor="+ lineColor+
                '}';
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        for(int i=0;i<listOfLines.size();i++)
        {
            if(ptSegDistSq(listOfLines.get(i).getX1(), listOfLines.get(i).getY1(), listOfLines.get(i).getX2(), listOfLines.get(i).getY2(), x, y) < 2)
            {
                if (color % 2 == 0) {
                    graphics.setColor(Color.red);
                    lineColor.set(i,Color.red);
                    listRed.add(listOfLines.get(i));
                }
                else {
                    graphics.setColor(Color.blue);
                    //lineColor.add(i,Color.BLUE);
                    lineColor.set(i, Color.blue);
                    listBlue.add(listOfLines.get(i));
                }
                graphics.draw(listOfLines.get(i));
                checkTriangleRed();
                checkTriangleBlue();
                System.out.println("frame= "+color);
                System.out.println();
                color++;
                break;
            }
        }

        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}