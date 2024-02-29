package Book.IsomorphicStrings;

// Two strings are isomorphic if the characters in s can be replaced to get t.
// For example,"egg" and "add" are isomorphic, "foo" and "bar" are not
public class Main {
    static JavaSolution sol = new JavaSolution();
    public static void main(String[] args) {
        String a = "egg";
        String b = "add";
        boolean result = sol.isIsomorphic(a, b);
        System.out.println(result);
    }
}
