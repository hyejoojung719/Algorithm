package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 코드가 더러워서.. 깔끔하게 한 번 더 풀어야할 것 같음
public class Main_13904_과제_pq_sol1 {
	
	static class Homework1 implements Comparable<Homework1>{
		int d;
		int w;
		public Homework1(int d, int w) {
			super();
			this.d = d;
			this.w = w;
		}
		
		// 일수 기준 내림차순 정렬
		@Override
		public int compareTo(Homework1 o) {
			return o.d - this.d;
		}
	}
	
	static class Homework2 implements Comparable<Homework2>{
		int d;
		int w;
		public Homework2(int d, int w) {
			super();
			this.d = d;
			this.w = w;
		}
		
		// 점수 기준 내림차순 정렬
		@Override
		public int compareTo(Homework2 o) {
			return o.w - this.w;
		}
	}
	
	public static void main(String[] args) throws Exception{
		// 문제
		// 하루에 한 과제
		// 마감일 지난건 X
		// 얻을 수 있는 점수 최댓값?
		
		// 입력
		// 정수 N
		// N개이 줄에 d(과제 마감일까지 남은 일수) w(과제 점수)
		
		// 출력
		// 얻을 수 있는 점수 최대값?
		
		// 생각한 풀이 방법
		// 1. 일단 가장 마지막 일수 부터 1일까지 각각 가능한 과제 점수를 나열한다. 
		// 2. 각각의 일수에서 가장 최대 점수를 뽑는다.(우선순위 큐 사용)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Homework1> qByD = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken()); 
			qByD.offer(new Homework1(d, w));
		}

		int day = qByD.peek().d;
		PriorityQueue<Homework2> qByW = new PriorityQueue<>();
		int wSum=0;
		while(true) {
			
			if(qByD.isEmpty() || day==0) break;

			while(true) {
				if(qByD.isEmpty() || qByD.peek().d < day) break;
				
				Homework1 hw =qByD.poll();
				
				qByW.offer(new Homework2(hw.d, hw.w));
			}
			
			
			if(!qByW.isEmpty()) wSum += qByW.poll().w;
			
			
			int size = qByW.size();
			for (int i = 0 ; i < size; i++) {
				qByD.offer(new Homework1(qByW.peek().d, qByW.poll().w));
			}
			
			day--;
		}
		
		System.out.println(wSum);
	}
}
