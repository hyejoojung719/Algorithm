package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// dp로도 풀어야 할 것 같음
public class Main_1446_지름길_dijk {

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


		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());


		int[][] graph = new int[D+1][D+1];
		int inf = Integer.MAX_VALUE;
		for (int i = 0; i < D+1; i++) {
			for (int j = 0; j < D+1; j++) {

				if((j-i)==1) graph[i][j]=1;
				else graph[i][j] = inf;
			}
		}



		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			if(to>D) continue;	// 목적지보다 클 경우 패스

			if(graph[from][to] > weight) {
				graph[from][to] = weight;
			}
		}


		int[] dist = new int[D+1];	// 거리저장할 배열 생성
		boolean[] visited = new boolean[D+1];	// 방문 체크 배열 생성
		Arrays.fill(dist, inf);
		dist[0] = 0;	// 시작 포인트 초기화

		for (int i = 0; i <= D; i++) {
			// 노드 개수만큼 반복
			int nodeValue = inf;
			int nodeIdx = 0;
			
			for (int j = 0; j <= D; j++) {
				if(!visited[j] && dist[j] < nodeValue) {
					nodeIdx = j;
					nodeValue = dist[j];
				}
			}
			
			
			// 방문 처리
			visited[nodeIdx] = true;
			
			
			// 인접 노드 최소거리 값 갱신
			for (int j = 0; j <= D; j++) {
				if(graph[nodeIdx][j] != inf) {
					// 인접된 노드라면 
					if(dist[j] > dist[nodeIdx]+graph[nodeIdx][j]) {
						dist[j] = dist[nodeIdx]+graph[nodeIdx][j];
					}
				}
			}
			
		}
		
		System.out.println(dist[D]);



		// 다익스트라 알고리즘 적용하기
		// 1. dist[] 배열 생성, visited[] 배열 생성
		//		- dist 배열은 INF로 초기화
		// 		- dist[start]=0; 시작 포인트는 0으로 초기화
		// 2. 다익스트라 알고리즘 => 모든 노드 방문시 종료 -> 노드의 개수 만큼 반복
		// 2-1. 현재 거리 비용 중 최소 지점 선택
		//	 	변수1 : 해당 노드가 가지고 있는 현재 비용
		// 		변수2 : 해당 노드의 인덱스
		// 		방문하지 않고 현재 모든 거리비용 중 최소값 찾기 => dist배열에서
		//		변수1, 변수2 갱신
		// 		최종 선택 노드는 방문처리
		// 2-2. 해당 지점 기준 인접 노드의 최소 거리값 갱신
		//		인접 노드 선택
		//		인접 노드가 현재 가지는 최소 비용  (비교) 현재 선택되 노드 값 + 현재 노드에서 인접 노드로 가는 값 
		//		더 작은 값으로 dist 배열 갱신
		// 3. 최소 비용 출력


	}
}
