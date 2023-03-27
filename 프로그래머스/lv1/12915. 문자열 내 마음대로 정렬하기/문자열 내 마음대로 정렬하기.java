import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        List<String> tmp = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            tmp.add(strings[i]);
        }
        Collections.sort(tmp, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.println(o1 + " " + o2);
                if (o1.charAt(n) == o2.charAt(n)) {
                    return o1.compareTo(o2);
                } else if (o1.charAt(n) < o2.charAt(n)) {
                    return -1;
                }
                return 1;
            }
        });
        
        String[] answer = tmp.toArray(new String[tmp.size()]);
        return answer;
    }
}