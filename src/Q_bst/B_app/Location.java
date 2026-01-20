package Q_bst.B_app;

// A location within a file.
public record Location(int lineNumber, int columnNumber) {
    @Override
    public String toString() {
        return "(" + lineNumber + ", " + columnNumber + ")";
    }
}