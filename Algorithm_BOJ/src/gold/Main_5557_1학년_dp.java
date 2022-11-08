package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5557_1학년_dp {
	public static void main(String[] args) throws Exception{
		// 문제
		// +, - 를 넣어서 계싼
		// 상근이는 음수, 20넘는 수 모름
		// 계산했을 때 나오는 수가 0~20이어야 함
		// 상근이가 만들 수 있는 오바른 등식의 수는?
		
		// DP 
		// 1. 테이블 정의 dptable
		// 2. 초기값 구하기
		// 3. 점화식 구하기
		// 4. dptable 채우기
		
		// 생각한 로직
		// 1. 참조해야할 개수가 2 -> 4 -> 8 -> 16 -> .... 이전 개수의 *2만큼 증가
		// 2. 2차원 배열을 만들고 0=>+, 1=>-
		// 3. 초기값
			// 3-1. dp[0][0]=0, dp[0][1]=0, dp[1][0] = 첫번째 원소 + 두번쨰 원소, dp[1][1] = 첫번째 원소 - 두번째 원소
		// 4. 점화식
			// dp[i][?] = dp[i/2][?] (+ or -) (계산할 값) => ? : 0,1 반복.. 
			// 결과 값이 0~20 범위 밖이면 제외 => dp table에 -1로 채우고 -1인 애는 continue
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken()); 
		}
		
		// dp 테이블
		int length= (int)(2 + 2*(Math.pow(2, N-1)-1));
		int[][] dp = new int[length/2][2];
		
		// 초기화
		dp[0][0] = dp[0][1] = 0;
		
		int num1 = A[0]+A[1];
		int num2 = A[0]-A[1];
		if(0<=num1 && num1<=20) dp[1][0] = num1;
		else dp[1][0] = -1;
		if(0<=num2 && num2<=20) dp[1][1] = num2;
		else dp[1][1] = -1;
		
		System.out.println(dp[1][0] + " : " +dp[1][1]);
		
		for (int i = 2; i < N; i++) {
			int size = (int)Math.pow(2, i);
			int s = size/2;
			int k = s/2;
			int t = 0;
			System.out.println("size : " + size);
			for (int j = 0; j < size; j++) {
				
				System.out.println("k : " + k);
				System.out.println("t : " + t);
				System.out.println("dp[k][t] : " + dp[k][t]);
				
				if(j%2==0) {
					// +
					if(dp[k][t] == -1) {
						dp[k][0] = -1;
					}else {
						int temp = dp[k][t] + A[i];
						if(0<=temp && temp<=20) dp[s][0] = temp;
						else dp[s][0] = -1;
					}
					
				}else {
					// -
					
					if(dp[k][t] == -1) {
						dp[k][0] = -1;
					}else {
						int temp = dp[k][t] - A[i];
						if(0<=temp && temp<=20) dp[s][1] = temp;
						else dp[s][1] = -1;
					}
					
					if(j%4==0) k++;
					
					s++;
					
					if(t==0) t=1;
					else t=0;
				}
				
			}
		}
		
		for (int[] is : dp) {
			for (int x :is) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
		
		System.out.println(length);
		
		int total=0;
		for (int i = length/2-1; i >= length/2-Math.pow(2,N-1)/2; i--) {
			for (int j = 0; j < 2; j++) {
				if(dp[i][j]!=-1) {
					total++;
				}
			}
			System.out.println();
		}
		System.out.println(total);
	}
}
