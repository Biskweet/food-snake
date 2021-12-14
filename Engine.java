import java.util.ArrayList;

public class Engine {
    private static final Engine INSTANCE = new Engine();    
    public static boolean over = false;

    private Engine() {}

    public static Engine getInstance() { return INSTANCE; }

    public static void displayWorld(Cell[][] world) {
        System.out.print("┏"); for (int i = 0; i < world[0].length; i++) { System.out.print("━"); } System.out.println("┓");
        for (int i = 0; i < world.length; i++) {
            System.out.print("┃");
            for (int j = 0; j < world[0].length; j++) {
                if (world[i][j] instanceof Consumable) {
                    System.out.print("\u001B[32m\u001B[1m" + world[i][j] + "\u001B[0m");
                } else {
                    System.out.print(world[i][j]);
                }
            }
            System.out.print("┃\n");
        }
        System.out.print("┗"); for (int i = 0; i < world[0].length; i++) { System.out.print("━"); } System.out.println("┛");
    }


    public static void clearScreen() {
        System.out.printf("\033[H\033[2J");
    }


    public static void displayBar(int hunger, int maxHunger) {
        System.out.println("\n\u001B[31m\u001B[1mBarre de faim :");  // "\n" + ANSI_RED + ANSI_BOLD + "Barre de faim :"
        int rest = maxHunger - hunger;
        System.out.print("▕");
        for (int i = 0; i < hunger; i++) {
            System.out.print("🮋");
        }
        for (int i = 0; i < rest; i++) System.out.print("🮀");
        System.out.print("▏\u001B[0m\n\n");  // "🭰" + ANSI_RESET + "\n\n"
    }


    public static void display(Cell[][] world, int snakeSize, int hunger, int maxHunger) {
        System.out.println("Aliments sains :\tAliments pas sains :\t\tToxique :");
        System.out.println("  S : Saumon\t\t  B : Burger\t\t\t  P : Plastique");
        System.out.println("  E : Épinards\t\t  N : Nutella\t\t");
        
        // \n + ANSI_GREEN + ANSI_BOLD + Taille : [taille] + ANSI_RESET
        System.out.println("\n\u001B[32m\u001B[1mTaille : " + snakeSize + "\u001B[0m"); 

        displayBar(hunger, maxHunger);
        displayWorld(world);
    }
}