package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_boj2110_공유기설치 {
	static int[] houses;
	static int N, C;
	public static void main(String[] args) throws Exception {
		// N : 집 개수
		// C : 공유기 개수
		// 공유기 C개를 설치하려고 할 때, 가장 인접한 공유기 사이의 최대 거리 출력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		houses = new int[N];
		for (int i = 0; i < N; i++) {
			houses[i] = Integer.parseInt(br.readLine());
 		}
		
		Arrays.sort(houses);
		
		int L = 1;
		int R = houses[N-1]-houses[0];
		int ans = 0;
		while(L<=R) {
			int mid = (L+R)/2;
			if(checkInstall(mid)) {
				// 설치 가능하다면 
				ans = mid;
				L = mid + 1;
			}else {
				R = mid - 1;
			}
		}
		
		System.out.println(ans);
		
	}
	
	public static boolean checkInstall(int dis) {
		boolean ans = false;
		
		int cnt = 1;
		int last = houses[0];
		for (int i = 1; i < N; i++) {
			if(houses[i]-last>= dis) {
				cnt++;
				last = houses[i];
			}
		}
		
		if(cnt >= C) ans = true;
		
		return ans;
	}
}
