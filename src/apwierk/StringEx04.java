package apwierk;

import java.util.Scanner;
import java.util.Random;

public class StringEx04 {

	public static void main(String[] args) {
		/*
		 * # 타자연습 게임[1단계]
		 * 1. 문제를 섞는다.(shuffle)
		 * 2. 순서대로 문제를 출제하고, 문제를 다 맞추면 게임 종료
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
			System.out.println("문제 : " + words[i]);
			System.out.print("입력 : ");
			String word = scan.next();
			if(!word.equals(words[i])) {
				i -= 1;
			}
		}

		System.out.println("게임종료");


	}

}
