package apwierk;

import java.util.Scanner;

public class StringEx08 {

	public static void main(String[] args) {
		/*
		 * # �ܾ� �˻�
		 * 1. �ܾ �Է¹޾� text���� ���� �ӿ� �ش� �ܾ �ִ��� �˻��Ѵ�.
		 * 2. �ܾ �����ϸ� true
		 *    �ܾ ������ false�� ����Ѵ�.
		 */

		Scanner scan = new Scanner(System.in);

		String text = "Life is too short";
		System.out.println(text);

		System.out.println("�˻��� �ܾ �Է��ϼ���.");
		String word = scan.next();

		// text���ڿ��� ���� ��ŭ �迭�� ����
		char [] arr = new char[text.length()]; 
		// ����1���� �迭�� ����
		for(int i = 0 ; i < text.length(); i++) {
			arr[i] = text.charAt(i);
		}
		//size = �˻��� �ܾ� ����
		int size = word.length();
		// üũ
		int check = -1;
		// �迭�� ���ڿ� �˻��� �ܾ��� ���ڰ� ���ٸ� ī��Ʈ +1 �ϰ� ī��Ʈ�� �˻��� �ܾ� ���̰� ���ٸ� üũ
		for(int i = 0 ; i < text.length() - size + 1; i++) {
			int count = 0;
			for(int j = 0; j < size; j++) {
				if(arr[i + j] == word.charAt(j)) {
					count += 1;
				}
			}
			if(count == size) {
				check = 0;
			}
		}
		//üũ�� �ƴٸ� true��� �ƴϸ� false���
		if(check == 0) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}


	}
}
