package Questions.SystemExit;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("Hola Mundo");
            System.exit(1);
        } catch(Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("finally");
        }
    }
}
