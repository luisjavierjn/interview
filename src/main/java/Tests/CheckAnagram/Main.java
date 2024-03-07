package Tests.CheckAnagram;

import java.util.Arrays;

/*
 * Write a method that returns a boolean value
 * specifying if 2 strings received as params
 * are anagrams
 *
 * "listen" is an anagram of "silent"
 * "robed" is an anagram of "bored"
 * "aaar" is an anagram of "araa"
 */
public class Main {

    public static boolean checkAnagramSol1(String first, String second) {
        StringBuilder firstBuilder = new StringBuilder(first);
        StringBuilder secondBuilder = new StringBuilder(second);

        int i=0;
        while(i<secondBuilder.length()) {
            String letter = secondBuilder.substring(i, i+1);
            int index = firstBuilder.lastIndexOf(letter);
            if(index >= 0) {
                firstBuilder.deleteCharAt(index);
            } else {
                return false;
            }

            i++;
        }

        if(i == secondBuilder.length() && firstBuilder.length() > 0) {
            return false;
        }

        return true;
    }

    public static boolean checkAnagramSol2(String first, String second) {
        if(first.length() != second.length()) {
            return false;
        }

        // Convertimos las cadenas a arreglos de caracteres y los ordenamos
        char[] arr1 = first.toCharArray();
        char[] arr2 = second.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Comparamos los arreglos ordenados
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        System.out.println(checkAnagramSol1("listen","silent"));
        System.out.println(checkAnagramSol1("robed","bored"));
        System.out.println(checkAnagramSol1("aaar","araa"));
        System.out.println(checkAnagramSol1("aaarddd","araa"));
        System.out.println(checkAnagramSol1("aaar","araasss"));

        System.out.println("----");

        System.out.println(checkAnagramSol2("listen","silent"));
        System.out.println(checkAnagramSol2("robed","bored"));
        System.out.println(checkAnagramSol2("aaar","araa"));
        System.out.println(checkAnagramSol2("aaarddd","araa"));
        System.out.println(checkAnagramSol2("aaar","araasss"));
    }
}
