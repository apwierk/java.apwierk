package apwierk;

import java.util.Scanner;
import java.util.Random;

public class ArrayEx06 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		int [] com = {1, 7, 3};
		int [] me  = new int[3];
		boolean run = true;
		while(run) {
			System.out.println("숫자를 순서대로 입력하시오.");
			for(int i = 0;i<me.length;i++) {
				me[i] = scan.nextInt();
			}
			int s = 0;
			int b = 0;
			for(int i = 0;i<me.length;i++) {
				for(int j = 0;j<me.length;j++) {
					if(i==j) {
						if(com[i] == me[j]) {
							s += 1;
						}
					}else {
						if(com[i] == me[j]) {
							b += 1;
						}
					}
				}
				
			}
			System.out.println("strike : " + s + " ball : " + b);
			if(s == 3) {
				System.out.println("게임 종료");
				break;
			}

		}

	}

}
