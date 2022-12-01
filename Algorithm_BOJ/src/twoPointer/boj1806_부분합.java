package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1806_부분합 {
	public static void main(String[] args) throws IOException{
		
		// 10000이하의 자연수로 이루어진 길이 N짜리 수열이 있음
		// 연속된 부분합중 그 합이 S이상 되는 것 중 가장 짧은 것의 길이 구하기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i <N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = 0;
		int sum = 0;
		int length = Integer.MAX_VALUE;
		
		while(left<=N && right<=N) {
			
			if(sum >= S) {
				length = Math.min(length, right-left);
			}
			
			if(sum < S) {
				sum += arr[right];
				right++;
			}else {
				sum -= arr[left];
				left++;
			}
		}
		
		if(length == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(length);
			
	}
}
