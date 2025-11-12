import javax.swing.*;
import java.awt.*;

import elements.World;

public class DrawPanel extends JPanel {
    private final World world;
    public DrawPanel() {
        world = new World();

    }

    public void paint (Graphics gr){
        super.paint(gr);
        Graphics2D g =  (Graphics2D) gr;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        world.draw(g, 1000, 800);
    }
}
