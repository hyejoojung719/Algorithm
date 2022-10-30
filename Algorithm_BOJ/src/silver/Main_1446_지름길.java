package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1446_지름길 {
	
	static class Node implements Comparable<Node>{
		int next;
		int weight;
		public Node(int next, int weight) {
			super();
			this.next = next;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return o.weight-this.weight; // next 기준 내림차순
		}
	}
	
	public static void main(String[] args) throws Exception{
		// 최단 경로 알고리즘
		// 1. 다익스트라
		// 2. 플로이드 워셜
		// 3. 벨만 포드 
		
		// 최단 경로 알고리즘 문제 상황
		// 1. 한 지점에서 다른 지점까지 최단 경로
		// 2. 모든 지점에서 다른 모든 지점까지 최단 경로
		// 3. 한 지점에서 다른 모든 지점까지 최단 경로
		
		// 다익스트라
		// 1. 특정 노드 선택
		// 2. 최단 거리 테이블 초기화
		// 3. 방문하지 않은 노드 중 최단 거리가 가장 짧은 노드 선택
		// 4. 해당 노드를 거치면서 다른 노드로 가는 빕용 계산하여 최단 거리 테이블 갱신
		// 3번, 4번 반복
		
		// 문제 
		// D 킬로미터 고속도로를 지나야함
		// 지름길 => 일방 통행
		// 세준이가 운전해야 하는 거리 최솟값
		
		// 입력
		// 지름길 N, 고속도로 길이 D
		// N개의 줄에 지름길 시작 위치, 도착 위치, 지름길 길이 주어짐
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		ArrayList<ArrayList<Node>> list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < 10001; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			if(next<=D) {
				list.get(start).add(new Node(next, weight));
			}
			
		}
		
		int now=0;
		int dis=0;
		while(now<D) {
			int size = list.get(now).size(); 
			System.out.println("now : "  + now);
			if(size>0) {
				// 지름길이 있는 경우
				// next와 현재 위치 뺀 거리와 지름길 거리를 비교한다.
				// 만약 지름길 여러 개 있고 목적지가 다 다른 경우
				// 가장 목적지가 큰 애들 부터 비교 
					// 작은 목적지 애들은 큰 목적지를 기준으로 계산
				// temp값과 비교하며 갱신
				
				int tempnow = now;
				int temp = Integer.MAX_VALUE;	// 거리비교 위한 임시 변수
				int before=list.get(now).get(0).next;	// 초기 지름길(가장 next가 큰 애)
				for (int i = 0; i < size; i++) {
					Node node = list.get(tempnow).get(i);
					int next = node.next;
					
					if(before > next) {
						if((before-next)+Math.min(node.weight, next-tempnow) < temp) {
							temp = (before-next)+Math.min(node.weight, next-tempnow);
							now = next;
						}
					}else {
						if(Math.min(next-tempnow, node.weight) <temp) {
							temp = Math.min(next-tempnow, node.weight);
							now = next;
						}
					}
				}
				dis+=temp;
				if(tempnow==now) {
					now++;
				}
			}else {
				now++;
				dis++;
			}
		}
		
		System.out.println(dis);
		
		
	}
}
