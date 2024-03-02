package Questions.FunctionalInterface;

//@FunctionalInterface
interface Greeting {
    void greet(String message);

    default void count(Integer num) {
        System.out.println(++num);
    }
}

class Hello implements Greeting {
    @Override
    public void greet(String message) {
        System.out.println(message);
    }
}
public class Main {

    public static void main(String[] args) {
        // Using the functional interface with a lambda expression
        Greeting greetingLambda = message -> System.out.println(message);
        greetingLambda.greet("Hello world with lambda!");

        Hello hello = new Hello();
        hello.greet("Hello again!");
        hello.count(1);

        // Using the functional interface with a method reference
        Greeting greetingMethodReference = System.out::println;
        greetingMethodReference.greet("Hello world with method reference!");
    }
}
