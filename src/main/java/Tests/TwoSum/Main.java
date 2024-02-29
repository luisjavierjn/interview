package Tests.TwoSum;

import java.util.HashMap;
import java.util.List;

//Problema: Dado un arreglo de números enteros nums y un entero objetivo target, encuentra
// dos números en nums tal que su suma sea igual a target. Se asume que cada entrada tendría
// exactamente una solución, y no se puede utilizar el mismo elemento dos veces. Se puede retornar
// la respuesta en cualquier orden.
public class Main {
    public static String twoSum(List<Integer> A, int K) {
        // Crear un HashMap para almacenar los valores y sus índices
        HashMap<Integer, Integer> map = new HashMap<>();
        // Iterar a través de la lista A
        for (int i = 0; i < A.size(); i++) {
            int complement = K - A.get(i);
            // Si el complemento existe en el mapa, hemos encontrado una solución
            if (map.containsKey(complement)) {
                // Retornar los índices en el formato deseado
                return String.format("[%d, %d]", map.get(complement), i);
            }
            // Si no, agregar este valor e índice al mapa
            map.put(A.get(i), i);
        }
        // Si no se encuentra ninguna solución, retornar una cadena que lo indique
        return "No two sum solution";
    }

    // Método main para probar el método twoSum
    public static void main(String[] args) {
        List<Integer> A = List.of(2, 7, 11, 15);
        int K = 9;
        System.out.println(twoSum(A, K));
        // Esto imprimirá, por ejemplo, "[0, 1]" si A = [2, 7, 11, 15] y K = 9
    }
}

