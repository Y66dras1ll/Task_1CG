package elements.Landscape;

import java.awt.*;
import java.awt.geom.Path2D;

public class Castle {
    private final double x;
    private final double y;

    public Castle(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g) {
        Color wallColor = new Color(227, 226, 222);
        Color darkerWallColor = new Color(218, 215, 208);
        Color innerTowerColor = new Color(206, 205, 201);
        Color fenceColor = new Color(195, 190, 186);
        Color roofColor = new Color(85, 123, 124);
        Color darkColor = new Color(0, 0, 20);
        Color roksColor = new Color(78, 90, 101);

        g.setColor(darkerWallColor);
        g.fillRect(90, 445, 200, 81);

        g.setColor(roofColor);
        g.fillRect(90, 425, 200, 20);


        g.setColor(darkColor);

        for (int i = 0; i < 6; i++) {
            int winX = 105 + (i * 30);
            g.fillRect(winX, 455, 12, 12);

            g.fillRect(winX, 485, 12, 12);
        }


        g.setColor(innerTowerColor);
        g.fillRect(60, 390, 30, 136);
        g.fillRect(290, 390, 30, 136);

        g.setColor(darkColor);
        g.fillOval(67, 400, 16, 16);
        g.fillOval(297, 400, 16, 16);

        drawRoofAndFence(g,
                75, 310,
                60, 390,
                90, 390,
                roofColor);

        drawRoofAndFence(g,
                305, 310,
                290, 390,
                320, 390,
                roofColor);


        g.setColor(wallColor);
        g.fillRect(0, 480, 40, 320);
        g.fillRect(340, 480, 40, 320);

        g.fillRect(40, 526, 300, 274);

        for (int i = 0; i < 15; i++) {
            double startX = 40 + (i * 20);
            double endX = startX + 20;
            double peakX = startX + 10;
            double baseY = 526;
            double peakY = 506;

            drawRoofAndFence(g,
                    peakX, peakY,
                    startX, baseY,
                    endX, baseY,
                    fenceColor
            );
        }

        g.setColor(darkColor);
        for (int i = 0; i < 5; i++) {
            g.fillOval(
                    40 + 22 + (i * 55),
                    547,
                    36,
                    233
            );
        }

        drawRoofAndFence(g,
                20, 430,
                0, 480,
                40, 480,
                roofColor);

        drawRoofAndFence(g,
                360, 430,
                340, 480,
                380, 480,
                roofColor);


        g.setColor(roksColor);
        g.fillRect(0, 735,440 , 65);
        Path2D.Double cragsLeft = new Path2D.Double();
        cragsLeft.moveTo(0, 550);
        cragsLeft.curveTo(40, 560, 60, 700, 80, 735);
        cragsLeft.lineTo(0, 735);
        cragsLeft.lineTo(0, 550);
        cragsLeft.closePath();
        g.fill(cragsLeft);

        Path2D.Double cragsRight = new Path2D.Double();
        cragsRight.moveTo(370,546);
        cragsRight.curveTo(350, 560, 340, 600, 290, 735);
        cragsRight.moveTo(370,546);
        cragsRight.curveTo(380, 560, 420, 620, 440, 735);
        cragsRight.lineTo(290, 735);
        cragsRight.closePath();
        g.fill(cragsRight);


    }

    public void drawRoofAndFence(Graphics2D g,
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
}