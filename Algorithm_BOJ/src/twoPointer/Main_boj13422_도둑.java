package twoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_boj13422_도둑 {
	public static void main(String[] args) throws Exception{
		// N : 집 개수
		// M : 훔칠 연속된 집 개수 M
		// K : 자동 방범장치 작동하는 최소 돈의 양

		// 붙잡히질 않을 M개의 연속된 집을 고르는 방법의 수는?

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int[] houses = new int[N];
			for (int i = 0; i < N; i++) {
				houses[i] = Integer.parseInt(st.nextToken());
			}

			int lp = 0;
			int rp = M-1;
			int cnt = 0;

			// 최초 연속된 집의 돈의 합
			int sum = 0;
			for (int i = 0; i < M; i++) {
				sum += houses[i];
			}
			if(sum < K) cnt++;

			if(N!=M) {
				while(lp<N-1) {
					sum -= houses[lp];
					lp++;
					rp++;
					if(rp == N) rp=0;
					sum += houses[rp];

					if(sum < K) cnt ++;
				}
			}

			sb.append(cnt+"\n");
		}

		System.out.println(sb);
	}

}
