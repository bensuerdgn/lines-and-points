/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package square;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

interface Variable {

    Random r = new Random();
    public int x = r.nextInt((600 - 100) + 1) + 100;
    public int y = r.nextInt((600 - 200) + 1) + 200;
}

class Surface extends JPanel implements Variable {

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        Random r = new Random();
        
        float[] dash={r.nextFloat(), r.nextFloat(), r.nextFloat()};

        for (int i = 20; i <= y; i = i + 40) {
            
            
            g2d.setPaint(new Color(Math.abs(r.nextInt()) % 255, Math.abs(r.nextInt()) % 255, Math.abs(r.nextInt()) % 255));
            
            g2d.setStroke(new BasicStroke((r.nextInt(10-1)+1)+1, BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_ROUND, 1.0f, dash, 2f));
            
            g2d.drawLine(i, 20, i, y);
            g2d.setStroke(new BasicStroke((r.nextInt(10-5)+1)+1, BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_ROUND, 1.0f, dash, 2f));
            g2d.drawLine(20, i, y, i);
        }
        g2d.dispose();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}

public class Square extends JFrame implements Variable {

    public Square() {

        initUI();
    }

    private void initUI() {
        add(new Surface());
        setTitle("Lines and Points");
        setSize(x, y);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                Square ex = new Square();
                ex.setVisible(true);
            }
        });
    }
}
