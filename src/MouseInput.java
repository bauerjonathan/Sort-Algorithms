import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {

    private Main main;

    public MouseInput(Main main) {

        this.main = main;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int mx = e.getX();
        int my = e.getY();

        //ExitButton
        if(mx >= main.exitButton.x && mx <= main.exitButton.x + main.exitButton.width) {
            if(my >= main.exitButton.y && my <= main.exitButton.y + main.exitButton.height) {
                main.exitButton.clicked();
            }
        }

        //SelectionSort
        if(mx >= main.selectionSortButton.x && mx <= main.selectionSortButton.x + main.selectionSortButton.width) {
            if(my >= main.selectionSortButton.y && my <= main.selectionSortButton.y + main.selectionSortButton.height) {
                main.selectionSortButton.clicked();
            }
        }

        //InjectionSort
        if(mx >= main.injectionSortButton.x && mx <= main.injectionSortButton.x + main.injectionSortButton.width) {
            if(my >= main.injectionSortButton.y && my <= main.injectionSortButton.y + main.injectionSortButton.height) {
                main.injectionSortButton.clicked();
            }
        }

        //MergeSort
        if(mx >= main.mergeSortButton.x && mx <= main.mergeSortButton.x + main.mergeSortButton.width) {
            if(my >= main.mergeSortButton.y && my <= main.mergeSortButton.y + main.mergeSortButton.height) {
                main.mergeSortButton.clicked();
            }
        }

        //Eingabe
        if(mx >= main.eingabeButton.x && mx <= main.eingabeButton.x + main.eingabeButton.width) {
            if(my >= main.eingabeButton.y && my <= main.eingabeButton.y + main.eingabeButton.height) {
                main.eingabeButton.clicked();
            }
        }
    }
}

