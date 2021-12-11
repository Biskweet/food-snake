public abstract class Consumable extends Cell {
    public double nutritiveValue;
    public int additionalSize;

    public Consumable(String name, double nutritiveValue, int additionalSize) {
        super(name);
        this.nutritiveValue = nutritiveValue;
        this.additionalSize = additionalSize;
    }
}
