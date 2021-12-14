public abstract class Consumable extends Cell {
    public int nutritiveValue;
    public int additionalSize;

    public Consumable(String name, int nutritiveValue, int additionalSize, int x, int y) throws InvalidNameException {
        super(name, x, y);
        this.nutritiveValue = nutritiveValue;
        this.additionalSize = additionalSize;
    }

    public abstract Consumable clone();
}
