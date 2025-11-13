package elements.Objects;

import java.awt.*;

public class Tree {
    private final double x;
    private final double y;

    public Tree(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g) {

        Color originalColor = g.getColor();


        g.setColor(new Color(139, 69, 19));
        int stemWidth = 10;   // Ширина ствола
        int stemHeight = 19;  // Высота ствола

        g.fillRect(
                (int)(x - stemWidth / 2.0),
                (int)(y - stemHeight),
                stemWidth,
                stemHeight
        );


        g.setColor(new Color(34, 139, 34));
        int crownRadius = 14;

        double crownCenterX = x;
        double crownCenterY = y - stemHeight - crownRadius / 2.0;


        g.fillOval(
                (int)(crownCenterX - crownRadius),
                (int)(crownCenterY - crownRadius),
                crownRadius * 2,
                crownRadius * 2
        );


        g.setColor(originalColor);
    }
}