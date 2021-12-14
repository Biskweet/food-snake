public class Plastic extends Consumable implements Toxique {
    public Plastic(int x, int y) throws InvalidNameException {
        super("Plastique", 0, 3, x, y);
    }
}
