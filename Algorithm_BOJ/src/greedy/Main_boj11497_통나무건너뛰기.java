package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 덱을 사용할 수 있따.

public class Main_boj11497_통나무건너뛰기 {
	public static void main(String[] args) throws Exception{
		// N : 통나무 개수
		// Li : 통나무 놏이
		
		// 최소 난이도 출력(난이도는 높이의 최대차로 결정)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			
			int[] arr2 = new int[N];
			arr2[0] = arr[0];
			int idx = N/2;
			arr2[idx] = arr[N-1];
			
			for (int i = 1, idx2 = N-1; i <= N-2; i++) {
				
				if(i%2==0) {
					// 짝수면 -
					idx-=i;
					arr2[idx] = arr[--idx2];
				}else {
					// 홀수면 +
					idx+=i;
					arr2[idx] = arr[--idx2];
				}
			}
			
			
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				if(i==N-1) max = Math.max(max, Math.abs(arr2[i]-arr2[0]));
				else max = Math.max(max,  Math.abs(arr2[i]-arr2[i+1]));
			}
			
			sb.append(max+"\n");
			
		}
		System.out.println(sb);
	}
}
