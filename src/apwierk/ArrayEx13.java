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
			System.out.println("[���� ��Ʈ�ѷ�]");
			System.out.println("[1]�߰�");
			System.out.println("[2]����(�ε���)");
			System.out.println("[3]����(��)");
			System.out.println("[4]����");
			System.out.println("[0]����");

			System.out.print("�޴� ���� : ");
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
				System.out.print("�Է��� �� : ");
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
					System.out.println("���� �ߺ��˴ϴ�. �ٽ� �Է��Ͻʽÿ�.");
					continue;
				}

			}
			else if(sel == 2) {
				System.out.print("������ index : ");
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
				System.out.print("������ value : ");
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
				System.out.println("����");
				break;
			}
		}

	}

}
