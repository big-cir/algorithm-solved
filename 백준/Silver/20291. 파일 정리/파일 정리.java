import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Map<String, Integer> map;
    public static void main(String[] args) throws IOException {
//        1. 파일을 확장자 별로 정리해서 몇 개씩 있는지 알려줘
//        2. 보기 편하게 확장자들을 사전 순으로 정렬해 줘
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String extention = br.readLine().split("\\.")[1];
            map.put(extention, map.getOrDefault(extention, 0) + 1);
        }

        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        for (int i = 0; i < map.size(); i++) {
            String key = keys.get(i);
            System.out.println(key + " " + map.get(key));
        }
    }
}
