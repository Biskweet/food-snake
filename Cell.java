public class Cell {
    protected final String name;
    public boolean isEmpty;
    public int x, y;

    public Cell(String name, int x, int y) throws InvalidNameException {
        if (name.length() == 0) { throw new InvalidNameException(); }
        this.isEmpty = (name == " " ? true : false);
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return String.format("%s", this.name.charAt(0));  // Return the first character of the name for display
    }
}
