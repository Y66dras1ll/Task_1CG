package elements;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

import elements.Landscape.*;
import elements.Objects.*;

public class World {
    private final BackGround bg;
    private final Castle cs;
    private final ArrayList<Tree> trees = new ArrayList<>();
    private final ArrayList<Cloud> clouds = new ArrayList<>();
    private final ArrayList<Wave> waves = new ArrayList<>();

    private boolean initialized = false;
    private int globalTicks = 0;

    public World() {
        bg = new BackGround(0, 0);
        cs = new Castle(0, 0);
    }

    public void draw(Graphics2D g, int screenWidth, int screenHeight) {
        bg.draw(g, screenWidth, screenHeight);

        if (!initialized) {
            initializeTrees(screenWidth);
            initializeWaves(screenWidth, screenHeight);
            initialized = true;
        }

        globalTicks++;

        for (Wave wave : waves) {
            wave.update(globalTicks);
            wave.draw(g);
        }

        cs.draw(g);

        manageClouds(screenWidth);
        for (Cloud cloud : clouds) {
            cloud.draw(g);
        }

        for (Tree tree : trees) {
            tree.draw(g);
        }
    }

    private void initializeWaves(int screenWidth, int screenHeight) {
        int waterStartY = (int)(screenHeight * 0.77) + 15;

        for (int y = waterStartY; y < screenHeight; y += 8) {
            int speed = (y % 2 == 0) ? 1 : -1;
            int waveHeight = 6;

            waves.add(new Wave(0, y, waveHeight, speed, screenWidth));
        }
    }

    private void initializeTrees(int screenWidth) {
        Color frontLeafColor = new Color(34, 139, 34);
        Color backLeafColor = new Color(28, 125, 28);
        Color frontStemColor = new Color(139, 69, 19);
        Color backStemColor = new Color(120, 64, 16);

        for (int x = 495; x < screenWidth; x += 30) {
            trees.add(new Tree(x, 598, 9, 16, 14, backLeafColor, backStemColor));
        }

        for (int x = 480; x < screenWidth; x += 30) {
            trees.add(new Tree(x, 605, 10, 19, 14, frontLeafColor, frontStemColor));
        }
    }

    private void manageClouds(int screenWidth) {
        if (Math.random() < 0.0042) {
            int randomY = (int) (Math.random() * 220);
            clouds.add(new Cloud(-130, randomY));
        }

        Iterator<Cloud> it = clouds.iterator();
        while (it.hasNext()) {
            Cloud c = it.next();
            c.move();
            if (c.isOffScreen(screenWidth)) {
                it.remove();
            }
        }
    }
}