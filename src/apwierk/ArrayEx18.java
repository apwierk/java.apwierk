package apwierk;

import java.util.Scanner;

public class ArrayEx18 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String[] ids = {"qwer", "javaking", "abcd"};
		String[] pws = {"1111",     "2222", "3333"};

		int MAX_SIZE = 100;
		int[][] jang = new int[MAX_SIZE][2];

		int count = 0;

		String[] items = {"사과", "바나나", "딸기"};

		int log = -1;

		while(true) {

			System.out.println("[MEGA MART]");
			System.out.println("[1]로 그 인");
			System.out.println("[2]로그아웃");
			System.out.println("[3]쇼     핑");
			System.out.println("[4]장바구니");
			System.out.println("[0]종     료");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			if(sel == 1) {
				if(log == -1) {
					System.out.println("id : ");
					String id = scan.next();
					System.out.println("pw : ");
					String pw = scan.next();
					int check = 0;
					for(int i = 0;i<ids.length;i++) {
						if(id.equals(ids[i]) && pw.equals(pws[i])) {
							log = i;
							System.out.println(ids[i] + "님 안녕하세요.");
							check = 0;
							break;
						}else {
							check = 1;
						}
					}
					if(check ==1) {
						System.out.println("id or pw 확인요망");
					}
				}else {
					System.out.println("로그아웃 상태에서 이용가능");
					break;
				}
			}
			else if(sel == 2) {
				if(log == -1) {
					System.out.println("로그인 상태에서 이용가능");
					break;
				}else {
					log = -1;
					System.out.println("로그아웃 완료.");
				}
			}
			else if(sel == 3) {
				if(log != -1) {
					System.out.println("[쇼핑]");
					System.out.println("1)사과 2)바나나 3)딸기");
					int num = scan.nextInt();
					if(num == 1) {
						jang[count][0] = log;
						jang[count][1] = 1;
						count += 1;
					}else if(num == 2) {
						jang[count][0] = log;
						jang[count][1] = 2;
						count += 1;
					}else if(num == 3) {
						jang[count][0] = log;
						jang[count][1] = 3;
						count += 1;
					}
				}else {
					System.out.println("로그인 후 이용가능");
					continue;
				}
			}
			else if(sel == 4) {
				if(log != -1) {
					for(int i = 0;i<count;i++) {
						if(jang[i][1] == 1) {
							System.out.println(ids[jang[i][0]] + "회원 사과구매");
						}else if (jang[i][1] == 2) {
							System.out.println(ids[jang[i][0]] + "회원 바나나구매");
						}else if (jang[i][1] == 3) {
							System.out.println(ids[jang[i][0]] + "회원 딸기구매");
						}
						System.out.println();
					}
				}else {
					System.out.println("로그인 후 이용가능");
					continue;
				}
			}
			else if(sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}

		}
	}
}