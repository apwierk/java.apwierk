package apwierk;

import java.util.Scanner;

public class ArrayEx08 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int MAX = 5;

		int[] arId = new int[MAX];
		int[] arPw = new int[MAX];
		int[] arMoney = new int[MAX];

		int count = 0;
		int log = -1;

		String menu = "=== 메가IT ATM ===\n";
		menu += "1.회원가입\n2.회원탈퇴\n3.로그인\n4.로그아웃\n";
		menu += "5.입금\n6.이체\n7.잔액조회\n0.종료";

		while(true) {

			System.out.println(menu);

			int sel = scan.nextInt();

			if(sel == 1) {
				if(log == -1) {
					System.out.print("회원가입 id를 입력하시오 : ");
					int id = scan.nextInt();
					int check = 0;
					for(int i = 0 ;i<arId.length;i++) {
						if(arId[i] == id) {
							check = 1;
						}
					}
					if(check == 0) {
						arId[count] = id;
						System.out.print("pw를 입력하시오 : ");
						int pw = scan.nextInt();
						arPw[count] = pw;
						count += 1;
						arMoney[count] += 1000;
						System.out.println(id + "님 환영합니다.");
					}else if(check == 1) {
						System.out.println("중복되는 id입니다.");
					}
				}else {
					System.out.println("로그아웃 후 이용가능합니다.");
					continue;
				}
			}
			else if(sel == 2) {
				if(log == -1) {
					System.out.println("로그인 후에 이용가능합니다.");
					continue;
				}else {
					System.out.print("탈퇴할 id를 입력하시오 : ");
					int id = scan.nextInt();
					int idx = 0;
					for(int i = 0;i<arId.length;i++) {
						if(arId[i] == id) {
							idx = i;
						}
					}
					arId[idx] = 0;
					arPw[idx] = 0;
					arMoney[idx] = 0;
					count -= 1;
					System.out.println("탈퇴 완료되었습니다.");
				}
			}
			else if(sel == 3) {
				if(log != -1) {
					System.out.println("로그아웃 후에 이용가능합니다.");
					continue;
				}else {
					System.out.print("로그인 id를 입력하시오 : ");
					int id = scan.nextInt();
					System.out.print("로그인 pw를 입력하시오 : ");
					int pw = scan.nextInt();
					int check = 0;
					for(int i =0 ;i<arId.length;i++) {
						if(arId[i] == id && arPw[i] == pw) {
							log = i;
							System.out.println(arId[log] + "님 안녕하세요.");
							check = 0;
							break;
						}else {
							check = 1;
						}
					}if(check == 1) {
						System.out.println("id or pw를 확인해주세요.");
					}
				}
			}
			else if(sel == 4) {
				if(log == -1) {
					System.out.println("로그인 후에 이용가능합니다.");
					continue;
				}else {
					log = -1;
					System.out.println("로그아웃 완료되었습니다.");
				}
			}
			else if(sel == 5) {
				if(log == -1) {
					System.out.println("로그인 후에 이용가능합니다.");
					continue;
				}else {
					System.out.print("입금하실 돈을 입력하시오 : ");
					int money = scan.nextInt();
					arMoney[log] += money;
					System.out.println("입금 후 잔액 : " + arMoney[log]);
				}
			}
			else if(sel == 6) {
				if(log == -1) {
					System.out.println("로그인 후에 이용가능합니다.");
					continue;
				}else {
					System.out.print("이체할 계좌를 입력하시오 : ");
					int id = scan.nextInt();
					System.out.print("이체할 금액 입력하시오 : ");
					int money = scan.nextInt();
					int check = 0;
					for(int i = 0;i<arId.length;i++) {
						if(arId[i] != id) {
							check = 1;
						}else if(arId[i] == id) {
							check = 0;
							break;
						}
					}
					if(check == 0) {
						arId[log] -= money;
						arId[id] += money;
					}else if (check == 1) {
						System.out.println("id를 확인하십시오.");
						continue;
					}

				}
			}
			else if(sel == 7) {
				if(log == -1) {
					System.out.println("로그인 후에 이용가능합니다.");
					continue;
				}else {
					System.out.println(arId[log] + "님의 잔액 :" + arMoney[log]);
				}
			}
			else if(sel == 0) {
				break;
			}
		}

	}
}
