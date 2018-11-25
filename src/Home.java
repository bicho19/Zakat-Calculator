import mdlaf.MaterialLookAndFeel;

import javax.swing.*;
import java.awt.*;

/*

    File Created by: Hachemi Hamadi
    Mini Project Module IHM : Zakat Calculator
    Source Code published on GitHub (@bicho19)
    Link : https://github.com/bicho19/Zakat-Calculator

 */

public class Home {
    private static JFrame frame;
    private static HomePanel homePanel = new HomePanel();

    private void setup() {
        frame = new JFrame();
        frame.setMinimumSize(new Dimension(700, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Center the window in the screen;
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.add(homePanel);
        frame.pack();
    }


    static void swap(JPanel current, JPanel next) {
        SwingUtilities.invokeLater(() -> {
            frame.remove(current);
            frame.add(next);
            frame.invalidate();
            frame.revalidate();
        });

    }

    public static void main (String[] args) {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        Home home = new Home();
        home.setup();
    }

}