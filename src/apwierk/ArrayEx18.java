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

		String[] items = {"���", "�ٳ���", "����"};

		int log = -1;

		while(true) {

			System.out.println("[MEGA MART]");
			System.out.println("[1]�� �� ��");
			System.out.println("[2]�α׾ƿ�");
			System.out.println("[3]��     ��");
			System.out.println("[4]��ٱ���");
			System.out.println("[0]��     ��");

			System.out.print("�޴� ���� : ");
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
							System.out.println(ids[i] + "�� �ȳ��ϼ���.");
							check = 0;
							break;
						}else {
							check = 1;
						}
					}
					if(check ==1) {
						System.out.println("id or pw Ȯ�ο��");
					}
				}else {
					System.out.println("�α׾ƿ� ���¿��� �̿밡��");
					break;
				}
			}
			else if(sel == 2) {
				if(log == -1) {
					System.out.println("�α��� ���¿��� �̿밡��");
					break;
				}else {
					log = -1;
					System.out.println("�α׾ƿ� �Ϸ�.");
				}
			}
			else if(sel == 3) {
				if(log != -1) {
					System.out.println("[����]");
					System.out.println("1)��� 2)�ٳ��� 3)����");
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
					System.out.println("�α��� �� �̿밡��");
					continue;
				}
			}
			else if(sel == 4) {
				if(log != -1) {
					for(int i = 0;i<count;i++) {
						if(jang[i][1] == 1) {
							System.out.println(ids[jang[i][0]] + "ȸ�� �������");
						}else if (jang[i][1] == 2) {
							System.out.println(ids[jang[i][0]] + "ȸ�� �ٳ�������");
						}else if (jang[i][1] == 3) {
							System.out.println(ids[jang[i][0]] + "ȸ�� ���ⱸ��");
						}
						System.out.println();
					}
				}else {
					System.out.println("�α��� �� �̿밡��");
					continue;
				}
			}
			else if(sel == 0) {
				System.out.println("���α׷� ����");
				break;
			}

		}
	}
}