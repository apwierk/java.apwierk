package apwierk;

import java.util.Scanner;

class Ticket{
	boolean check;
	void showData() {
		if(check == true) {
			System.out.print("��");
		}else {
			System.out.print("��");
		}
	}
}

public class ClassArray03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Ticket [] tickets = new Ticket[8];
		for(int i = 0;i<tickets.length;i++) {
			tickets[i] = new Ticket();
		}

		while(true) {
			for(int i = 0;i<tickets.length;i++) {
				tickets[i].showData();
			}System.out.println();
			System.out.println("�����Ͻ� �ڸ��� �Է��Ͻÿ�.");
			int idx = scan.nextInt();
			if(tickets[idx].check == false) {
				tickets[idx].check = true;
			}else if(tickets[idx].check == true) {
				System.out.println("�̹� ���ŵ� �ڸ��Դϴ�.");
			}
			int cnt = 0;
			for(int i = 0;i<tickets.length;i++) {
				if(tickets[i].check == true) {
					cnt += 1;
				}
			}
			if(cnt == 8) {
				System.out.println("���Ű� ����Ǿ����ϴ�.");
				break;
			}

		}



	}
}