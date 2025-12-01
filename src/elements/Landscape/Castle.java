package elements.Landscape;

import java.awt.*;
import java.awt.geom.Path2D;

public class Castle {
    private final double x;
    private final double y;
    private static final Color WALL_COLOR = new Color(227, 226, 222);
    private static final Color DARKER_WALL_COLOR = new Color(218, 215, 208);
    private static final Color DARK_COLOR = new Color(0, 0, 20);
    private static final Color INNER_TOWER_COLOR = new Color(206, 205, 201);
    private static final Color FENCE_COLOR = new Color(195, 190, 186);
    private static final Color ROOF_COLOR = new Color(85, 123, 124);
    private static final Color ROKS_COLOR = new Color(78, 90, 101);

    public Castle(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g) {
        // Главное здание замка
        g.setColor(DARKER_WALL_COLOR);
        g.fillRect(90, 445, 200, 81);

        g.setColor(ROOF_COLOR);
        g.fillRect(90, 425, 200, 20); // Крыша этого здания

        // Два ряда окон в здании
        g.setColor(DARK_COLOR);
        for (int i = 0; i < 6; i++) {
            int winX = 105 + (i * 30);
            g.fillRect(winX, 455, 12, 12);

            g.fillRect(winX, 485, 12, 12);
        }

        // Две башни по бокам главного здания (внутренние башни)
        g.setColor(INNER_TOWER_COLOR);
        g.fillRect(60, 390, 30, 136);
        g.fillRect(290, 390, 30, 136);

        // Окна в башнях
        g.setColor(DARK_COLOR);
        g.fillOval(67, 400, 16, 16);
        g.fillOval(297, 400, 16, 16);

        // Крыши башен
        drawRoofAndFence(g,
                75, 310,
                60, 390,
                90, 390,
                ROOF_COLOR);

        drawRoofAndFence(g,
                305, 310,
                290, 390,
                320, 390,
                ROOF_COLOR);

        // Внешние боковые башни (по бокам главной стены)
        g.setColor(WALL_COLOR);
        g.fillRect(0, 480, 40, 320);
        g.fillRect(340, 480, 40, 320);

        // Главная стена
        g.fillRect(40, 526, 300, 274);

        // Зубчатый забор
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
                    FENCE_COLOR
            );
        }

        // Арки
        g.setColor(DARK_COLOR);
        for (int i = 0; i < 5; i++) {
            g.fillOval(
                    40 + 22 + (i * 55),
                    547,
                    36,
                    233
            );
        }

        // Крыши внешних боковых башен
        drawRoofAndFence(g,
                20, 430,
                0, 480,
                40, 480,
                ROOF_COLOR);

        drawRoofAndFence(g,
                360, 430,
                340, 480,
                380, 480,
                ROOF_COLOR );

        // Скалы
        g.setColor(ROKS_COLOR);
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