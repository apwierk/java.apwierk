package apwierk;

import java.util.Scanner;

public class StringEx08 {

	public static void main(String[] args) {
		/*
		 * # 단어 검색
		 * 1. 단어를 입력받아 text변수 문장 속에 해당 단어가 있는지 검색한다.
		 * 2. 단어가 존재하면 true
		 *    단어가 없으면 false를 출력한다.
		 */

		Scanner scan = new Scanner(System.in);

		String text = "Life is too short";
		System.out.println(text);

		System.out.println("검색할 단어를 입력하세요.");
		String word = scan.next();

		// text문자열의 길이 만큼 배열을 만듦
		char [] arr = new char[text.length()]; 
		// 문자1개씩 배열에 넣음
		for(int i = 0 ; i < text.length(); i++) {
			arr[i] = text.charAt(i);
		}
		//size = 검색된 단어 길이
		int size = word.length();
		// 체크
		int check = -1;
		// 배열의 문자와 검색된 단어의 문자가 같다면 카운트 +1 하고 카운트와 검색된 단어 길이가 같다면 체크
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
		//체크가 됐다면 true출력 아니면 false출력
		if(check == 0) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}


	}
}
