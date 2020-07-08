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

		String menu = "=== �ް�IT ATM ===\n";
		menu += "1.ȸ������\n2.ȸ��Ż��\n3.�α���\n4.�α׾ƿ�\n";
		menu += "5.�Ա�\n6.��ü\n7.�ܾ���ȸ\n0.����";

		while(true) {

			System.out.println(menu);

			int sel = scan.nextInt();

			if(sel == 1) {
				if(log == -1) {
					System.out.print("ȸ������ id�� �Է��Ͻÿ� : ");
					int id = scan.nextInt();
					int check = 0;
					for(int i = 0 ;i<arId.length;i++) {
						if(arId[i] == id) {
							check = 1;
						}
					}
					if(check == 0) {
						arId[count] = id;
						System.out.print("pw�� �Է��Ͻÿ� : ");
						int pw = scan.nextInt();
						arPw[count] = pw;
						count += 1;
						arMoney[count] += 1000;
						System.out.println(id + "�� ȯ���մϴ�.");
					}else if(check == 1) {
						System.out.println("�ߺ��Ǵ� id�Դϴ�.");
					}
				}else {
					System.out.println("�α׾ƿ� �� �̿밡���մϴ�.");
					continue;
				}
			}
			else if(sel == 2) {
				if(log == -1) {
					System.out.println("�α��� �Ŀ� �̿밡���մϴ�.");
					continue;
				}else {
					System.out.print("Ż���� id�� �Է��Ͻÿ� : ");
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
					System.out.println("Ż�� �Ϸ�Ǿ����ϴ�.");
				}
			}
			else if(sel == 3) {
				if(log != -1) {
					System.out.println("�α׾ƿ� �Ŀ� �̿밡���մϴ�.");
					continue;
				}else {
					System.out.print("�α��� id�� �Է��Ͻÿ� : ");
					int id = scan.nextInt();
					System.out.print("�α��� pw�� �Է��Ͻÿ� : ");
					int pw = scan.nextInt();
					int check = 0;
					for(int i =0 ;i<arId.length;i++) {
						if(arId[i] == id && arPw[i] == pw) {
							log = i;
							System.out.println(arId[log] + "�� �ȳ��ϼ���.");
							check = 0;
							break;
						}else {
							check = 1;
						}
					}if(check == 1) {
						System.out.println("id or pw�� Ȯ�����ּ���.");
					}
				}
			}
			else if(sel == 4) {
				if(log == -1) {
					System.out.println("�α��� �Ŀ� �̿밡���մϴ�.");
					continue;
				}else {
					log = -1;
					System.out.println("�α׾ƿ� �Ϸ�Ǿ����ϴ�.");
				}
			}
			else if(sel == 5) {
				if(log == -1) {
					System.out.println("�α��� �Ŀ� �̿밡���մϴ�.");
					continue;
				}else {
					System.out.print("�Ա��Ͻ� ���� �Է��Ͻÿ� : ");
					int money = scan.nextInt();
					arMoney[log] += money;
					System.out.println("�Ա� �� �ܾ� : " + arMoney[log]);
				}
			}
			else if(sel == 6) {
				if(log == -1) {
					System.out.println("�α��� �Ŀ� �̿밡���մϴ�.");
					continue;
				}else {
					System.out.print("��ü�� ���¸� �Է��Ͻÿ� : ");
					int id = scan.nextInt();
					System.out.print("��ü�� �ݾ� �Է��Ͻÿ� : ");
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
						System.out.println("id�� Ȯ���Ͻʽÿ�.");
						continue;
					}

				}
			}
			else if(sel == 7) {
				if(log == -1) {
					System.out.println("�α��� �Ŀ� �̿밡���մϴ�.");
					continue;
				}else {
					System.out.println(arId[log] + "���� �ܾ� :" + arMoney[log]);
				}
			}
			else if(sel == 0) {
				break;
			}
		}

	}
}
