public abstract class Item {
	private int x, y;

	public Item(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return String.format("(%d, %d):", this.x, this.y);
	}
}
