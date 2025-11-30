package elements.Objects;

import java.awt.*;

public class Tree {
    private final double x;
    private final double y;

    private final int stemWidth;
    private final int stemHeight;
    private final int crownRadius;

    private final Color crownColor;
    private final Color stemColor;

    public Tree(double x, double y,
                int stemWidth, int stemHeight, int crownRadius,
                Color crownColor, Color stemColor) {
        this.x = x;
        this.y = y;
        this.stemWidth = stemWidth;
        this.stemHeight = stemHeight;
        this.crownRadius = crownRadius;
        this.crownColor = crownColor;
        this.stemColor = stemColor;
    }

    public void draw(Graphics2D g) {
        Color originalColor = g.getColor();

        g.setColor(stemColor);
        g.fillRect((int)(x - stemWidth / 2.0), (int)(y - stemHeight), stemWidth, stemHeight);

        g.setColor(crownColor);
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