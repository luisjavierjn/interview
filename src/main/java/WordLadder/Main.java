package WordLadder;

import java.util.HashSet;
import java.util.Set;

// Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that only one letter can be changed at a time
// and each intermediate word must exist in the dictionary. For example, given:
// start = "hit"
// end = "cog"
// dict = ["hot","dot","dog","lot","log"]
// One shortest transformation is "hit" ->"hot" ->"dot" ->"dog" ->"cog", the program
// should return its length 5.
public class Main {
    static Solution sol = new Solution();
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        Set<String> wordDict = new HashSet<>();
        wordDict.add("hot");
        wordDict.add("dot");
        wordDict.add("dog");
        wordDict.add("lot");
        wordDict.add("log");
        int length = sol.ladderLength(beginWord,endWord,wordDict);
        System.out.println(length);
    }
}
