package apwierk;

import java.util.Scanner;
import java.util.Random;

public class StringEx05 {

	public static void main(String[] args) {
		 /* # 타자연습 게임[2단계]
				 * 1. 문제를 섞는다.(shuffle)
				 * 2. 순서대로 문제를 출제하고, 문제를 다 맞추면 게임 종료
				 * 3. 단 문제를 출제할 때, 단어의 랜덤한 위치 한 곳만 *로 출력
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
			System.out.print("문제 : ");
			for(int j = 0 ; j < size;j++) {
				if(j == num) {
					System.out.print("*");
				}else {
					System.out.print(words[i].charAt(j));
				}
			}System.out.println();
			System.out.print("입력 : ");
			String word = scan.next();
			if(!word.equals(words[i])) {
				i -= 1;
			}
		}

		System.out.println("게임 종료");

	}

}
