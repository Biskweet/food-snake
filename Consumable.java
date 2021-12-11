public abstract class Consumable {
    protected int x, y;

    public Consumable(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return String.format("(%d, %d):", this.x, this.y);
    }
}
