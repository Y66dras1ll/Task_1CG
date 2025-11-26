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

    private boolean treesInitialized = false;

    public World (){
        bg = new BackGround(0,0);
        cs = new Castle(0,0);
    }

    public void draw(Graphics2D g, int screenWidth, int screenHeight){
        bg.draw(g, screenWidth, screenHeight);
        // cs.draw(g);

        if (!treesInitialized) {
            initializeTrees(screenWidth);
            treesInitialized = true;
        }

        manageClouds(screenWidth);

        for (Cloud cloud : clouds) {
            cloud.draw(g);
        }


        for (Tree tree : trees) {
            tree.draw(g);
        }
    }

    private void initializeTrees(int screenWidth) {
        for (int x = 480; x < screenWidth; x += 30) {
            trees.add(new Tree(x, 605));
        }
    }

    private void manageClouds(int screenWidth) {
        if (Math.random() < 0.0042) {

            int randomY = (int)(Math.random() * 220);
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
