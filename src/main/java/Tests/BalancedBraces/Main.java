package Tests.BalancedBraces;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// Estas diseñando un compilador C++ y necesitas verificar que los parentesis de un archivo están balanceados.
//
// los parentesis en un String se consideran balanceados si se cumplen los siguientes criterios:
//- todos los parentesis se cierran, los parentesis estan en pares (), {} y [] , el de la izquierda abre el
// par y el de la derecha lo cierra
//- en todos los parentesis anidados dentro de otros deberan estar correctamente aparejados
// por ejemplo : [{}] es un grupo balanceado pero [}]{} no lo es
//
// Completa la funcion braces. La funcion deberá devolver una lista de String donde el string para el indice i
// indica si estaban o no balanceados los parentesis para el value i. El string i consiste en el valor "YES" o "NO"
// correspondiente al valor i
//
// La funcion braces recibe los siguientes parametros:
// values[values 0.....values n-1] un array de strings a analizar
//
// Constrains:
// a) 1 <= n <= 15
// b) 1 <= largo de cada valuesi <= 100
// c) cada values i consiste unicamente de llos caracteres (,), {,}, [,]
public class Main {

    public static List<String> balancedBraces(List<String> values) {
        List<String> results = new ArrayList<>();
        for (String value : values) {
            results.add(isBalanced(value) ? "YES" : "NO");
        }
        return results;
    }

    private static boolean isBalanced(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                deque.push(c);
            } else {
                if (deque.isEmpty()) return false;
                char top = deque.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        List<String> braces = List.of("[]", "[{}]", "[}{}", "({[]})", "([)]");
        System.out.println(balancedBraces(braces));
    }
}

