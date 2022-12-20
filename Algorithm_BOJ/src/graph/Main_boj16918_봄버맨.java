package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj16918_봄버맨 {
	static int R,C,N;
	
	static class Bomb{
		char status;
		int installedTime;
		public Bomb(char status, int installedTime) {
			super();
			this.status = status;
			this.installedTime = installedTime;
		}
	}
	
	static void setBomb(Bomb[][] arr, int time) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(arr[i][j].status == '.') {
					arr[i][j] = new Bomb('O', time) ;
				}
			}
		}
	}
	
	static void explode(Bomb[][] arr, int time) {
		boolean[][] visited = new boolean[R+1][C+1];
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				Bomb bomb = arr[i][j];
				if((time-bomb.installedTime==3) && bomb.status == 'O' ) {
					bomb.status = '.';
					visited[i][j] = true;
					
					if(j+1 < C && !visited[i][j+1] && (time-arr[i][j+1].installedTime!=3)) {
						arr[i][j+1].status = '.';
						visited[i][j+1] = true;
					}
					if(j-1 >= 0 && !visited[i][j-1] && (time-arr[i][j-1].installedTime!=3)) {
						arr[i][j-1].status = '.';
						visited[i][j-1] = true;
					}
					if(i-1 >= 0 && !visited[i-1][j] && (time-arr[i-1][j].installedTime!=3)) {
						arr[i-1][j].status = '.';
						visited[i-1][j] = true;
					}
					if(i+1 < R  && !visited[i+1][j] && (time-arr[i+1][j].installedTime!=3)) {
						arr[i+1][j].status = '.';
						visited[i+1][j] = true;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		// 폭탄이 있는 칸은 3초 후에 폭발
		// 인접한 곳에 있는 폭탄은 연쇄 폭발 X
		
		// R * C
		// N초
		
		// 0. 초기 폭탄 셋팅
		// 1. .
		// 2. 빈 곳에 폭탄 설치
		// 3. 0번 폭탄 터짐
		// 4. 빈 곳에 폭탄 설치
		// 5. 2번 폭탄 터짐
		// 6. 빈 곳체 폭탄 설치
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		int time=0;
		Bomb[][] board = new Bomb[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = new Bomb(str.charAt(j),time);
			}
		}
		
		while(time<N) {
			time++;
			if(time==1) continue;
			else if(time % 2 == 0) {
				// 빈 곳에 폭탄 설치
				setBomb(board, time);
			}else {
				// 폭탄 터짐
				explode(board, time);
			}
			
		}
		for (Bomb[] bombs : board) {
			for (Bomb bomb : bombs) {
				System.out.print(bomb.status);
			}
			System.out.println();
		}
	}
}
