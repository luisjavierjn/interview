package WordLadderII;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Given two words (start and end), and a dictionary, find all shortest transformation
// sequence(s) from start to end, such that: 1) Only one letter can be changed at a time,
// 2) Each intermediate word must exist in the dictionary.
// For example, given: start = "hit", end = "cog", and dict = ["hot","dot","dog","lot","log"],
// return:
// [
//  ["hit","hot","dot","dog","cog"],
//  ["hit","hot","lot","log","cog"]
// ]
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
        List<List<String>> ladders = sol.findLadders(beginWord,endWord,wordDict);
        ladders.forEach(list -> {
            System.out.println("[" + String.join(",",list) + "]");
        });
    }
}
