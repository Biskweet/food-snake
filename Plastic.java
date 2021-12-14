public class Plastic extends Consumable implements Toxique {
    public Plastic(int x, int y) throws InvalidNameException {
        super("Plastique", 0, 3, x, y);
    }

    public Plastic clone() {
        try {
            return new Plastic(this.x, this.y);
        } catch (InvalidNameException error) {
            System.out.println("Erreur : " + error.getMessage());
            return null;
        }
    }
}
