package elements;

import java.awt.*;
import java.util.ArrayList;

import elements.Landscape.*;
import elements.Objects.*;


public class World {
    private final BackGround bg;
    private final ArrayList<Tree> trees = new ArrayList<>();
    private boolean treesInitialized = false;

    public World (){
        bg = new BackGround(0,0);
    }
    public void draw(Graphics2D g, int screenWidth, int screenHeight){
        bg.draw(g, screenWidth, screenHeight);
        if (!treesInitialized) {
            initializeTrees(screenWidth);
            treesInitialized = true;
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

}
