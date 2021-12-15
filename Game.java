import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private static int SIZE_X = 80;
    private static int SIZE_Y = 30;
    private static int MAX_HUNGER = 80;
    private static long itemPlaceDate = 0;
    private static char move = 'D';
    private static Scanner scanner = new Scanner(System.in); 
    private static int hunger = MAX_HUNGER, remainingSizeToAdd = 0;


    public static Cell placeNewItem(Cell[][] world) throws InvalidNameException {
        int x, y;
        Consumable item;

        do {
            y = (int) (Math.random() * world.length);
            x = (int) (Math.random() * world[0].length);
        } while (!world[y][x].isEmpty);
        
        try {
            double prob = Math.random();
            
            if (prob < 0.25) { item = new UnhealthyMeal("Nutella", x, y); }
            else if (prob < 0.5) { item = new UnhealthyMeal("Burger", x, y); }
            else if (prob < 0.75) { item = new HealthyMeal("Saumon", x, y); }
            else if (prob < 0.9) { item = new HealthyMeal("Épinards", x, y); }
            else { item = new Plastic(x, y); }

        } catch (Exception err) {
            return null;
        }

        itemPlaceDate = System.currentTimeMillis();
        world[y][x] = item;
        return item;
    }


    public static void moveSnake(ArrayList<Integer[]> snakePos, Cell[][] world) throws ArrayIndexOutOfBoundsException {
        String input = scanner.nextLine().toUpperCase();
        if (input.length() != 0) {
            char newMove = input.charAt(0);

            if (newMove == 'Z' && move != 'S') {
                move = 'Z';
            } else if (newMove == 'S' && move != 'Z') {
                move = 'S';
            } else if (newMove == 'Q' && move != 'D') {
                move = 'Q';
            } else if (newMove == 'D' && move != 'Q') {
                move = 'D';
            }
        }

        Integer[] newPos = new Integer[2];

        if (move == 'Z') {
            newPos[0] = snakePos.get(0)[0] - 1;
            newPos[1] = snakePos.get(0)[1];
        } else if (move == 'S') {
            newPos[0] = snakePos.get(0)[0] + 1;
            newPos[1] = snakePos.get(0)[1];
        } else if (move == 'D') {
            newPos[0] = snakePos.get(0)[0];
            newPos[1] = snakePos.get(0)[1] + 1;
        } else {
            newPos[0] = snakePos.get(0)[0];
            newPos[1] = snakePos.get(0)[1] - 1;
        }

        if (world[newPos[0]][newPos[1]] instanceof Consumable) {
            Consumable cons = (Consumable) world[newPos[0]][newPos[1]];
            remainingSizeToAdd += cons.additionalSize;
            hunger += cons.nutritiveValue;
            if (hunger > MAX_HUNGER) {
                hunger = MAX_HUNGER;
            }

            itemPlaceDate = 0;
        }

        // Overwriting the snake's tail if there's no size to be added
        if (remainingSizeToAdd == 0) {
            Integer[] lastBodyPart = snakePos.get(snakePos.size() - 1);
            try { world[lastBodyPart[0]][lastBodyPart[1]] = new Cell(" ", lastBodyPart[0], lastBodyPart[1]);}
            catch (Exception err) {}  // Will never raise an error but still needs a catch case
            snakePos.remove(lastBodyPart);
        } else {
            remainingSizeToAdd--;
        }

        // Checking collision with itself
        if (world[newPos[0]][newPos[1]] instanceof SnakeBody) {
            Engine.over = true;
        }

        snakePos.add(0, newPos);
    }


    public static void main(String[] args) {
        Cell[][] world;
        ArrayList<Integer[]> snakePosition = new ArrayList<Integer[]>();
        Cell item;
        int counter = 0;

        // Initializing terrain
        world = new Cell[SIZE_Y][];
        for (int i = 0; i < SIZE_Y; i++) {
            world[i] = new Cell[SIZE_X];
            for (int j = 0; j < SIZE_X; j++) {
                try {
                    world[i][j] = new Cell(" ", j, i);
                } catch (InvalidNameException err) { return; }
            }
        }

        // Initializing the snake with size 3
        Integer[][] snakeInit = {{0, 0}, {0, 1}, {0, 2}};
        snakePosition.add(snakeInit[0]);
        snakePosition.add(snakeInit[1]);
        snakePosition.add(snakeInit[2]);


        // Initializing the first item
        try { item = placeNewItem(world); } catch (InvalidNameException err) { return; } 

        // ========== Main loop ==========
        while (!Engine.over) {
            Engine.clearScreen();
            Engine.display(world, snakePosition.size(), hunger, MAX_HUNGER);
            
            // If the item expired
            if (System.currentTimeMillis() - itemPlaceDate > 4000) {
                try {
                    world[item.y][item.x] = new Cell(" ", item.x, item.y);  // Deleting the old item
                    item = placeNewItem(world);                             // and creating one elsewhere
                } catch (InvalidNameException err) { return; }
            }


            Integer[] head = snakePosition.get(0);
            try {
                Consumable cons = (Consumable) world[head[0]][head[1]];
                System.out.println("Successfully casted");
                remainingSizeToAdd += cons.additionalSize;
                System.out.println("additionalSize=" + cons.additionalSize);
                hunger += cons.nutritiveValue;
            } catch (Exception err) { /* Means it's not a Consumable */ }
            
            try {
                moveSnake(snakePosition, world);
            } catch (Exception err) {
                Engine.over = true;  // That exception means it hit a wall 
                continue;
            }
            
            // Overwriting the world with the snake's body
            for (int i = 0; i < snakePosition.size(); i++) {
                Integer[] pos = snakePosition.get(i);
                try {
                    if (i == 0) {
                        world[pos[0]][pos[1]] = new SnakeBody("▒", pos[0], pos[1]);    
                    } else {
                        world[pos[0]][pos[1]] = new SnakeBody(pos[0], pos[1]);
                    }
                } catch (Exception err) {}
            }

            counter++;
            if (counter % 2 == 0) {
                hunger--;  // Decreasing hunger by one every two moves so it doesn't fall to fast
            }

            if (hunger == 0) {
                Engine.over = true;
            }

        }

        Engine.clearScreen();
        Engine.display(world, snakePosition.size(), hunger, MAX_HUNGER);
        System.out.println("Partie terminée !");
    }
}