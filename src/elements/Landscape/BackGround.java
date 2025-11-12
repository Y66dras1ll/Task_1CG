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

       drawMountain(g, 680, 180, 600, 560, 780, 560, new Color(150,150,170));
       drawSnowCap(g, 680, 180, 600, 560, 780, 560, new Color(255,255,255), 0.14);
       drawMountain(g, 880, 100, 740, 560, 1000, 560, new Color(128,128,128));
       drawSnowCap(g, 880, 100, 740, 560, 1000, 560, new Color(255,255,255), 0.18);

       // берег
       g.setColor(new Color(0,100,0));
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

        g.fill(snowTriangle); // Только fill — без draw!
    }

}
