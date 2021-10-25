package Flag;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

class Surface extends JPanel {
    private double height;
    private double width;
    private double widthPercent;
    private double radius;
    private double starLength;
    private double centerX;
    private double centerY;


    private void doDrawing(Graphics g) {
        height = getHeight();
        width = getWidth();
        radius = (height * 0.25) / 2;
        centerX = height * 0.825;
        centerY = height * 0.5;


        widthPercent = (width * 5) / 100;
        Graphics2D g2d = (Graphics2D) g.create();
        setBackground(Color.red);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setPaint(Color.WHITE);
        g2d.fillRect(0, 0, (int) widthPercent, (int) height);
        ay(g2d);
    }


    private void ay(Graphics2D g2d) {
        g2d.setPaint(Color.white);
        g2d.fillOval((int) (height * 0.30), (int) (height * 0.25), (int) ((height * 0.50)), (int) (height * 0.50));
        g2d.setPaint(Color.RED);
        g2d.fillOval((int) ((height * 0.35) + height * 1 / 16), (int) (height * 0.30), (int) ((height * 0.405)), (int) ((height * 0.40)));
        g2d.setPaint(Color.white);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
        doStar(g);
    }

    public void doStar(Graphics g) {
        double points[][] = {
                // x2 y2
                {centerX - radius * 2 / 6, centerY - radius * 5.5 / 6},
//                x1 y1
                {centerX - radius * 2 / 6, centerY - radius * 1.4 / 6},
//                x0 y0
                {centerX - radius, centerY},
//              x3 y3
                {centerX - radius * 2 / 6, centerY + radius * 1.4 / 6},
//              x4 y4
                {centerX - radius * 2 / 6, centerY + radius * 5.5 / 6},
//            --------------

                {centerX + radius * 0.5 / 6, centerY + radius * 2.2 / 6},
                {centerX + radius * 4.8 / 6, centerY + radius * 3.5 / 6},


                {centerX + radius * 2.1 / 6, centerY},
                {centerX + radius * 4.8 / 6, centerY - radius * 3.5 / 6},
                {centerX + radius * 0.5 / 6, centerY - radius * 2.2 / 6},
                {centerX - radius * 2 / 6, centerY - radius * 5.5 / 6}
        };

        Graphics2D g2d = (Graphics2D) g;
        GeneralPath star = new GeneralPath();
        star.moveTo(points[0][0], points[0][1]);
        g2d.setPaint(Color.WHITE);
        for (int k = 1; k < points.length; k++)
            star.lineTo(points[k][0], points[k][1]);
        star.closePath();
        g2d.fill(star);
        g2d.dispose();
    }

}

public class Flag extends JFrame {

    public Flag() {

        initUI();
    }


    private void initUI() {
        add(new Surface());
        double height = 250;
        double width = height + height / 2;
        setTitle("Star");
        setSize((int) width, (int) height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        Flag ex = new Flag();
        ex.setVisible(true);
    }
}
