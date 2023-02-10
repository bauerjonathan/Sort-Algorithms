import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class EingabeWindow {

    private Main main;
    private Wertdarsteller wertdarsteller;
    private JFrame window;
    private JTextField textfeld;
    private JButton enter;

    public String eingabe;

    //Ist der Frame gerade visible?
    public boolean isopen = true;

    public EingabeWindow(Main main, Wertdarsteller wertdarsteller) {

        this.main = main;
        this.wertdarsteller = wertdarsteller;
        window = new JFrame();
        JPanel panel = new JPanel();
        window.setTitle("Eingabe");
        window.setSize(300, 200);
        window.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        window.setLocation(100,100);

        enter = new JButton("Enter");

        JLabel label1 = new JLabel("Zahlen(z.B. 23-44-11): ");

        textfeld = new JTextField( 15);

        panel.add(label1);
        panel.add(textfeld);
        panel.add(enter);

        //Actionlistener auf dem Button
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wertdarsteller.setdeactive();
                String zwischenwert = textfeld.getText();
                eingabe = zwischenwert;

                String[] split = eingabe.split("-");
                int[] number = new int[split.length];

                for(int i = 0; i < split.length; i++) {
                    number[i] = Integer.parseInt(split[i]);
                }

                wertdarsteller.unsortiert = Arrays.toString(number);

                if(main.Sortstate == "-----------") {
                    System.out.println("Kein Sortieralgorithmus ausgewählt");
                }

                if(main.Sortstate == "Selection") {
                    executeSelection(number);
                }

                if(main.Sortstate == "Injection") {
                    executeInjection(number);
                }

                if(main.Sortstate == "Merge") {
                    executeMerge(number);
                }

                window.setVisible(false);
                isopen = false;
            }
        });

        window.add(panel);
        window.setVisible(true);
    }

    public void executeSelection(int[] number) {

        long start = System.nanoTime();

        for (int i = 0; i < number.length - 1; i++) {
            for (int j = i + 1; j < number.length; j++) {
                if (number[i] > number[j]) {
                    int temp = number[i];
                    number[i] = number[j];
                    number[j] = temp;
                }
            }
        }

        long duration = System.nanoTime() - start;
        wertdarsteller.processduration = duration;
        wertdarsteller.sortiert = Arrays.toString(number);
        wertdarsteller.setactive();
    }

    public void executeInjection(int[] number) {

        long start = System.nanoTime();

        int temp;
        for (int i = 1; i < number.length; i++) {
            temp = number[i];
            int j = i;
            while (j > 0 && number[j - 1] > temp) {
                number[j] = number[j - 1];
                j--;
            }
            number[j] = temp;
        }

        long duration = System.nanoTime() - start;
        wertdarsteller.processduration = duration;
        wertdarsteller.sortiert = Arrays.toString(number);
        wertdarsteller.setactive();
    }

    public void executeMerge(int[] number) {

        long start = System.nanoTime();

        //Merge Code
        int[] linkeseite = new int[number.length];
        int[] rechteseite = new int[number.length];

        for(int i = 0; i <= number.length / 2; i++) {
            linkeseite[i] = number[i];
        }

        for(int i = number.length / 2 + 1; i < number.length; i++) {
            rechteseite[i] = number[i];
        }

        number = merge(linkeseite, rechteseite);

        long duration = System.nanoTime() - start;
        wertdarsteller.processduration = duration;
        wertdarsteller.sortiert = Arrays.toString(number);
        wertdarsteller.setactive();
    }

    public int[] merge(int[] linkeseite, int[] rechteseite) {
        int[] sortedlist = new int[linkeseite.length + rechteseite.length];

        while(linkeseite != null && rechteseite != null) {
            for(int i = 0; i < linkeseite.length; i++) {
                if(linkeseite[i] <= rechteseite[i]) {
                    sortedlist[i] = linkeseite[i];
                } else {
                    sortedlist[i] = rechteseite[i];
                }
            }
        }
        while(linkeseite != null) {
            int temp = 0;

            for(int i = 0; i < sortedlist.length; i++) {
                if(sortedlist[i] == 0) {
                    temp = i;
                }
            }

            for(int i = temp; i < linkeseite.length; i++) {
                sortedlist[temp] = linkeseite[i];
                temp++;
            }
        }

        while(rechteseite != null) {
            int temp = 0;

            for(int i = 0; i < sortedlist.length; i++) {
                if(sortedlist[i] == 0) {
                    temp = i;
                }
            }

            for(int i = temp; i < rechteseite.length; i++) {
                sortedlist[temp] = rechteseite[i];
                temp++;
            }
        }

        return sortedlist;
    }
}
