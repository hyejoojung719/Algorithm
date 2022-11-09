package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1655_가운데를말해요 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 문제
		// 말한 값 중에 중간 값을 말해야함
		// 짝수면 가운데 두 수 중 작은 수
		// 1 : 1
		// 1 5 : 1
		// 1 2 5 : 2
		// 1 2 5 10 : 2
		// -99 1 2 5 10 : 2
		// -99 1 2 5 7 10 : 2
		// -99 1 2 5 5 7 10 : 5
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] ans = new int[N];
		PriorityQueue<Integer> tq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			
		}
		
		
	}
	
}
