package apwierk;

import java.util.Scanner;

public class StringEx03 {

	public static void main(String[] args) {
		//		�����ձ� ����

		Scanner scan = new Scanner(System.in);

		String start = "������";

		boolean run = true;

		while(run) {

			System.out.println("���þ� : " + start);
			String word = scan.next();

			if(word.charAt(0) == (start.charAt(start.length()-1))) {
				start = word;	
			}else {
				System.out.println("�ٽ� �Է��Ͻʽÿ�.");
				continue;
			}

		}
	}

}
