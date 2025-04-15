package Tests.TeamFormation;

import java.util.Arrays;
import java.util.HashMap;

// Hoy, Roy está formando algunos equipos de los n concursantes de su universidad, para un concurso de programación que se
// acerca. En este concurso, un equipo puede tener cualquier número de concursantes.
// Roy sabe el nivel de cada concursante. También sabe que, para hacer que trabajen en equipo, no debería haber mucha
// diferencia entre los concursantes del mismo equipo. En otras palabras, si el nivel de un concursante es x, entonces él tiene el
// nivel más bajo en su equipo, o hay otro concursante con el nivel de x-1 en el mismo equipo. También, no hay dos
// concursantes del mismo equipo con el mismo nivel. Note que, algunos de los consursantes siempre escriben códigos con
// errores, por lo que su nivel es negativo.
// Mientras más concursantes tenga un equipo, odrán resolver más problemas a la vez. Por lo que, Roy quiere formar equipos
// de manera que, el tamaño del menor equipo sea lo más grande posible.
//
// Formato de Entrada:
// La primera línea de entrada contiene t (1 <= t <= 100), el número de casos de prueba.
// Cada caso empieza con un entero n (0 <= n <= 10^5), el número de concursantes. Luego vienen n enteros separados por un
//espacio. El i-ésimo entero es el nivel del i-ésimo concursante. Los valores absolutos de los niveles no excederán de 10^9.
// El número total de concursantes en todos los casos no excederá 10^6.
//
// Formato de Salida:
// Para cada caso de prueba, imprime el tamaño del grupo más pequeño en una línea separada.
//
// Ejemplo de Entrada:
// 4
// 7 4 5 2 3 -4 -3 -5
// 1 -4
// 4 3 2 3 1
// 7 1 -2 -3 -4 2 0 -1
//
// Ejemplo de Salida:
// 3
// 1
// 1
// 7
//
// Explicación:
// Para el primer caso, Roy puede formar dos equipos. Un equipo con concursantes de niveles {-4,-3,-5} y el otro equipo con
// {4,5,2,3}. El primer grupo es el más pequeño, y contiene 3 miembros.
// En el segundo caso, el único equipo es {-4}
// En el tercer caso, los equipos son {3}, {1,2,3}, el tamaño del grupo más pequeño es 1.
// En el único caso, puedes construir un grupo que contiene todos los concursantes. El tamaño del grupo es igual al número de
// concursantes.
public class Main {

    public static void main(String[] args) {
        // Ejemplos dados en el problema
        int[][] ejemplosConcursantes = {
                {4, 5, 2, 3, -4, -3, -5},
                {-4},
                {3, 2, 3, 1},
                {1, -2, -3, -4, 2, 0, -1}
        };

        // Correr cada ejemplo
        for (int[] nivelesConcursantes : ejemplosConcursantes) {
            System.out.println(calcularTamanoDelGrupoMasPequeno(nivelesConcursantes));
        }
    }

    private static int calcularTamanoDelGrupoMasPequeno(int[] niveles) {
        Arrays.sort(niveles); // Ordenar los niveles de los concursantes

        // HashMap para almacenar el tamaño de cada equipo. La clave es el nivel más bajo del equipo.
        HashMap<Integer, Integer> equipos = new HashMap<>();

        for (int nivel : niveles) {
            if (equipos.containsKey(nivel - 1)) {
                equipos.put(nivel, equipos.get(nivel - 1) + 1); // Añadir el concursante al equipo existente
                equipos.remove(nivel - 1); // Remover el equipo anterior porque el nivel más bajo ahora es nivel
            } else {
                equipos.put(nivel, 1); // Crear un nuevo equipo si no hay un nivel x-1
            }
        }

        // Encontrar el tamaño del equipo más pequeño
        int tamanoMinimo = Integer.MAX_VALUE;
        for (int tamano : equipos.values()) {
            if (tamano < tamanoMinimo) {
                tamanoMinimo = tamano;
            }
        }

        return tamanoMinimo == Integer.MAX_VALUE ? 0 : tamanoMinimo; // Devolver 0 si no hay equipos
    }
}
