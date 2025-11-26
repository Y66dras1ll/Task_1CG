import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import elements.World;

public class DrawPanel extends JPanel implements ActionListener {
    private final World world;
    private final Timer timer;

    public DrawPanel() {
        world = new World();

        timer = new Timer(30, this);
        timer.start();
    }


    @Override
    public void paint(Graphics gr){
        super.paint(gr);
        Graphics2D g = (Graphics2D) gr;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        world.draw(g, 1000, 800);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
