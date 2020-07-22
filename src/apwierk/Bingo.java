package apwierk;

import java.util.Scanner;
import java.util.Random;

public class Bingo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		//		p1 판
		int size = 5;
		int maxNum = 50;

		int [][] p1 = new int[size][size];
		int [][] p2 = new int[size][size];

		int [][] back1 = new int[size][size];
		int [][] back2 = new int[size][size];

		int [] temp = new int[size*size];

		for(int i = 0;i<temp.length;i++) {
			temp[i] = ran.nextInt(maxNum) + 1;
			for(int j = 0 ;j<i;j++) {
				if(temp[i] == temp[j]) {
					i--;
				}
			}
		}
		int k = 0;
		for(int i = 0;i<size;i++) {
			for(int j = 0 ;j<size;j++) {
				p1[i][j] = temp[k];
				k += 1;
			}
		}


		//		p2 판

		for(int i = 0;i<temp.length;i++) {
			temp[i] = ran.nextInt(maxNum) + 1;
			for(int j = 0 ;j<i;j++) {
				if(temp[i] == temp[j]) {
					i--;
				}
			}
		}
		k = 0;
		for(int i = 0;i<size;i++) {
			for(int j = 0 ;j<size;j++) {
				p2[i][j] = temp[k];
				k += 1;
			}
		}

		int win = 0;
		int turn = 0;

		boolean run = true;
		while(run) {
			System.out.println("	   -----p1-----");
			System.out.println();
			for(int i = 0;i<size;i++) {
				for(int j = 0 ;j<size;j++) {
					System.out.print(p1[i][j] + "\t");

				}
				System.out.println(); 
				System.out.println(); 
			}
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("	   -----p2-----");
			System.out.println();
			for(int i = 0;i<size;i++) {
				for(int j = 0 ;j<size;j++) {
					System.out.print(p2[i][j] + "\t");
				}
				System.out.println();
				System.out.println();
			}

			if(win == 1) {
				System.out.println("p1 승리");
				break;
			}else if(win == 2) {
				System.out.println("p2 승리");
				break;
			}

			if(turn % 2 == 0) {
				int idx1 = -1;
				int idx2 = -1;
				int idx3 = -1;
				int idx4 = -1;
				System.out.println("p1 차례");
				System.out.println("num : ");
				int num = scan.nextInt();
				for(int i = 0;i<size;i++) {
					for(int j = 0 ;j<size;j++) {
						if(p1[i][j] == num) {
							idx1 = i;
							idx2 = j;
						}
						if(p2[i][j] == num) {
							idx3 = i;
							idx4 = j;
						}
					}
				}
				if(idx1 != -1 || idx2 != -1) {
					back1[idx1][idx2] = 1;
				}
				if(idx3 != -1 || idx4 != -1) {
					back2[idx3][idx4] = 1;
				}
				turn += 1;
			}else if (turn % 2 == 1) {
				int idx1 = -1;
				int idx2 = -1;
				int idx3 = -1;
				int idx4 = -1;
				System.out.println("p2 차례");
				System.out.println("num : ");
				int num = scan.nextInt();
				for(int i = 0;i<size;i++) {
					for(int j = 0 ;j<size;j++) {
						if(p1[i][j] == num) {
							idx1 = i;
							idx2 = j;
						}
						if(p2[i][j] == num) {
							idx3 = i;
							idx4 = j;
						}
					}
				}
				if(idx1 != -1 || idx2 != -1) {
					back1[idx1][idx2] = 1;
				}
				if(idx3 != -1 || idx4 != -1) {
					back2[idx3][idx4] = 1;
				}
				turn += 1;
			}
			for(int i = 0;i<size;i++) {
				for(int j = 0 ;j<size;j++) {
					if(back1[i][j] == 1) {
						p1[i][j] = 0;
					}
					if(back2[i][j] == 1) {
						p2[i][j] = 0;
					}
				}
			}

			for(int i=0; i<size; i++) {
				int cnt = 0;
				for(int j=0; j<size; j++) {
					if(back1[i][j] == 1) {
						cnt++;
					}
				}
				if(cnt == 5) {
					win = 1;
					break;
				}
			}
			for(int i=0; i<size; i++) {
				int cnt = 0;
				for(int j=0; j<size; j++) {
					if(back2[i][j] == 1) {
						cnt++;
					}
				}
				if(cnt == 5) {
					win = 2;
					break;
				}
			}	

			// 세로 체크
			for(int j=0; j<size; j++) {
				int cnt = 0;
				for(int i=0; i<size; i++) {
					if(back1[i][j] == 1) {
						cnt ++;
					}
				}
				if(cnt == 5) {
					win = 1;
					break;
				}
			}
			for(int j=0; j<size; j++) {
				int cnt = 0;
				for(int i=0; i<size; i++) {
					if(back2[i][j] == 1) {
						cnt ++;
					}
				}
				if(cnt == 5) {
					win = 2;
					break;
				}
			}

			// 대각선 체크
			int cnt = 0;
			for(int i=0; i<size; i++) {
				if(back1[i][i] == 1) {
					cnt++;
				}
				if(cnt == 5) {
					win = 1;
					break;
				}
			}
			cnt = 0;
			for(int i=0; i<size; i++) {
				if(back2[i][i] == 1) {
					cnt++;
				}
				if(cnt == 5) {
					win = 2;
					break;
				}
			}

			// 대각선 체크
			cnt = 0;
			for(int i=0; i<size; i++) {
				if(back1[i][(size-1)-i] == 1) {
					cnt++;
				}
				if(cnt == 5) {
					win = 1;
					break;
				}
			}
			cnt = 0;
			for(int i=0; i<size; i++) {
				if(back2[i][(size-1)-i] == 1) {
					cnt++;
				}
				if(cnt == 5) {
					win = 2;
					break;
				}
			}
		}
	}

}
