import java.util.stream.Collectors;
class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        new_id = new_id.chars().map(Character::toLowerCase)            // 1단계
                .mapToObj(item -> String.valueOf((char) item))
                .filter(item -> !item.matches("[^a-z0-9\\-_.]"))      // 2단계
                .collect(Collectors.joining());

        // + : 한번 이상 반복
        new_id = new_id.replaceAll("\\.+", ".");                // 3 단계

        if (new_id.startsWith(".")) new_id = new_id.substring(1, new_id.length());  // 4단계
        if (new_id.endsWith(".")) new_id = new_id.substring(0, new_id.length() - 1);

        if (new_id.isEmpty()) new_id = "a";     // 5단계

        if (new_id.length() >= 16) {            // 6단계
            new_id = new_id.substring(0, 15);
            if (new_id.endsWith(".")) new_id = new_id.substring(0, new_id.length() - 1);
        }

        if (new_id.length() <= 2) {
            String str = String.valueOf(new_id.charAt(new_id.length() - 1));
            while (true) {
                new_id += str;
                if (new_id.length() == 3) break;
            }
        }
        
       return new_id;
    }
}