public class Cell {
    protected final String name;
    public boolean isEmpty;

    public Cell(String name) throws InvalidNameException {
        if (name.length() == 0) { throw new InvalidNameException(); }
        this.isEmpty = (name == " " ? true : false);
        this.name = name;
    }

    public toString() {
        return this.name.charAt(0);  // Return the first character of the name for display
    }
}
