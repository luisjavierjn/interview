package Tests.BeADetective;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Detective, one of our team members tracked our target, Vincent the thief, to a hidden
// warehouse. We believe this is where he's storing the stolen goods. the entrance to this
// warehouse is guarded by a digital combination lock. however, our informant is not entirely
// certain about the PIN they witnessed Vincent input
//
// The keypad has the following layout:
//
// | 1 | 2 | 3 |
// | 4 | 5 | 6 |
// | 7 | 8 | 9 |
//     | 0 |
//
// He noted the PIN 1357, but he also said, it is possible that each of the digits he saw could
// be actually be another adjacent digit (horinzontally or vertically, but not diagonally ) E.g. instead
// of the 1, it could also be the 2 or 4. And instead of the 5 it could also be the 2, 4, 6 or 8.
//
// He also mentioned he knows this kind of lock. You can enter an unlimited amount of
// wrong PINs, but they never finally lock the system or sound the alarm. that's why we can
// try out all possible variations.
//
// All possible in the sense of the observed PIN itself and all variations considering the adjacent digits
// The array should contain all possible PINs ordered in ascending value
//
// Sample input:
// 8
//
// Sample output:
// 0
// 5
// 7
// 8
// 9
//
// Explanation:
//
// If the observed pin is "8", all possible combinations considering horizontal and vertical movement give
// us the next output array:
// ["0","5","7","8","9"]
//
// Another example could be for the observed pin "11":
// In this case, the output will be:
// ["11","12","14","21","22","24","41","42","44"]
// Remember that the output should be ordered ascendingly.
//
// Sample input:
// 11
//
// Sample output:
// 11
// 12
// 14
// 21
// 22
// 24
// 41
// 42
// 44
public class Main {
    public static void main(String[] args) {
        String[] result = solution("11");
        for (String pin : result) {
            System.out.println(pin);
        }
    }

    public static String[] solution(String pin) {
        Map<Character, char[]> adjacentDigits = new HashMap<>();
        adjacentDigits.put('1', new char[]{'1', '2', '4'});
        adjacentDigits.put('2', new char[]{'1', '2', '3', '5'});
        adjacentDigits.put('3', new char[]{'2', '3', '6'});
        adjacentDigits.put('4', new char[]{'1', '4', '5', '7'});
        adjacentDigits.put('5', new char[]{'2', '4', '5', '6', '8'});
        adjacentDigits.put('6', new char[]{'3', '5', '6', '9'});
        adjacentDigits.put('7', new char[]{'4', '7', '8'});
        adjacentDigits.put('8', new char[]{'5', '7', '8', '9', '0'});
        adjacentDigits.put('9', new char[]{'6', '8', '9'});
        adjacentDigits.put('0', new char[]{'0', '8'});

        List<String> variations = new ArrayList<>();
        variations.add("");

        for (int i = 0; i < pin.length(); i++) {
            char digit = pin.charAt(i);
            List<String> newVariations = new ArrayList<>();
            for (String prefix : variations) {
                for (char nextDigit : adjacentDigits.get(digit)) {
                    newVariations.add(prefix + nextDigit);
                }
            }
            variations = newVariations;
        }

        Collections.sort(variations);

        return variations.toArray(new String[0]);
    }
}
