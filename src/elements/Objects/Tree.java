package elements.Objects;

import java.awt.*;

public class Tree {
    private final double x;
    private final double y;

    public Tree(double x, double y) {
        this.x = x;
        this.y = y; // y - координата основания ствола (низ дерева)
    }

    public void draw(Graphics2D g) {
        // Сохраняем исходный цвет для восстановления после рисования
        Color originalColor = g.getColor();

        // --- Рисуем ствол (коричневый прямоугольник) ---
        g.setColor(new Color(139, 69, 19)); // Цвет: коричневый (#8B4513)
        int stemWidth = 10;   // Ширина ствола
        int stemHeight = 19;  // Высота ствола
        // Левый верхний угол ствола: (x - ширина/2, y - высота)
        g.fillRect(
                (int)(x - stemWidth / 2.0),
                (int)(y - stemHeight),
                stemWidth,
                stemHeight
        );

        // --- Рисуем крону (зелёный круг) ---
        g.setColor(new Color(34, 139, 34)); // Цвет: тёмно-зелёный (#228B22)
        int crownRadius = 14; // Радиус кроны
        // Центр кроны находится над верхушкой ствола
        double crownCenterX = x;
        double crownCenterY = y - stemHeight - crownRadius / 2.0;

        // fillOval требует координат ЛЕВОГО ВЕРХНЕГО угла описывающего прямоугольника
        g.fillOval(
                (int)(crownCenterX - crownRadius),
                (int)(crownCenterY - crownRadius),
                crownRadius * 2,
                crownRadius * 2
        );

        // Восстанавливаем исходный цвет
        g.setColor(originalColor);
    }
}