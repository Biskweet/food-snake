import java.util.ArrayList;
import java.util.Scanner;


public class TestEngine {
    public static void main(String[] args) {
        int SIZE_X = 80;
        int SIZE_Y = 30;

        Cell[][] tab = new Cell[SIZE_Y][];
        for (int i = 0; i < SIZE_Y; i++) {
            tab[i] = new Cell[SIZE_X];
            for (int j = 0; j < SIZE_X; j++) {
                try {
                    tab[i][j] = new Cell("Saucisse", j, i);
                } catch (Exception err) {
                    return;
                }
            }
        }

        Scanner sc = new Scanner(System.in);
        String x = "^[[B";

        System.out.println(x == sc.nextLine());

        // for (int i = 0; i < 10; i++) {
            // Engine.display(tab, 40, 80);
            // Engine.clearScreen();
        // }

        // ArrayList<Integer> tab = new ArrayList<Integer>();
        // for (int i = 0; i < 10; i++) {
        //     tab.add(i);
        // }
        // System.out.println(tab);

        // tab.add(0, 999);

        // System.out.println(tab);    

        // long date = System.currentTimeMillis();
        // System.out.println(date);

        // date = System.currentTimeMillis();
        // System.out.println(date);

        // ArrayList<Integer[]> snakePosition = new ArrayList<Integer[]>();

        // snakePosition.add((1, 2));
        // System.out.println(snakePosition);
    }
}