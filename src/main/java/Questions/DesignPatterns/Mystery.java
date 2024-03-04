package Questions.DesignPatterns;

// The following code snippet is a demonstration of a particular design pattern.
// Which design pattern is it?
// a) Factory Design Pattern
// b) Strategy Pattern
// c) Singleton
// d) Facade Design Pattern
public class Mystery {
    private static Mystery instance = null;
    protected Mystery() {
        // Exist only to defeat instantiation
    }
    public static Mystery getInstance() {
        if(instance == null) {
            instance = new Mystery();
        }
        return instance;
    }
}
