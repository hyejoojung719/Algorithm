package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_boj1092_배 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 크레인
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer> cranes = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			cranes.add(Integer.parseInt(st.nextToken()));
		}
		int M = Integer.parseInt(br.readLine()); // 박스
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer> boxes = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			boxes.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(cranes, Collections.reverseOrder());
		Collections.sort(boxes, Collections.reverseOrder());

		
		if(cranes.get(0)<boxes.get(0)) {
			System.out.println(-1);
		}else {
			int time = 0;
			int idx = 0;
			while(!boxes.isEmpty()) {
				time++;
				for (int i = 0; i < N; i++) {
					int crane = cranes.get(i);
					for (int j = idx, size = boxes.size(); j < size; j++) {
						if(crane>=boxes.get(j)) {
							boxes.remove(j);
							break;
						}
						idx = j+1;
					}
				}
				idx = 0;
			}
			System.out.println(time);
		}
	}
}
