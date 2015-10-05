/* 
https://leetcode.com/problems/word-ladder/
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5. 

Assumption:
All words have the same length.
All words contain only lowercase alphabetic characters.*/

import java.util.*;
import java.lang.*;

public class WordLadder {
    
    public static void main (String args[]) {
        System.out.println (ladderLength ("hit", "cog", new HashSet<String>(Arrays.asList(new String[]{"hot","dot","dog","lot","log"}))));
    }
    
    public static int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        Set<String> intermediaryWords = new HashSet<String>();
        intermediaryWords.add(beginWord);
        
        int length = 1;
        while(!intermediaryWords.contains(endWord)) {
            boolean substitutionPossible = false;
            System.out.println(intermediaryWords);
            for(String each : intermediaryWords) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if(wordDict.contains(word) || word.equals(endWord)) {
                            if (!substitutionPossible)
                                intermediaryWords = new HashSet<String>();
                            substitutionPossible = true;
                            intermediaryWords.add (word);
                            wordDict.remove(word);
                        }
                    }
                }
            }
            length ++;
            if(!substitutionPossible) 
                return 0;
        }
        return length;
    }
}
