import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        MainWindow mw = new MainWindow();
        mw.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mw.setSize(1000, 800);
        mw.setResizable(false);
        mw.setVisible(true);
    }
}