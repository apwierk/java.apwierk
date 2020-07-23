package apwierk;

import java.util.Scanner;

public class Omok {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][] omok = {
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
		};

		int p1x = 0;
		int p1y = 0;
		int p2x = 0;
		int p2y = 0;

		int win = 0;
		int turn = 0;

		boolean run = true;
		while(run) {
			System.out.println("  0 1 2 3 4 5 6 7 8 9");
			int k = 0;
			for(int i = 0 ;i<omok.length;i++) {
				System.out.print(k + " ");
				k += 1;
				for(int j = 0 ; j< omok[i].length;j++) {
					if(omok[i][j] == 0) {
						System.out.print(omok[i][j] + " ");
					}else if(omok[i][j] == 1) {
						System.out.print("○ ");	
					}else if(omok[i][j] == 2) {
						System.out.print("● ");	
					}

				}
				System.out.println();
			}
			System.out.println();

			if(win == 1) {
				System.out.println("p1 승리");
				break;
			}else if(win == 2) {
				System.out.println("p2 승리");
				break;
			}

			if(turn % 2 == 0) {
				System.out.println("p1 y : ");
				p1y = scan.nextInt();
				System.out.println("p1 x : ");
				p1x = scan.nextInt();
				if(omok[p1y][p1x] == 0) {
					omok[p1y][p1x] = 1;
				}else {
					System.out.println("다시 선택하십시오.");
					turn -= 1;
					continue;
				}
				turn += 1;
			}else if(turn % 2 == 1) {
				System.out.println("p2 y : ");
				p2y = scan.nextInt();
				System.out.println("p2 x : ");
				p2x = scan.nextInt();
				if(omok[p2y][p2x] == 0) {
					omok[p2y][p2x] = 2;
				}else {
					System.out.println("다시 선택하십시오.");
					turn -= 1;
					continue;
				}
				turn += 1;
			}

			//	가로 
			for(int i = 0 ;i<omok.length;i++) {
				for(int j = 0 ;j<omok[i].length-5;j++) {
					if(omok[i][j] == 1 && omok[i][j+1] == 1 && omok[i][j+2] == 1 && omok[i][j+3] == 1 && omok[i][j+4] == 1) {
						win = 1;
					}
					if(omok[i][j] == 2 && omok[i][j+1] == 2 && omok[i][j+2] == 2 && omok[i][j+3] == 2 && omok[i][j+4] == 2) {
						win = 2;
					}
				}
			}

			//	세로
			for(int i = 0 ;i<omok.length-5;i++) {
				for(int j = 0 ;j<omok[i].length;j++) {
					if(omok[i][j] == 1 && omok[i+1][j] == 1 && omok[i+2][j] == 1 && omok[i+3][j] == 1 && omok[i+4][j] == 1) {
						win = 1;
					}
					if(omok[i][j] == 2 && omok[i+1][j] == 2 && omok[i+2][j] == 2 && omok[i+3][j] == 2 && omok[i+4][j] == 2) {
						win = 2;
					}
				}

			}

			//	오른대각선
			for(int i = 0 ;i<omok.length-5;i++) {
				for(int j = 0 ;j<omok[i].length-5;j++) {
					if(omok[i][j] == 1 && omok[i+1][j+1] == 1 && omok[i+2][j+2] == 1 && omok[i+3][j+3] == 1 && omok[i+4][j+4] == 1) {
						win = 1;
					}
					if(omok[i][j] == 2 && omok[i+1][j+1] == 2 && omok[i+2][j+2] == 2 && omok[i+3][j+3] == 2 && omok[i+4][j+4] == 2) {
						win = 2;
					}
				}
			}
			
//			왼대각선
			for(int i = 9 ;i>omok.length-5;i--) {
				for(int j = 0 ;j<omok[i].length-5;j++) {
					if(omok[i][j] == 1 && omok[i-1][j+1] == 1 && omok[i-2][j+2] == 1 && omok[i-3][j+3] == 1 && omok[i-4][j+4] == 1) {
						win = 1;
					}
					if(omok[i][j] == 2 && omok[i-1][j+1] == 2 && omok[i-2][j+2] == 2 && omok[i-3][j+3] == 2 && omok[i-4][j+4] == 2) {
						win = 2;
					}
				}
			}

		}


	}

}
