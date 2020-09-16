package apwierk;

import java.util.Scanner;

public class VendingMachine {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[] money   = {50000, 10000, 5000, 1000, 500, 100};
		int[] charges = {    1,     1,    1,    1,   5,  10};

		int tickets = 5;		// 식권 개수
		int price = 3200;		// 식권 가격

		while(true) {

			System.out.println("[1]관리자");
			System.out.println("[2]사용자");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			if(sel == 1) {
				while(true) {
					System.out.println("1)식권충전");
					System.out.println("2)잔돈충전");
					System.out.println("3)뒤로가기");

					System.out.print("메뉴 선택 : ");
					int choice = scan.nextInt();
					if(choice == 1) {
						System.out.println("충전하실 식권의 개수를 입력하시오");
						int num = scan.nextInt();
						tickets += num;
					}
					else if(choice == 2) {
						for(int i = 0 ; i < money.length; i++) {
							System.out.println((i + 1) + ". " + money[i]);
						}
						System.out.println("충전하실 화폐를 선택하시오.");
						int num = scan.nextInt();
						System.out.println("충전하실 화폐의 개수를 입력하시오.");
						int mnum = scan.nextInt();
						charges[num-1] += mnum;
						for(int i = 0 ; i < money.length; i++) {
							System.out.println(money[i] + " : " + charges[i]);
						}
					}
					else if(choice == 3) {
						break;
					}
				}

			}
			else if(sel == 2) {
				while(true) {
					System.out.println("1)구입");
					System.out.println("2)뒤로가기");

					System.out.print("메뉴 선택 : ");
					int choice = scan.nextInt();
					if(choice == 1) {
						System.out.println("구입하실 식권의 개수를 입력하시오.");
						int num = scan.nextInt();
						System.out.println("입금 금액을 입력하시오.");
						int mon = scan.nextInt();
						int pay = mon - num*price;
						int [] count = new int[6];
						if(pay >= 50000) {
							if(pay / 50000 <= charges[0]) {
								count[0] = pay/50000;
								pay -= 50000 * (pay / 50000);
							}else if(pay/50000 > charges[0]) {
								pay -= 50000 * charges[0];
								count[0] = charges[0];
							}
						}
						if(pay >= 10000) {
							if(pay / 10000 <= charges[1]) {
								count[1] = pay/10000;
								pay -= 10000 * (pay / 10000);
							}else if(pay/10000 > charges[1]) {
								pay -= 10000 * charges[1];
								count[1] = charges[1];
							}
						}
						if(pay >= 5000) {
							if(pay / 5000 <= charges[2]) {
								count[2] = pay/5000;
								pay -= 5000 * (pay / 5000);
							}else if(pay/5000 > charges[2]) {
								pay -= 5000 * charges[2];
								count[2] = charges[2];
							}
						}
						if(pay >= 1000) {
							if(pay / 1000 <= charges[3]) {
								count[3] = pay/1000;
								pay -= 1000 * (pay / 1000);
							}else if(pay/1000 > charges[3]) {
								pay -= 1000 * charges[3];
								count[3] = charges[3];
							}
						}
						if(pay >= 500) {
							if(pay / 500 <= charges[4]) {
								count[4] = pay/500;
								pay -= 500 * (pay / 500);
							}else if(pay/500 > charges[4]) {
								pay -= 500 * charges[4];
								count[4] = charges[4];
							}
						}
						if(pay >= 100) {
							if(pay / 100 <= charges[5]) {
								System.out.println(pay);
								count[5] = pay/100;
								pay -= 100 * (pay / 100);
							}else if(pay/100 > charges[5]) {
								pay -= 100 * charges[5];
								count[5] = charges[5];
							}
						}
						
						System.out.println(pay);
						if(pay != 0) {
							System.out.println("잔돈 부족");
						}else {
							System.out.println("잔돈 : ");
							for(int i = 0 ; i < count.length; i++) {
								charges[i] -= count[i];
								System.out.print(money[i] + " : " + count[i] + ", ");
								System.out.println();
							}
						}
						
					}
					else if(choice == 2) {
						break;
					}
				}
			}
		}
	}
}
