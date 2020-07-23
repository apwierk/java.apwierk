package apwierk;

import java.util.Scanner;
import java.util.Random;

public class StringEx05 {

	public static void main(String[] args) {
		 /* # Ÿ�ڿ��� ����[2�ܰ�]
				 * 1. ������ ���´�.(shuffle)
				 * 2. ������� ������ �����ϰ�, ������ �� ���߸� ���� ����
				 * 3. �� ������ ������ ��, �ܾ��� ������ ��ġ �� ���� *�� ���
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
		for(int i = 0 ; i<words.length;i++) {
			int size = words[i].length();
			int num = ran.nextInt(size);
			System.out.print("���� : ");
			for(int j = 0 ; j < size;j++) {
				if(j == num) {
					System.out.print("*");
				}else {
					System.out.print(words[i].charAt(j));
				}
			}System.out.println();
			System.out.print("�Է� : ");
			String word = scan.next();
			if(!word.equals(words[i])) {
				i -= 1;
			}
		}

		System.out.println("���� ����");

	}

}
