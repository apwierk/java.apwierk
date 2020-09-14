package apwierk;

import java.util.Scanner;

public class StringEx09 {

	public static void main(String[] args) {
		/*
		 * # �ܾ� ��ü�ϱ�(replace)
		 * 1. text���� ���� �ӿ��� �����ϰ� ���� �ܾ �Է¹޾�,
		 * 2. ��ü���ִ� ����� �����Ѵ�.
		 * ��)
		 * 		Life is too short.
		 * 		�����ϰ� ���� �ܾ��Է� : Life
		 * 		�ٲ� �ܾ��Է� : Time
		 * 
		 * 		Time is too short.
		 */
		Scanner scan = new Scanner(System.in);

		String text = "Life is too short.";
		System.out.println(text);

		System.out.print("�����ϰ� ���� �ܾ �Է��ϼ��� : ");
		String word = scan.nextLine();

		char [] arr = new char[text.length()];
		for(int i = 0 ; i < text.length(); i++) {
			arr[i] = text.charAt(i);
		}
		
		int size = word.length();
		
		int check = -1;
		int num = 0;
		
		for(int i = 0 ; i < text.length() - size + 1; i++) {
			int count = 0;
			for(int j = 0 ; j < size; j++) {
				if(arr[i + j] == word.charAt(j)) {
					count += 1;
				}
			}
			if(count == size) {
				check = 0;
				num = i;
			}
		}
		
		if(check == 0) {
			System.out.println("�ٲ� �ܾ �Է��Ͻÿ�.");
			String word1 = scan.next();
			for(int i = 0; i < size; i++) {
				arr[num + i] = word1.charAt(i);
			}
			String result = "";
			for(int i = 0 ; i < arr.length; i++) {
				result += arr[i];
			}
			System.out.println(result);
		}else {
			System.out.println("�Է��Ͻ� �ܾ ���忡 �����ϴ�.");
		}
	}

}
