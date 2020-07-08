package apwierk;

import java.util.Scanner;

public class ArrayEx04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int exit = 10;

		int [] game = {11, 15, 10, 14, 12, 13};

		boolean run = true;
		while(run) {
			System.out.println("변수 값 : " + exit);
			for(int i = 0;i<game.length;i++) {
				System.out.print(game[i] + " ");
			}System.out.println();
			System.out.print("index : ");
			int idx = scan.nextInt();
			if(exit == game[idx]) {
				exit += 1;
			}else {
				System.out.println("X");
				continue;
			}
			if(exit == 16) {
				System.out.println("게임 종료");
				break;
			}
		}
	}

}
