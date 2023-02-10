import java.awt.*;
import java.util.Arrays;

public class Wertdarsteller {

    private Main main;
    public String sortiert;
    public String unsortiert;
    public long processduration;
    private boolean active;

    public Wertdarsteller(Main main) {

        this.main = main;
    }

    public void tick() {

    }

    public void render(Graphics g) {

        g.setColor(Color.black);
        g.setFont(new Font("Font1", Font.PLAIN, 30));

        if (active) {
            g.drawString("Unsortiert: " + unsortiert, 50, 600);
            g.drawString("Sortiert: " + sortiert, 50, 650);
            g.drawString("Dauer: " + processduration + " ns", 50, 700);
        } else {
            g.drawString("Unsortiert: ", 50, 600);
            g.drawString("Sortiert: ", 50, 650);
            g.drawString("Dauer: ", 50, 700);
        }

        //Zusatz Ui Deko
        g.setColor(Color.black);
        g.fillRect(0, 0, main.width, 5);
        g.fillRect(0, 0, 5, main.height);
        g.fillRect(main.width - 5, 0, main.width, main.height);
        g.fillRect(0, main.height - 5, main.width, 5);
    }

    public void setactive() {
        active = true;
    }

    public void setdeactive() {
        active = false;
    }
}
