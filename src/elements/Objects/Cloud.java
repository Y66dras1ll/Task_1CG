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

        // "Средняя скорость": от 1.0 до 2.5 пикселей за кадр.
        // Это быстрее, чем в прошлом варианте, чтобы движение было заметным.
        this.speed = 0.7 + random.nextDouble() * 1.2;

        // Размеры облака
        this.width = 70 + random.nextInt(30);
        this.height = 40 + random.nextInt(20);
    }

    public void move() {
        x += speed; // Движение вправо
    }

    public void draw(Graphics2D g) {
        // Сохраняем оригинальные настройки (чтобы прозрачность не сломала остальную рисовку)
        Composite originalComposite = g.getComposite();

        // Рисуем 4 "кружка" (овала) белого цвета с разной прозрачностью
        // Color(red, green, blue, alpha), где alpha 0-255 (255 - непрозрачный, 0 - невидимый)

        // 1. Центральная часть (плотная)
        g.setColor(new Color(255, 255, 255, 220));
        g.fillOval((int)x, y, width, height);

        // 2. Верхняя "шапка" (посветлее)
        g.setColor(new Color(255, 255, 255, 180));
        g.fillOval((int)x + 15, y - 20, width - 30, height);

        // 3. Левый край (полупрозрачный)
        g.setColor(new Color(255, 255, 255, 140));
        g.fillOval((int)x - 25, y + 10, width / 2 + 10, height - 10);

        // 4. Правый край (полупрозрачный)
        g.setColor(new Color(255, 255, 255, 140));
        g.fillOval((int)x + width - 20, y + 15, width / 2, height - 15);

        // Возвращаем настройки графики
        g.setComposite(originalComposite);
    }

    // Проверка, ушло ли облако за экран
    public boolean isOffScreen(int screenWidth) {
        return x > screenWidth + 100;
    }
}