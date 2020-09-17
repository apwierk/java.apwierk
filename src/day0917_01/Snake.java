package day0917_01;

import java.util.Scanner;
import java.util.Random;

public class Snake {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		int size = 10;
		int[][] map = new int[size][size];

		int[] x = new int[4];
		int[] y = new int[4];
		int snakeSize = 4;

		int itemCount = 4;
		int itemNum = 9;


		for(int i=0; i<4; i++) {
			x[i] = i;
			map[y[i]][x[i]] = i + 1;
		}

		while(true) {
			int rY = ran.nextInt(size);
			int rX = ran.nextInt(size);

			if(map[rY][rX] == 1 || map[rY][rX] == 2 || 
					map[rY][rX] == 3 || map[rY][rX] == 4) {
				continue;
			}
			map[rY][rX] = itemNum;				

			itemCount -= 1;

			if(itemCount == 0) { break;	}
		}


		while(true) {

			for(int i=0; i<size; i++) {
				for(int j=0; j<size; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();

			System.out.print("4)left 6)right 8)up 2)down : ");
			int sel = scan.nextInt();


			int xx = 0;
			int yy = 0;
			if(sel == 4) {
				yy = y[0];
				xx = x[0] - 1;
			}
			else if(sel == 6) {
				yy = y[0];
				xx = x[0] + 1;
			}
			else if(sel == 8) {
				yy = y[0] - 1;
				xx = x[0];
			}else if(sel == 2) {
				yy = y[0] + 1;
				xx = x[0];
			} 
//			if(yy < 0 || xx < 0) { continue; } 여기부터 다시
//			if(yy >= size || xx >= size) { continue; }
//			
//			if(map[yy][xx] != 0 && map[yy][xx] != itemNum) { continue; }
//
//			if(map[yy][xx] == itemNum) {
//				if(snakeSize >= 8) continue;
//				
//				int[] ty = y;
//				int[] tx = x;
//				y = new int[snakeSize + 1];
//				x = new int[snakeSize + 1];
//				for(int i = 0; i < snakeSize; i++) {
//					y[i] = ty[i];
//					x[i] = tx[i];
//				}
//				snakeSize += 1;
//			}
//			for(int i=0; i<snakeSize; i++) {
//				map[y[i]][x[i]] = 0;
//			}
//			
//			for(int i=snakeSize-1; i>0; i--) {
//				y[i] = y[i - 1];
//				x[i] = x[i - 1];
//			}
//			
//			x[0] = xx;
//			y[0] = yy;
//			
//			for(int i=0; i<snakeSize; i++) {
//				map[y[i]][x[i]] = i + 1;
//			}
//			
//		}
//		
//	}
//}
