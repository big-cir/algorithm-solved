import java.util.ArrayList;
import java.util.List;
class Solution {
    private static final String words = "AEIOU";
    private static List<String> list;

    public static void makeAllWords(char[] wordArr, String word) {
        list.add(word);

        if (word.length() == 5) return;

        for (char x : wordArr) {
            makeAllWords(wordArr, word + x);
        }
    }

    public int solution(String word) {
        list = new ArrayList<>();
        char[] wordArr = words.toCharArray();
        makeAllWords(wordArr, "");
        int answer = 0;
        answer = list.indexOf(word);

        return answer;
    }
}