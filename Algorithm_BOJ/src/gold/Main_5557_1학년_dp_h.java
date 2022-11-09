package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5557_1학년_dp_h {
	public static void main(String[] args) throws Exception{
		// 문제
		// +, - 를 넣어서 계싼
		// 상근이는 음수, 20넘는 수 모름
		// 계산했을 때 나오는 수가 0~20이어야 함
		// 상근이가 만들 수 있는 오바른 등식의 수는?

		// solution hint 
		// dp 테이블을 [N][21] 크기로 정의한다. 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken()); 
		}

		// dp 테이블
		long[][] dp = new long[N][21];

		// 초기화
		dp[0][A[0]]=1;

		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= 20; j++) {
				if(dp[i-1][j] != 0) {
					// 1. 더하기
					if((j+A[i]) <= 20) dp[i][j+A[i]] += dp[i-1][j];
					// 2. 빼기
					if((j-A[i]) >= 0) dp[i][j-A[i]] += dp[i-1][j];
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= 20; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println(dp[N-2][A[N-1]]);
	}
}
