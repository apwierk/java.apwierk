package apwierk;

import java.util.Scanner;

public class ArrayEx01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = {11, 87, 42, 100, 24};
		while(true) {
			int max = 0;
			int maxIdx = 0;
			System.out.println("�ִ밪�� �Է��Ͻÿ�.");
			for(int i = 0;i<arr.length;i++) {
				System.out.print(arr[i] + " ");
			}
			int num = scan.nextInt();
			for(int i = 0;i<arr.length;i++) {
				if(max<arr[i]) {
					max = arr[i];
					maxIdx = i;
				}
			}
			if(max == num) {
				arr[maxIdx] = 0;
			}else {
				System.out.println("�ִ밪�� �ƴմϴ�.");
				continue;
			}
			int cnt = 0;
			for(int i = 0;i<arr.length;i++) {
				if(arr[i] == 0) {
					cnt += 1;
				}
			}
			if(cnt == 5) {
				System.out.println("����");
				break;
			}
		}
	}

}
