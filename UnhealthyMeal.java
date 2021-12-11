public class UnhealthyMeal extends Consumable {
    private double nutritiveValue;
    private int additionalSize;

    public UnhealthyMeal(String name, double nutritiveValue, int additionalSize) {
        super(name, nutritiveValue, additionalSize);
    }

    public UnhealthyMeal(String name) {
        this(name, (int) (Math.random() * 6) + 10, (int) (Math.random() * 3) + 1);
        //           random integer in [10, 15]      random integer in [1, 3]

    }
}
