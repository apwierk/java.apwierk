package apwierk;

import java.util.Scanner;

public class ArrayEx14 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int [][] arr = new int[3][3];
		
		int k = 1;
		for(int i = 0;i<3;i++) {
			for(int j = 0;j<3;j++) {
				arr[i][j] = 10 * k;
				k += 1;
				System.out.print(arr[i][j] + "\t");
				
			}
			System.out.println();
			System.out.println();
			System.out.println();
		}
//		ans 1
		System.out.println("idx1 : ");
		int idx1 = scan.nextInt();
		System.out.println("idx2 : ");
		int idx2 = scan.nextInt();
		System.out.println(arr[idx1][idx2]);

		
//		ans2
		System.out.println("value : ");
		int val = scan.nextInt();
		for(int i = 0;i<3;i++) {
			for(int j = 0;j<3;j++) {
				if(val == arr[i][j]) {
					idx1 = i;
					idx2 = j;
				}
			}
		}
		System.out.println("index1 : " + idx1);
		System.out.println("index2 : " + idx2);
		
		
//		ans3
		int max = 0;
		int maxIdx1 = 0;
		int maxIdx2 = 0;
		for(int i = 0;i<3;i++) {
			for(int j = 0;j<3;j++) {
				if(max < arr[i][j]) {
					max = arr[i][j];
					maxIdx1 = i;
					maxIdx2 = j;
				}
			}
		}
		System.out.println("index1 : " + maxIdx1);
		System.out.println("index2 : " + maxIdx2);
		
		
//		ans4
		System.out.print("Value1 : ");
		int val1 = scan.nextInt();
		System.out.print("Value2 : ");
		int val2 = scan.nextInt();
		
		int idx11 = 0;
		int idx12 = 0;
		for(int i = 0;i<3;i++) {
			for(int j = 0;j<3;j++) {
				if(val1 == arr[i][j]) {
					idx11 = i;
					idx12 = j;
				}
			}
		}
		int idx21 = 0;
		int idx22 = 0;
		for(int i = 0;i<3;i++) {
			for(int j = 0;j<3;j++) {
				if(val2 == arr[i][j]) {
					idx21 = i;
					idx22 = j;
				}
			}
		}
		
		int temp = arr[idx11][idx12];
		arr[idx11][idx12] = arr[idx21][idx22];
		arr[idx21][idx22] = temp;
		for(int i = 0;i<3;i++) {
			for(int j = 0;j<3;j++) {
				System.out.print(arr[i][j] + "\t");
				
			}
			System.out.println();
			System.out.println();
			System.out.println();
		}
	}
}
