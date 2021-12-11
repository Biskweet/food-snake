public class HealthyMeal extends Consumable {
    public HealthyMeal(String name, double nutritiveValue, int additionalSize) {
        super(name, nutritiveValue, additionalSize);
    }

    public HealthyMeal(String name) {
        this(name, (int) (Math.random() * 6) + 15, (int) (Math.random() * 2) + 1);
        //           random integer in [15, 20]      random integer in [1, 2]
    }
}