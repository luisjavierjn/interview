package Tests.TwoStringsAnagram;

import java.util.Arrays;

// Minimum Number of Manipulations required to make two Strings Anagram Without Deletion of Character
// Given two strings s1 and s2, we need to find the minimum number of manipulations required to make two strings anagram without deleting any character.
// Note:- The anagram strings have same set of characters, sequence of characters can be different.
// Input :
//       s1 = "aba"
//       s2 = "baa"
// Output : 0
// Explanation: Both String contains identical characters
// Input :
//       s1 = "ddcf"
//       s2 = "cedk"
// Output : 2
// Explanation : Here, we need to change two characters
// in either of the strings to make them identical. We
// can change 'd' and 'f' in s1 or 'e' and 'k' in s2.
public class Main {
    // Counts the no of manipulations required
    // https://www.geeksforgeeks.org/minimum-number-of-manipulations-required-to-make-two-strings-anagram-without-deletion-of-character/
    static int countManipulations(String s1, String s2)
    {
        int count = 0;

        // store the count of character
        int char_count[] = new int[26];

        // iterate though the first String and update
        // count
        for (int i = 0; i < s1.length(); i++) {
            char_count[s1.charAt(i) - 'a']++;
        }

        // iterate through the second string
        // update char_count.
        // if character is not found in char_count
        // then increase count
        for (int i = 0; i < s2.length(); i++) {
            char_count[s2.charAt(i) - 'a']--;
        }

        for(int i = 0; i < 26; ++i)
        {
            if(char_count[i] != 0)
            {
                count+= Math.abs(char_count[i]);
            }
        }

        return count / 2;
    }

    // https://algo.monster/liteproblems/1347
    public static int minSteps(String s, String t) {
        // Initialize an array to count the frequency of each character in the string s
        int[] charFrequency = new int[26];

        // Populate the character frequency array with the count of each character in s
        for (int i = 0; i < s.length(); ++i) {
            charFrequency[s.charAt(i) - 'a']++;
        }

        // This variable will keep track of the minimum number of steps (character changes)
        int minSteps = 0;

        // Iterate over the string t and decrease the frequency of each character in the charFrequency array
        for (int i = 0; i < t.length(); ++i) {
            // If the character's frequency after decrementing is negative,
            // it means that t has an extra occurrence of this character
            // that is not matched by a character in s.
            if (--charFrequency[t.charAt(i) - 'a'] < 0) {
                // Since this character is extra and unneeded, increase the minSteps
                minSteps++;
            }
        }
        // Return the total minimum number of steps to make t an anagram of s
        return minSteps;
    }

    // https://walkccc.me/LeetCode/problems/1347/#__tabbed_1_2
    public static int minSteps2(String s, String t) {
        int[] count = new int[26];

        for (final char c : s.toCharArray())
            ++count[c - 'a'];

        for (final char c : t.toCharArray())
            --count[c - 'a'];

        return Arrays.stream(count).map(Math::abs).sum() / 2;
    }

    public static void main(String[] args) {
        String s1 = "ddcf";
        String s2 = "cedk";
        System.out.println(countManipulations(s1, s2));
        System.out.println(minSteps(s1,s2));
        System.out.println(minSteps2(s1,s2));
    }
}
