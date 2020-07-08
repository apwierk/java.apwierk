package apwierk;

import java.util.Random;
import java.util.Scanner;

public class ArrayEx02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		int[] arr = new int[9];
		for(int i = 0;i<arr.length;i++) {
			arr[i] = i+1;
		}
		int x = 0;
		while(x < 1000) {
			int temp = 0;
			int num = ran.nextInt(9);
			temp = arr[0];
			arr[0] = arr[num];
			arr[num] = temp;
			x += 1;
		}
		
		int min = 1;
		while(true) {
			for(int i = 0;i<arr.length;i++) {
				System.out.print(arr[i] + "\t");
				if(i%3 == 2) {
					System.out.println();
					System.out.println();
				}
			}
			System.out.println("1-9까지 순서대로 입력하시오.");
			System.out.println("index : ");
			int index = scan.nextInt();

			if(min == arr[index]) {
				arr[index] = 0;
				min += 1;
			}else {
				System.out.println("X");
				continue;
			}
			int cnt = 0;
			for(int i = 0;i<arr.length;i++) {
				if(arr[i] == 0) {
					cnt += 1;
				}
			}
			if(cnt == 9) {
				System.out.println("종료");
				break;
			}
		}

	}

}
