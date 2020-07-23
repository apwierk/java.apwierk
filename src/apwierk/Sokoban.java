package apwierk;

import java.util.Scanner;
import java.util.Random;

public class Sokoban {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		final int SIZE = 7;
		final int PLAYER = 2;
		final int BALL = 3;
		final int GOAL = 7;
		final int WALL = 9;

		int [][] map = new int[SIZE][SIZE];

		int Wally = 0;
		int Wallx = 0;
		int Bally = 0;
		int Ballx = 0;
		int Goaly = 0;
		int Goalx = 0;

		int myy = 0;
		int myx = 0;

		int win = 0;

		//		벽 설치
		System.out.println("설치할 벽의 개수를 입력하시오(단, 총 칸의 수는 49개) : ");
		int num = scan.nextInt();
		for(int i = 0 ; i < num; i++) {
			Wally = ran.nextInt(SIZE);
			Wallx = ran.nextInt(SIZE);
			if(map[Wally][Wallx] != 0) {
				i -= 1;
			}else {
				map[Wally][Wallx] = 9;
			}
		}

		//		공 설치
		for(int i = 0 ; i < 1; i++) {
			Bally = ran.nextInt(SIZE-2)+1;
			Ballx = ran.nextInt(SIZE-2)+1;
			if(map[Bally][Ballx] != 0) {
				i -= 1;
			}else {
				map[Bally][Ballx] = 3;
			}
		}

		//		목적지 설치
		for(int i = 0 ; i < 1; i++) {
			Goaly = ran.nextInt(SIZE);
			Goalx = ran.nextInt(SIZE);
			if(map[Goaly][Goalx] != 0) {
				i -= 1;
			}else {
				map[Goaly][Goalx] = 7;
			}
		}

		//		출발지 설정
		for(int i = 0 ; i < 1; i++) {
			myy = ran.nextInt(SIZE);
			myx = ran.nextInt(SIZE);
			if(map[myy][myx] != 0) {
				i -= 1;
			}else {
				map[myy][myx] = 2;
			}
		}

		boolean run  = true;
		while(run) {

			//		print
			for(int i = 0 ; i< SIZE;i++) {
				for(int j = 0 ; j < SIZE;j++) {
					System.out.print(map[i][j] + " ");
				}System.out.println();
			}
			
			if(win == 1) {
				System.out.println("게임종료");
				break;
			}

			//			내 위치 찾기
			for(int i = 0 ; i< SIZE;i++) {
				for(int j = 0 ; j < SIZE;j++) {
					if(map[i][j] == 2) {
						myy = i;
						myx = j;
					}
				}
			}

			//			이동하기
			System.out.println("이동할 방향을 선택하십시오.");
			System.out.println("4)좌 , 6)우, 8)상, 2)하");
			int sel = scan.nextInt();

			if(sel == 4) {
				if(myx > 0) {
					if(map[myy][myx-1] != 9) {
						if(map[myy][myx-1] == 3) {
							if(map[myy][myx-2] == 7) {
								win = 1;
							}
							map[myy][myx-2] = 3;
						}
						map[myy][myx] = 0;
						map[myy][myx-1] = 2;
					}else {
						System.out.println("이동 불가 (벽)");
						continue;
					}
				}else {
					System.out.println("이동 불가 (벽)");
					continue;
				}

			}else if(sel == 6) {
				if(myx < SIZE-1) {
					if(map[myy][myx+1] != 9) {
						if(map[myy][myx+1] == 3) {
							if(map[myy][myx+2] == 7) {
								win = 1;
							}
							map[myy][myx+2] = 3;
						}
						map[myy][myx] = 0;
						map[myy][myx+1] = 2;
					}else {
						System.out.println("이동 불가 (벽)");
						continue;
					}
				}else {
					System.out.println("이동 불가 (벽)");
					continue;
				}
			}else if(sel == 8) {
				if(myy > 0) {
					if(map[myy-1][myx] != 9) {
						if(map[myy-1][myx] == 3) {
							if(map[myy-2][myx] == 7) {
								win = 1;
							}
							map[myy-2][myx] = 3;
						}
						map[myy][myx] = 0;
						map[myy-1][myx] = 2;
					}else {
						System.out.println("이동 불가 (벽)");
						continue;
					}
				}else {
					System.out.println("이동 불가 (벽)");
					continue;
				}
			}else if(sel == 2) {
				if(myy < SIZE-1) {
					if(map[myy+1][myx] != 9) {
						if(map[myy+1][myx] == 3) {
							if(map[myy+2][myx] == 7) {
								win = 1;
							}
							map[myy+2][myx] = 3;
						}
						map[myy][myx] = 0;
						map[myy+1][myx] = 2;
					}else {
						System.out.println("이동 불가 (벽)");
						continue;
					}
				}else {
					System.out.println("이동 불가 (벽)");
					continue;
				}
				
			}


		}
	}

}
