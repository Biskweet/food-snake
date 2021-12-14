public class HealthyMeal extends Consumable {
    public HealthyMeal(String name, int nutritiveValue, int additionalSize, int x, int y) throws InvalidNameException {
        super(name, nutritiveValue, additionalSize, y, y);
    }

    public HealthyMeal(String name, int x, int y) throws InvalidNameException {
        this(name, (int) (Math.random() * 11) + 60, (int) (Math.random() * 2) + 4, x, y);
        //           random integer in [60, 70]      random integer in [4, 5]
    }

    public UnhealthyMeal clone() {
        try {
            return new UnhealthyMeal(this.name, this.nutritiveValue,this.additionalSize, this.x, this.y);
        } catch (InvalidNameException error) {
            System.out.println("Erreur : " + error.getMessage());
            return null;
        }
    }
}
