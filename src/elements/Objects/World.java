package elements.Objects;


import java.awt.*;
import elements.Landscape.BackGround;


public class World {
    private final BackGround bg;

    public World (){
        bg = new BackGround(0,0);
    }
    public void draw(Graphics2D g, int screenWidth, int screenHeight){

        bg.draw(g, screenWidth, screenHeight);
    }


}
