package elements.Objects;

import java.awt.*;
import java.util.Random;

public class Cloud {
    private double x;
    private final int y;
    private final double speed;
    private final int width;
    private final int height;

    public Cloud(int startX, int startY) {
        this.x = startX;
        this.y = startY;

        Random random = new Random();

        this.speed = 0.7 + random.nextDouble() * 1.2;

        this.width = 70 + random.nextInt(30);
        this.height = 40 + random.nextInt(20);
    }

    public void move() {
        x += speed;
    }

    public void draw(Graphics2D g) {
        Composite originalComposite = g.getComposite();

        g.setColor(new Color(255, 255, 255, 220));
        g.fillOval((int)x, y, width, height);

        g.setColor(new Color(255, 255, 255, 180));
        g.fillOval((int)x + 15, y - 20, width - 30, height);

        g.setColor(new Color(255, 255, 255, 140));
        g.fillOval((int)x - 25, y + 10, width / 2 + 10, height - 10);


        g.setColor(new Color(255, 255, 255, 140));
        g.fillOval((int)x + width - 20, y + 15, width / 2, height - 15);

        g.setComposite(originalComposite);
    }


    public boolean isOffScreen(int screenWidth) {
        return x > screenWidth + 100;
    }
}