package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_boj2251_물통 {

	public static void main(String[] args) throws Exception{
		/*
		 * 각각 부피가 A, B, C(1≤A, B, C≤200) 리터인 세 개의 물통이 있다. 
		 * 처음에는 앞의 두 물통은 비어 있고, 세 번째 물통은 가득(C 리터) 차 있다. 
		 * 이제 어떤 물통에 들어있는 물을 다른 물통으로 쏟아 부을 수 있는데, 
		 * 이때에는 한 물통이 비거나, 다른 한 물통이 가득 찰 때까지 물을 부을 수 있다. 
		 * 이 과정에서 손실되는 물은 없다고 가정한다.

이와 같은 과정을 거치다보면 세 번째 물통(용량이 C인)에 담겨있는 물의 양이 변할 수도 있다. 
첫 번째 물통(용량이 A인)이 비어 있을 때, 
세 번째 물통(용량이 C인)에 담겨있을 수 있는 물의 양을 모두 구해내는 프로그램을 작성하시오.
		 * */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int maxA = Integer.parseInt(st.nextToken());
		int maxB = Integer.parseInt(st.nextToken());
		int maxC = Integer.parseInt(st.nextToken());

		ArrayList<Integer> ans = new ArrayList<>();

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0,0,maxC});
		boolean[][][] visited = new boolean[maxA+1][maxB+1][maxC+1];


		while(!q.isEmpty()) {
			int[] water = q.poll();
			int a = water[0];
			int b = water[1];
			int c = water[2];


			if(visited[a][b][c]) continue;
			if(a==0) {
				ans.add(c);
			}

			visited[a][b][c] = true;

			// a->b
			if(a+b <= maxB) {
				q.offer(new int[] {0,a+b,c});
			}else {
				q.offer(new int[] {a+b-maxB , maxB ,c});
			}

			// a->c
			if(a+c <= maxC) {
				q.offer(new int[] {0,b,a+c});
			}else {
				q.offer(new int[] {a+c-maxC , b ,maxC});
			}

			// b->a
			if(b+a <= maxA) {
				q.offer(new int[] {b+a,0,c});
			}else {
				q.offer(new int[] {maxA , b+a-maxA ,c});
			}

			// b->c
			if(b+c <= maxC) {
				q.offer(new int[] {a,0,b+c});
			}else {
				q.offer(new int[] {a , b+c-maxC ,maxC});
			}

			// c->a
			if(a+c <= maxA) {
				q.offer(new int[] {c+a,b,0});
			}else {
				q.offer(new int[] {maxA , b ,a+c-maxA});
			}

			// c->b
			if(b+c <= maxB) {
				q.offer(new int[] {a,c+b,0});
			}else {
				q.offer(new int[] {a , maxB ,b+c-maxB});
			}
		}

		Collections.sort(ans);

		for (Integer a : ans) {
			System.out.print(a+" ");
		}
		System.out.println();

	}
}
