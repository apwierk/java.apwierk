package apwierk;

import java.util.Scanner;
import java.util.Random;

public class ArrayEx07 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		final int SIZE = 9;

		int [] front = new int[SIZE];
		int [] back  = new int[SIZE];

		int cnt = 1;

		for(int i = 0;i<front.length;i++) {
			front[i] = i+1;
		}
		int j = 10;
		for(int i = 0;i<front.length;i++) {
			back[i] = j;
			j += 1;
		}
		int x = 0;
		int x1 = 0;
		while(x < 100) {
			int num = ran.nextInt(9);
			int temp = 0;
			temp = front[num];
			front[num] = front[0];
			front[0] = temp;
			x += 1;
		}
		while(x1 < 100) {
			int num = ran.nextInt(9);
			int temp = 0;
			temp = back[num];
			back[num] = back[0];
			back[0] = temp;
			x1 += 1;
		}
		boolean run = true;
		while(run) {
			for(int i = 0;i<front.length;i++) {
				System.out.print(front[i] + "\t");
				if(i % 3 == 2) {
					System.out.println();
					System.out.println();
				}
			}
			

			System.out.print("index : ");
			int index = scan.nextInt();
			if(cnt < 10) {
				if(cnt == front[index]) {
					front[index] = back[index];
					cnt += 1;
				}else {
					System.out.println("X");
				}
			}else if(cnt >= 10) {
				if(cnt == front[index]) {
					front[index] = 0;
					cnt += 1;
				}
				else {
					System.out.println("X");
				}
			}
			if(cnt == 19) {
				System.out.println("게임종료");
				break;
			}

		}
	}

}
