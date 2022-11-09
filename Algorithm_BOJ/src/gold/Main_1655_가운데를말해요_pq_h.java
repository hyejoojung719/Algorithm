package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1655_가운데를말해요_pq_h {
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
		
		// hint 
		// 최대힙, 최소힙 사용
		// 최대힙 : 루트노드가 가장 큰 값 => 내림차순 정렬
		// 최소힙 : 루트노드가 가장 작은 값 => 오름차순 정렬
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((o1,o2) -> o2-o1);
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((o1,o2) -> o1-o2);
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(minHeap.size() == maxHeap.size()) maxHeap.offer(num);
			else minHeap.offer(num);
			
			if(!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
				int temp = minHeap.poll();
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(temp);
			}
			
			sb.append(maxHeap.peek() + "\n");
		}
		
		System.out.println(sb);
		
		
	}
	
}
