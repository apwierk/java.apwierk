package apwierk;

import java.util.Scanner;

public class StringEx06 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		while(true) {
		System.out.print("�Է� : ");
		String text = scan.next();
		int[] num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		
		int size = text.length();
		int cnt = 0;
		for(int j = 0; j < num.length;j++) {
			for(int i = 0 ;i < size;i++) {
				if(text.charAt(i) == num[j]) {
					cnt += 1;
				}
			}
		}
		
		if(cnt == size) {
			System.out.println("���ڸ� �ֽ��ϴ�.");
		}else if(cnt < size && cnt > 0) {
			System.out.println("���ڿ� ���� �� �� �ֽ��ϴ�.");
		}else if(cnt == 0) {
			System.out.println("���ڸ� �ֽ��ϴ�.");
		}
		
		
		}

	}

}
