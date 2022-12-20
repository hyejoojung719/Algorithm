package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_boj10453_문자열변환 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {
			st = new StringTokenizer(br.readLine());
			String A = st.nextToken();
			String B = st.nextToken();
			
			List<Integer> idxArr = new ArrayList<>();
			for (int j = 0; j < A.length(); j++) {
				if(A.charAt(j)=='a') idxArr.add(j);
			}
			List<Integer> idxArr2 = new ArrayList<>();
			for (int j = 0; j < B.length(); j++) {
				if(B.charAt(j)=='a') idxArr2.add(j);
			}
			int sum=0;
			for (int j = 0; j < idxArr.size(); j++) {
				sum += Math.abs(idxArr.get(j)-idxArr2.get(j));
			}
			sb.append(sum+"\n");
		}
		System.out.println(sb);
	}
}
