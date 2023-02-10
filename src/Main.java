import java.awt.*;
import java.awt.image.BufferStrategy;

public class Main extends Canvas {

    private boolean running = false;
    public int width = 900;
    public int height = 900;

    public ExitButton exitButton;
    public SelectionSortButton selectionSortButton;
    public InjectionSortButton injectionSortButton;
    public MergeSortButton mergeSortButton;
    public EingabeButton eingabeButton;
    public Wertdarsteller wertdarsteller;

    public String Sortstate = "-----------";

    public Main() {
        new Window("Sorting-Algorithm", width, height, this);
        running = true;

        wertdarsteller = new Wertdarsteller(this);
        exitButton = new ExitButton(50, height - 100, 200, 50, "Exit", this, this.wertdarsteller);
        selectionSortButton = new SelectionSortButton(50, 100, 200, 50, "SelectionSort", this, this.wertdarsteller);
        injectionSortButton = new InjectionSortButton(50, 200, 200, 50, "InjectionSort", this, this.wertdarsteller);
        mergeSortButton = new MergeSortButton(50, 300, 200, 50, "MergeSort", this, this.wertdarsteller);
        eingabeButton = new EingabeButton(50, 400, 200, 50, "Eingabe", this, this.wertdarsteller);

        //MouseAdapter
        this.addMouseListener(new MouseInput(this));
        this.addMouseMotionListener(new MouseMotionInput(this));

        while(running) {
         tick();
         render();
        }
    }

    public void tick() {
        wertdarsteller.tick();
    }

    public void render() {

        BufferStrategy bs = getBufferStrategy();
        if(bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.pink.darker());
        g.fillRect(0, 0, width, height);

        exitButton.render(g);
        selectionSortButton.render(g);
        injectionSortButton.render(g);
        mergeSortButton.render(g);
        eingabeButton.render(g);
        wertdarsteller.render(g);

        g.setColor(Color.black);
        g.drawString("Algorithmus: " + Sortstate, 50, 50);

        bs.show();
        g.dispose();
    }

    public static void main(String[] args) {
        new Main();
    }
}
