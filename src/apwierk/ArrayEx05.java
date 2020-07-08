package apwierk;

import java.util.Random;

public class ArrayEx05 {

	public static void main(String[] args) {
		Random ran = new Random();
		int [] arr = new int[5];

		for(int i= 0;i<arr.length;i++) {
			arr[i] = ran.nextInt(5)+1;
			for(int j= 0;j<i;j++) {
				if(arr[i] == arr[j]) {
					i -= 1;
				}
			}
		}
		for(int i= 0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}

	}
}
