import java.awt.*;

public abstract class Buttons {

    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected String title;
    protected boolean ishover;
    protected Main main;
    protected Wertdarsteller wertdarsteller;


    public Buttons(int x, int y, int width, int height, String title, Main main, Wertdarsteller wertdarsteller) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.title = title;
        this.main = main;
        this.wertdarsteller = wertdarsteller;
    }

    abstract void tick();
    abstract void render(Graphics g);
    abstract void hover();
    abstract void nohover();
    abstract void clicked();
}
