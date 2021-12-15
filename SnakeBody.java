public class SnakeBody extends Cell {
    public SnakeBody(int x, int y) throws InvalidNameException {
        super("█", x, y);
    }

    public SnakeBody(String name, int x, int y) throws InvalidNameException {
        super(name, x, y);
    }
}
