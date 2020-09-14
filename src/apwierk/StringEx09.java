package apwierk;

import java.util.Scanner;

public class StringEx09 {

	public static void main(String[] args) {
		/*
		 * # 단어 교체하기(replace)
		 * 1. text변수 문장 속에서 변경하고 싶은 단어를 입력받아,
		 * 2. 교체해주는 기능을 구현한다.
		 * 예)
		 * 		Life is too short.
		 * 		변경하고 싶은 단어입력 : Life
		 * 		바꿀 단어입력 : Time
		 * 
		 * 		Time is too short.
		 */
		Scanner scan = new Scanner(System.in);

		String text = "Life is too short.";
		System.out.println(text);

		System.out.print("변경하고 싶은 단어를 입력하세요 : ");
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
			System.out.println("바꿀 단어를 입력하시오.");
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
			System.out.println("입력하신 단어가 문장에 없습니다.");
		}
	}

}
