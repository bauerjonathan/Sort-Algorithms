import javax.swing.*;

public class Window {

    private JFrame frame;

    public Window(String title, int width, int height, Main main) {

        frame = new JFrame();

        frame.setSize(width, height);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);
        frame.setTitle(title);
        frame.setResizable(false);
        frame.add(main);

        frame.setVisible(true);
    }
}
