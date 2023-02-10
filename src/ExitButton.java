import java.awt.*;

public class ExitButton extends Buttons {

    public ExitButton(int x, int y, int width, int height, String title, Main main, Wertdarsteller wertdarsteller) {
        super(x, y, width, height, title, main, wertdarsteller);
    }

    @Override
    void tick() {

    }

    @Override
    void render(Graphics g) {

        if(ishover) {
            g.setColor(Color.red.darker());
            g.fillRect(x, y, width, height);
        } else {
            g.setColor(Color.GRAY.darker());
            g.fillRect(x, y, width, height);
        }


        g.setColor(Color.black);
        g.setFont(new Font("Font1", Font.PLAIN, 30));
        g.drawString(title, x + 20, (int) (y + height * 0.7));
    }

    @Override
    void hover() {
        ishover = true;
    }

    @Override
    void nohover() {
        ishover = false;
    }

    @Override
    void clicked() {
        System.exit(0);
    }
}
