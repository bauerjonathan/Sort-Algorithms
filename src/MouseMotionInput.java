import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MouseMotionInput extends MouseMotionAdapter {

    private Main main;

    public MouseMotionInput(Main main) {

        this.main = main;
    }

    @Override
    public void mouseMoved(MouseEvent e) {

        int mx = e.getX();
        int my = e.getY();

        //ExitButton
        if(mx >= main.exitButton.x && mx <= main.exitButton.x + main.exitButton.width) {
            if(my >= main.exitButton.y && my <= main.exitButton.y + main.exitButton.height) {
                main.exitButton.hover();
            } else {
                main.exitButton.nohover();
            }
        } else {
            main.exitButton.nohover();
        }

        //SelectionSort
        if(mx >= main.selectionSortButton.x && mx <= main.selectionSortButton.x + main.selectionSortButton.width) {
            if(my >= main.selectionSortButton.y && my <= main.selectionSortButton.y + main.selectionSortButton.height) {
                main.selectionSortButton.hover();
            } else {
                main.selectionSortButton.nohover();
            }
        } else {
            main.selectionSortButton.nohover();
        }

        //InjectionSort
        if(mx >= main.injectionSortButton.x && mx <= main.injectionSortButton.x + main.injectionSortButton.width) {
            if(my >= main.injectionSortButton.y && my <= main.injectionSortButton.y + main.injectionSortButton.height) {
                main.injectionSortButton.hover();
            } else {
                main.injectionSortButton.nohover();
            }
        } else {
            main.injectionSortButton.nohover();
        }

        //MergeSort
        if(mx >= main.mergeSortButton.x && mx <= main.mergeSortButton.x + main.mergeSortButton.width) {
            if(my >= main.mergeSortButton.y && my <= main.mergeSortButton.y + main.mergeSortButton.height) {
                main.mergeSortButton.hover();
            } else {
                main.mergeSortButton.nohover();
            }
        } else {
            main.mergeSortButton.nohover();
        }

        //Eingabe
        if(mx >= main.eingabeButton.x && mx <= main.eingabeButton.x + main.eingabeButton.width) {
            if(my >= main.eingabeButton.y && my <= main.eingabeButton.y + main.eingabeButton.height) {
                main.eingabeButton.hover();
            } else {
                main.eingabeButton.nohover();
            }
        } else {
            main.eingabeButton.nohover();
        }
    }
}
