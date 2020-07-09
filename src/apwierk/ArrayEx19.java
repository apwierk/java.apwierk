package apwierk;

import java.util.Random;

public class ArrayEx19 {

	public static void main(String[] args) {
		Random ran = new Random();

		int[][] lottoSet = new int[5][7];

		int check = 0;

		for(int i = 0;i<lottoSet.length;i++) {
			for(int j = 0;j<lottoSet[i].length;j++) {
				int num = ran.nextInt(2)+2;
				lottoSet[i][j] = num;
			}
			for(int j = 0;j<lottoSet[i].length;j++) {
				if(check == 1) {
					if(j < 5) {
						if(lottoSet[i][j] == 3) {
							if(lottoSet[i][j+1] == 3) {
								lottoSet[i][j+2] = 2;
							}
						}
					}
				}
			}

			for(int j = 0;j<lottoSet[i].length;j++) {
				if(j < 5) {
					if(lottoSet[i][j] == 3) {
						if(lottoSet[i][j + 1] == 3) {
							if(lottoSet[i][j + 2] == 3) {
								check = 1;
							}
						}
					}
				}
			}
		}
		for(int i = 0;i<lottoSet.length;i++) {
			for(int j = 0;j<lottoSet[i].length;j++) {
				System.out.print(lottoSet[i][j] + " " + check);
			}System.out.println();
		}


	}

}
