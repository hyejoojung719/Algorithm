package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_boj16928_뱀과사다리게임 {
	public static void main(String[] args) throws Exception{
		// N : 사다리 수
		// M : 뱀의 수
		// 주사위 1~6
		// 100번 칸에 도착하기 위해 주사위를 굴러야하는 최소 개수 ?
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] board = new int[101];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			board[from] = to;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			board[from] = to;
		}
		
		int cnt = 0;
		int start = 1;
		// bfs
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		boolean[] visited = new boolean[101];
		visited[start] = true;
		
		wh : while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int temp = q.poll();
				
				if(temp==100) break wh;
				
				if(board[temp]!=0) {
					temp = board[temp];
				}
				
				for (int j = 1; j <= 6; j++) {
					int to = temp+j;
					if(to<=100 && !visited[to]) {
						q.offer(to);
						visited[to] = true;
					}
				}
			}
			
			cnt++;
		}
		
		System.out.println(cnt);
		
		
	}
}
