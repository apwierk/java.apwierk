package apwierk;

import java.util.Scanner;
import java.util.Random;

public class StringEx04 {

	public static void main(String[] args) {
		/*
		 * # Ÿ�ڿ��� ����[1�ܰ�]
		 * 1. ������ ���´�.(shuffle)
		 * 2. ������� ������ �����ϰ�, ������ �� ���߸� ���� ����
		 */

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		String [] words = {"java", "mysql", "jsp", "spring"};
		for(int i = 0 ; i<100;i++) {
			int num = ran.nextInt(words.length-1);
			String temp = words[num];
			words[num] = words[0];
			words[0] = temp;
		}

		for(int i = 0 ; i< words.length;i++) {
			System.out.println("���� : " + words[i]);
			System.out.print("�Է� : ");
			String word = scan.next();
			if(!word.equals(words[i])) {
				i -= 1;
			}
		}

		System.out.println("��������");


	}

}
