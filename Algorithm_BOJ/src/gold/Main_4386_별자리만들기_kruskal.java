package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4386_별자리만들기_kruskal {
	
	static int[] parents;
	
	static class Node implements Comparable<Node>{
		int n1;
		int n2;
		double weight;
		
		public Node(int n1, int n2, double weight) {
			super();
			this.n1 = n1;
			this.n2 = n2;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return (int) (this.weight - o.weight);
		}
	}
	
	public static void main(String[] args) throws Exception{
		// 문제
		// n개 별로 별자리 만들기
		// 별자리 조건
			// 두 별을 일직선으로 이은 형태
			// 모든 별들은 별자리 위 선을 통해 직,간접적으로 이어진 형태 => 사이클X
		// 별자리를 만드는 최소 비용(비용 - 두 별 사이 거리)
		// 별의 좌표는 실수로 주어진다.
		// 별 100 개까지 
		
		// MST 정리 - 간적크, 간많프(일반적), 두 가지 방법 모두 풀어보기
		// - 무방향 가중치 그래프
		// - 사이클 X
		// 1. 크루스칼
			// - 무조건 최소 간선만 선택
			// - 간선들을 가중치 기준 오름차순 정렬
			// - make() 상위 노드 초기화
			// - find() 부모 노드 찾기
			// - union() 최상위 노드 합치기 =>사이클 X
			// 코드 로직
			// 1) 정점 정보를 입력받을 배열 생성, 정점의 부모노드 저장할 parents 배열 샌성
			// 2) 가중치 기준 정점 정보 배열 오름차순 정렬
			// 3) parents 배열 초기화 => 자기 자신 가리키게
			// 4) union, find 메소드 생성
					// 서로소 집합
						// - union 연산 => 서로 연결된 두 노드 확인하기
							// - a, b 각 노드의 루트 노드  A, B 찾기
							// - A를 B의 부모노드로 설정(더 작은 부모노드를 가리키도록)
						// - 사이클 찾는 법
							// - 간선을 확인하여 두 노드의 루트 노드 확인 -> 루트노드가 서로 같다면 사이클이 존재하는것
							// -> 다르다면 union 진행
			// 5) 간선 수 만큼 루프 돌리기
					// 5-1) find 해서 부모노드가 서로 다를 때만 union하고 가중치를 더한다. 
		
		// 2. 프림
			// - 인접행렬 생성
			// - 우선순위 큐에 시작 정점 1을 담아  시작
			// - 연결된 정점의 모든 간선들 중 방문하지 않은 Node 탐색, pq 삽입
			// - 모든 노드 반복할 때까지 반복
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		double[][] stars = new double[N+1][2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			stars[i][0] = x;
			stars[i][1] = y;
		}
		
		Queue<Node> q = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			for (int j = i; j <= N; j++) {
				if(i!=j) {
					double dis = Math.sqrt(Math.pow(stars[i][0]-stars[j][0],2)+Math.pow(stars[i][1]-stars[j][1],2));
					q.offer(new Node(i,j,dis));
				}
			}
		}
		
		parents = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
		double weight = 0;
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			if(find(node.n1)!=find(node.n2)) {
				union(node.n1, node.n2);
				weight += node.weight;
			}
		}
		
		System.out.printf("%.2f",weight);
		
	}
	
	public static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		if(px<py) {
			parents[py] = px;
		}else {
			parents[px] = py;
		}
	}
	
	public static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
}
