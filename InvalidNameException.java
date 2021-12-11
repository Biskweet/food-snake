public class InvalidNameException extends Exception {
    public InvalidNameException() {
        super("Invalid name, must be longer than 0.");
    }
}