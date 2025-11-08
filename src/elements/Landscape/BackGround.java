package elements.Landscape;

import java.awt.*;

public class BackGround {
   private int x;
   private int y;

   public BackGround(int x, int y){
      this.x = x;
      this.y = y;
   }

   public void draw(Graphics2D g, int width, int height){
       g.setColor(new Color(135,206,255));
       g.fillRect(0, 0, width, (int)(0.62*height));
       g.setColor(new Color(34,139,34));
       g.fillRect(0, (int)(0.62*height), width, (int)(0.12*height));
       g.setColor(new Color(65,105,225));
       g.fillRect(0, (int)(0.74*height), width, (int)(0.26*height));


   }
}
