package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_boj1202_보석도둑 {
	
	static class Jewel implements Comparable<Jewel>{
		int w;
		int p;
		public Jewel(int w, int p) {
			super();
			this.w = w;
			this.p = p;
		}
		@Override
		public int compareTo(Jewel o) {
			return this.w-o.w;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Jewel[] jewels = new Jewel[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			jewels[i] = new Jewel(M,V);
		}
		
		int[] bags = new int[K];
		for (int i = 0; i < K; i++) {
			int C = Integer.parseInt(br.readLine());
			bags[i] = C;
		}
	}
}
