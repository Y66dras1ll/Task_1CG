package elements.Landscape;

import java.awt.*;

// 227, 226, 222 для замка
public class Castle {
        private final double x;
        private final double y;

        public Castle(double x, double y) {
            this.x = x;
            this.y = y;
        }
    public void draw(Graphics2D g) {
            g.setColor(new Color(227, 226, 222));
            g.fillRect(45,520, 300, 270);

    }

}
