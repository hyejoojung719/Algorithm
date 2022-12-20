package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_boj2143_두배열의합 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		int[] B = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		// 부배열 합 구하기
		ArrayList<Integer> sumA = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int num = A[i];
			sumA.add(num);
			for (int j = i+1; j < n; j++) {
				num += A[j];
				sumA.add(num);
			}
		}
		
		ArrayList<Integer> sumB = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			int num = B[i];
			sumB.add(num);
			for (int j = i+1; j < m; j++) {
				num += B[j];
				sumB.add(num);
			}
		}
		
		Collections.sort(sumA);
		Collections.sort(sumB);
		
//		for (Integer integer : sumA) {
//			System.out.print(integer + " ");
//		}
//		System.out.println();
//		for (Integer integer : sumB) {
//			System.out.print(integer + " ");
//		}
//		System.out.println();
		
		// 투포인터로 T가 되는 경우 구하기
		int L = 0;
		int R = sumB.size()-1;
		int cnt = 0;
		while(R>=0 && L<=sumA.size()-1) {
			int sum = sumA.get(L) + sumB.get(R);
//			System.out.println("L : R = " + sumA.get(L) + " : " +sumB.get(R));
//			System.out.println("sum " + sum);
			if(sum>T) {
				R--;
			}else if(sum<T){
				L++;
			}else {
				int tempL = L;
				while(L<=sumA.size()-1 && sumA.get(L)==sumA.get(tempL)) {
					cnt++;
					L++;
				}
//				System.out.println("cnt : " + cnt);
				
				int tempR = R;
				while(R>=0 && sumB.get(R)==sumB.get(tempR)) {
					cnt++;
					R--;
				}
				
				cnt-=1;
//				System.out.println("cnt : " + cnt);
			}
		}
		
		System.out.println(cnt);
		
	}
}
