package apwierk;

import java.util.Scanner;

public class ArrayEx03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int [] game = {0, 0, 1, 0, 2, 0, 0, 1, 0};

		boolean run = true;
		while(run) {
			for(int i = 0;i<game.length;i++) {
				System.out.print(game[i] + " ");
			}System.out.println();

			System.out.println("1. �·��̵�");
			System.out.println("2. ����̵�");
			System.out.println("3. (�¿�)�� ����");

			int me = 0;
			for(int i = 0;i<game.length;i++) {
				if(game[i] == 2) {
					me = i;
				}
			}

			int sel = scan.nextInt();

			if(sel == 1) {
				if(me == 0) {
					System.out.println("�̵��Ұ�");
					continue;
				}else if(me > 0 && game[me - 1] == 0){
					game[me] = 0;
					game[me - 1] = 2;
				}
			}else if(sel == 2) {
				if(me == game.length-1) {
					System.out.println("�̵��Ұ�");
					continue;
				}else if(me < game.length - 1 && game[me + 1] == 0){
					game[me] = 0;
					game[me + 1] = 2;
				}
			}else if (sel == 3) {
				game[me+1] = 0;
				game[me-1] = 0;
			}else {
				System.out.println("�ٽ� �Է��Ͻÿ�.");
				continue;
			}
		}
	}
}