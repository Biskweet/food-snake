public class Cell {
    protected final String name; 

    public Cell(String name) throws InvalidNameException {
        if (name.length() == 0) {
            throw new InvalidNameException();
        }
        this.name = name;
    }

    public toString() {
        return this.name.charAt(0);  // Return the first character of the name
    }
}
