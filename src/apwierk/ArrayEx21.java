package apwierk;

import java.util.Scanner;

public class ArrayEx21 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		boolean run = true;
		while(run) {
			String [][] jang = {
					{"ö��", "�Ұ��"},
					{"ö��", "���"},
					{"����", "��ġ"},
					{"ö��", "�ٳ���"},
					{"ö��", "�����"},
					{"����", "��¡��"},
					{"����", "����"}
			};
			System.out.println("������ �̸� : ");
			String name = scan.next();
			System.out.println("������ ��ȣ : ");
			int num = scan.nextInt();

			int count = 0;
			String[] temp;
			for(int i = 0;i<jang.length;i++) {
				if(name.equals(jang[i][0])) {
					count += 1;
				}
			}
			int j = 0;
			temp = new String[count];
			for(int i = 0;i<jang.length;i++) {
				if(name.equals(jang[i][0])) {
					temp[j] = jang[i][1];
					j += 1;
				}
			}
			
			String idx = temp[num];
			
			for(int i = 0;i<jang.length;i++) {
				if(idx.equals(jang[i][1])) {
					jang[i][1] = "";
				}
			}
			for(int i = 0;i<jang.length;i++) {
				for(int k = 0;k<jang[i].length;k++) {
					System.out.print(jang[i][k] + " ");
				}System.out.println();
			}

		}
	}
}
