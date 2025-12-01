package elements.Landscape;

import java.awt.*;
import java.awt.geom.Path2D;

public class BackGround {
   private int x;
   private int y;
   private static final Color SNOW_COLOR = new Color(255, 255, 255);
   private static final Color DEFAULT_MOUNTAIN_COLOR = new Color(128, 128, 128);

   public BackGround(int x, int y){
      this.x = x;
      this.y = y;
   }

   public void draw(Graphics2D g, int width, int height){
       // Небо
       g.setColor(new Color(135,206,255));
       g.fillRect(0, 0, width, (int)(0.7*height));

       // Горы
       drawMountain(g, 680, 180,
               600, 560,
               780, 560,
               new Color(150,150,170));
       drawSnowCap(g, 680, 180,
               600, 560,
               780, 560,
               SNOW_COLOR,
               0.16);

       drawMountain(g, 880, 100,
               740, 560,
               1000, 560,
               DEFAULT_MOUNTAIN_COLOR);
       drawSnowCap(g, 880, 100,
               740, 560,
               1000, 560,
               SNOW_COLOR,
               0.23);

       drawMountain(g, 560, 165,
               475, 560,
               670, 560,
               new Color(128,128,140));
       drawSnowCap(g,560, 165,
               475, 560,
               670, 560,
               SNOW_COLOR,
               0.18);

       drawMountain(g, 430, 280,
               355, 560,
               485, 560,
               DEFAULT_MOUNTAIN_COLOR);

       drawMountain(g, 220, 230,
               29, 560,
               346, 560,
               new Color(150,150,160));

       // Три холма
       Path2D.Double hillCentre = new Path2D.Double();
       g.setColor(new Color(0,140,40));
       hillCentre.moveTo(660,470);
       hillCentre.curveTo(600, 480, 560, 525, 440, 560);
       hillCentre.moveTo(660,470);
       hillCentre.curveTo(710, 480, 760, 525, 820, 560);
       hillCentre.lineTo(440, 560);
       hillCentre.closePath();
       g.fill(hillCentre);

       Path2D.Double hillRight = new Path2D.Double();
       g.setColor(new Color(0,128,0));
       hillRight.moveTo(1000, 420);
       hillRight.curveTo(980, 460, 860, 500, 790, 560);
       hillRight.lineTo(1000, 560);
       hillRight.lineTo(1000, 420);
       hillRight.closePath();
       g.fill(hillRight);

       Path2D.Double hillLeft = new Path2D.Double();
       g.setColor(new Color(0,128,0));
       hillLeft.moveTo(0, 405);
       hillLeft.curveTo(30, 420, 100, 458, 220, 560);
       hillLeft.lineTo(0, 560);
       hillLeft.lineTo(0, 420);
       hillLeft.closePath();
       g.fill(hillLeft);

       // Берег
       g.setColor(new Color(0,115,0));
       g.fillRect(0, (int)(0.7*(height)), width, (int)(0.07*height));

       // Водоём
       g.setColor(new Color(50, 100, 150));
       g.fillRect(0, (int)(0.77*height), width, (int)(0.23*height));
   }
    public void drawMountain(Graphics2D g,
                             double topX, double topY,
                             double bottomLeftX, double bottomLeftY,
                             double bottomRightX, double bottomRightY,
                             Color color) {
        Path2D.Double triangle = new Path2D.Double();
        triangle.moveTo(topX, topY);
        triangle.lineTo(bottomLeftX, bottomLeftY);
        triangle.lineTo(bottomRightX, bottomRightY);
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
