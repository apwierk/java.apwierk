package apwierk;

import java.util.Scanner;

public class StringEx03 {

	public static void main(String[] args) {
		//		끝말잇기 게임

		Scanner scan = new Scanner(System.in);

		String start = "자전거";

		boolean run = true;

		while(run) {

			System.out.println("제시어 : " + start);
			String word = scan.next();

			if(word.charAt(0) == (start.charAt(start.length()-1))) {
				start = word;	
			}else {
				System.out.println("다시 입력하십시오.");
				continue;
			}

		}
	}

}
