package day0917_01;

import java.util.Random;

public class Horse {

	public static void main(String[] args) {

		int horse[][] = new int[5][20];
		Random ran = new Random();
		int rank[] = new int[5];
		int count = 1;

		for(int i = 0 ; i < horse.length; i++) {
			horse[i][0] = i + 1;
		}

		boolean run = true;
		while(run) {
			for(int i = 0 ; i < horse.length; i++) {
				for(int j = 0; j < horse[i].length; j++) {
					System.out.print(horse[i][j] + " ");
				}System.out.println();
			}System.out.println();
			System.out.println();

			//			말 이동

			for(int i = 0 ; i < horse.length; i++) {
				int where = 0;
				int num = ran.nextInt(3)+1;

				for(int j = 0; j < horse[i].length; j++) {
					if(horse[i][j] != 0) {
						where = j;
					}
				}
				if(where == 19) {
					continue;
				}else if(where + num >= 19) {
					horse[i][where] = 0;
					horse[i][19] = i + 1;
					rank[i] = count;
					count += 1;
				}else if(where + num < 19) {
					horse[i][where] = 0;
					horse[i][where + num] = i + 1;
				}


			}
			int check = 0;
			for(int i = 0 ; i < horse.length; i++) {
				if(rank[i] != 0) {
					check += 1;
				}
			}
			if(check == 5) {
				System.out.println("게임종료");
				System.out.println("순위 발표");
				for(int i = 0 ; i < horse.length; i++) {
					System.out.println(i + 1 + "등 : " + rank[i]);
				}
				break;
			}


			//			순위


			try {
				Thread.sleep(500);
			}catch(Exception e) {

			}
		}
	}
}
