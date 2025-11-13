package elements.Landscape;

import java.awt.*;
import java.awt.geom.Path2D;

public class BackGround {
   private int x;
   private int y;

   public BackGround(int x, int y){
      this.x = x;
      this.y = y;
   }

   public void draw(Graphics2D g, int width, int height){

       // небо
       g.setColor(new Color(135,206,255));
       g.fillRect(0, 0, width, (int)(0.7*height));

       // горы
       drawMountain(g, 680, 180, 600, 560, 780, 560, new Color(150,150,170));
       drawSnowCap(g, 680, 180, 600, 560, 780, 560, new Color(255,255,255), 0.16);
       drawMountain(g, 880, 100, 740, 560, 1000, 560, new Color(128,128,128));
       drawSnowCap(g, 880, 100, 740, 560, 1000, 560, new Color(255,255,255), 0.23);
       drawMountain(g, 560, 165, 475, 560, 670, 560, new Color(128,128,140));
       drawSnowCap(g,560, 165, 475, 560, 670, 560, new Color(255,255,255), 0.18);
       drawMountain(g, 430, 280, 355, 560, 485, 560, new Color(128,128,128));
       drawMountain(g, 220, 245, 35, 560, 340, 560, new Color(150,150,160));

       // холмы
       Path2D.Double hillRight = new Path2D.Double();
       g.setColor(new Color(0,140,40));
       hillRight.moveTo(660,470);
       hillRight.curveTo(600, 480, 560, 525, 440, 560);
       hillRight.moveTo(660,470);
       hillRight.curveTo(710, 480, 760, 525, 820, 560);
       hillRight.lineTo(440, 560);
       g.fill(hillRight);
       Path2D.Double hillCentre = new Path2D.Double();
       g.setColor(new Color(0,128,0));
       hillCentre.moveTo(1000, 420);
       hillCentre.curveTo(980, 460, 860, 500, 790, 560);
       hillCentre.lineTo(1000, 560);
       hillCentre.lineTo(1000, 420);
       hillCentre.closePath();
       g.fill(hillCentre);
       Path2D.Double hillLeft = new Path2D.Double();
       g.setColor(new Color(0,128,0));
       hillLeft.moveTo(0, 420);
       hillLeft.curveTo(60, 480, 100, 525, 220, 560);
       hillLeft.lineTo(0, 560);
       hillLeft.lineTo(0, 420);
       g.fill(hillLeft);


       // берег
       g.setColor(new Color(0,115,0));
       g.fillRect(0, (int)(0.7*(height)), width, (int)(0.07*height));

       // море
       g.setColor(new Color(50, 100, 150));
       g.fillRect(0, (int)(0.77*height), width, (int)(0.23*height));
   }
    public void drawMountain(Graphics2D g,
                             double topX, double topY,
                             double bottomLeftX, double bottomLeftY,
                             double bottomRightX, double bottomRightY,
                             Color color) {
        Path2D.Double triangle = new Path2D.Double();
        triangle.moveTo(topX, topY);           // верхняя вершина
        triangle.lineTo(bottomLeftX, bottomLeftY);  // левая нижняя
        triangle.lineTo(bottomRightX, bottomRightY); // правая нижняя
        triangle.closePath();

        g.setColor(color);

        g.fill(triangle);
    }
    public void drawSnowCap(Graphics2D g,
                            double topX, double topY,
                            double bottomLeftX, double bottomLeftY,
                            double bottomRightX, double bottomRightY,
                            Color snowColor,
                            double snowRatio) {

        if (snowRatio <= 0 || snowRatio >= 1) return;


        double snowLeftX  = topX + (bottomLeftX  - topX) * snowRatio;
        double snowLeftY  = topY + (bottomLeftY  - topY) * snowRatio;
        double snowRightX = topX + (bottomRightX - topX) * snowRatio;
        double snowRightY = topY + (bottomRightY - topY) * snowRatio;

        Path2D.Double snowTriangle = new Path2D.Double();
        snowTriangle.moveTo(topX, topY);
        snowTriangle.lineTo(snowLeftX, snowLeftY);
        snowTriangle.lineTo(snowRightX, snowRightY);
        snowTriangle.closePath();

        g.setColor(snowColor);

        g.fill(snowTriangle);
    }

}
