package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj11403_경로찾기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] graph = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());;
			}
		}
		
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					int r1 = graph[i][k];
					int r2 = graph[k][j];
					
					if(r1==1 && r2==1) {
						graph[i][j] = 1;
					}
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}
}
