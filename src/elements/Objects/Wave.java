package elements.Objects;

import java.awt.*;

public class Wave {
    private final int x;
    private int y;
    private final int startY;

    private final int height;
    private final int speed;
    private final int panelWidth;

    private int ticks;
    private final Color waveColor;
    private final double waveFrequency;
    private final double wavePhase;

    public Wave(int x, int y, int height, int speed, int panelWidth) {
        this.x = x;
        this.y = y;
        this.startY = y;
        this.height = height;
        this.speed = speed;
        this.panelWidth = panelWidth;

        this.ticks = 0;

        this.waveColor = new Color(50, 100, 150 + (int) (Math.random() * 30));
        this.waveFrequency = 0.02 + Math.random() * 0.01;
        this.wavePhase = Math.random() * Math.PI * 2;
    }

    public void update(int currentTicks) {
        this.ticks = currentTicks;

        double phase = (ticks * 0.05);
        this.y = startY + (int)(Math.sin(phase) * height);
    }

    public void draw(Graphics2D g) {
        g.setColor(waveColor);

        Polygon wavePolygon = new Polygon();
        int step = 10;

        for (int i = 0; i <= panelWidth; i += step) {
            int waveX = x + i;

            double phase = wavePhase + waveX * waveFrequency + (ticks * 0.05 * speed);

            int waveY = y + (int) (Math.sin(phase) * height / 2);

            wavePolygon.addPoint(waveX, waveY);
        }

        int bottomDepth = y + 30;
        wavePolygon.addPoint(panelWidth, bottomDepth);
        wavePolygon.addPoint(0, bottomDepth);

        g.fillPolygon(wavePolygon);
    }
}