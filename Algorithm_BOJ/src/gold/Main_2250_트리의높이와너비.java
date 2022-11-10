package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2250_트리의높이와너비 {
	static Node[] tree;
	static int cnt;

	static class Node{
		int col;
		int left;
		int right;
		public Node(int col, int left, int right) {
			super();
			this.col = col;
			this.left = left;
			this.right = right;
		}
	}

	// 왼쪽 서브트리 노드 개수 찾는 메소드
	static void leftSubTree(int root) {

		int left = tree[root].left;
		int right = tree[root].right;

		if(left!=-1) {
			cnt++;
			leftSubTree(left);
		}
		if(right!=-1) {
			cnt++;
			leftSubTree(right);
		}

		if(left==-1 && right==-1) return;
	}

	// col 지정하기 => 왼쪽 서브트리
	static void findColLeft(int root) {
		int col = tree[root].col;
		int left = tree[root].left;
		int right = tree[root].right;

		if(left!=-1) {
			findColLeft(left);
		}

		if(right!=-1) {
			tree[right].col += tree[root].col;
			findColLeft(right);
		}

		if(left==-1 && right==-1) return;
	}


	public static void main(String[] args) throws Exception {
		// 문제
		// 이진트리에서 같은 레벨은 같은 행
		// 한 열에는 한 노드
		// 임의 노드 기준 왼쪽 부트리는 해당 노드보다 왼쪽열, 오른쪽 부트리는 오른쪽 열
		// 가장 왼쪽열과 가장 오른쪽열 사이에 비어있는 열은 없음
		// 각 레벨 너비 = 가장 오른쪽 노드 열 번호 - 가장 왼쪾 노드 열 번호 + 1
		// 너비가 가장 넓은 레벨을 찾는다. => 여러 개면 작은 레벨

		// 입력
		// N(노드 개수)
		// 노드 번호외 왼쪽 자식 노드, 오른쪽 자식 노드, 자식 없으면 -1

		// 생각한 로직
		// => 루트 노드 기준 왼쪽 서브트리 노드 개수 +1이 루트노드의 위치
		// 1. 일단 트리 만들고
		// 2. 왼쪽 서브트리 노드 개수를 찾는 메소드 만든다. 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		tree = new Node[N+1];

		StringTokenizer st;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int value = Integer.parseInt(st.nextToken());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());

			tree[value] = new Node(0, left, right);
		}

		// 왼쪽 서브트리 개수 구하기
		for (int i = 1; i <= N; i++) {
			cnt = 0;
			int root = tree[i].left;
			if(root!=-1) {
				leftSubTree(root);
				cnt++;
			}
			tree[i].col = cnt+1;
			System.out.println(i+ "의 열 위치 :" + tree[i].col);
		}

		System.out.println("=====================");
		for (int i = 1; i <= N; i++) {
			System.out.println(i+ "의 열 위치 :" + tree[i].col);
		}


	}
}
