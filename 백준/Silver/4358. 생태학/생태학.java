import java.io.*;
import java.util.*;

public class Main {

	static int total;
	static HashMap<String, Integer> map = new HashMap<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String word = "";

		while ((word = br.readLine()) != null) {

			map.computeIfAbsent(word, key -> new Integer(0));
			map.put(word, map.get(word) + 1);
			total++;
		}

		List<String> list = new ArrayList<>();
		for (String s : map.keySet())
			list.add(s);

		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			String name = list.get(i);
			int cnt = map.get(name);

			bw.write(name + " " + String.format("%.4f", (double) cnt * 100 / (double) total) + "\n");
		}
		bw.flush();
	}

}