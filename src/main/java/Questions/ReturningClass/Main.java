package Questions.ReturningClass;

// Which of the following options could be inserted inside myMethod
// without generating an error?
// a) return o.TYPE;
// b) return o.getClass();
// c) return o instanceof Class;
// d) return o.class;
public class Main {
    static Class myMethod(Object o) {
        //return o.TYPE;
        //return o.getClass();
        //return o instanceof Class;
        //return o.class;
        return null;
    }
    public static void main(String[] args) {
        Class c = myMethod("hi");
        // ...
    }
}
