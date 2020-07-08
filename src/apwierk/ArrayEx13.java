package apwierk;

import java.util.Scanner;

public class ArrayEx13 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] score = null;

		int count = 0;

		while(true) {
			for(int i = 0 ; i<count;i++) {
				System.out.print(score[i] + " ");
			}System.out.println();
			System.out.println("[벡터 컨트롤러]");
			System.out.println("[1]추가");
			System.out.println("[2]삭제(인덱스)");
			System.out.println("[3]삭제(값)");
			System.out.println("[4]삽입");
			System.out.println("[0]종료");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			if(sel == 1) {
				if(count == 0) {
					score = new int[count + 1];
				}else if(count > 0) {
					int [] temp = score;
					score = new int[count + 1];
					for(int i = 0;i<count;i++) {
						score[i] = temp[i];
					}
				}
				System.out.print("입력할 값 : ");
				int value = scan.nextInt();
				int check = 0;
				for(int i = 0;i<count; i++) {
					if(score[i] == value) {
						check = 1;
						break;
					}
				}
				if(check == 0) {
					score[count] = value; 
					count += 1;
				}else if(check == 1) {
					System.out.println("값이 중복됩니다. 다시 입력하십시오.");
					continue;
				}

			}
			else if(sel == 2) {
				System.out.print("삭제할 index : ");
				int idx = scan.nextInt();
				int [] temp = score;
				score = new int[count - 1];
				for(int i = 0;i<idx;i++) {
					score [i] = temp[i];
				}
				for(int i = idx;i<count-1;i++) {
					score[i] = temp[i + 1];
				}
				count -= 1;
			}
			else if(sel == 3) {
				System.out.print("삭제할 value : ");
				int val = scan.nextInt();
				int idx = 0;
				for(int i = 0;i<count;i++) {
					if(val == score[i]) {
						idx = i;
					}
				}
				int [] temp = score;
				score = new int[count - 1];
				for(int i = 0;i<idx;i++) {
					score [i] = temp[i];
				}
				for(int i = idx;i<count-1;i++) {
					score[i] = temp[i + 1];
				}
				count -= 1;
			}
			else if(sel == 4) {
				System.out.print("index : ");
				int idx = scan.nextInt();
				System.out.print("value : ");
				int val = scan.nextInt();
				
				int [] temp = score;
				score = new int[count + 1];
				for(int i = 0;i<idx;i++) {
					score[i] = temp[i];
				}
				score[idx] = val;
				for(int i = idx + 1;i<count + 1;i++) {
					score[i] = temp[i-1];
				}
				count += 1;
			}
			else if(sel == 0) {
				System.out.println("종료");
				break;
			}
		}

	}

}
