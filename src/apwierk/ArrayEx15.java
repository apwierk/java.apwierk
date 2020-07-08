package apwierk;

import java.util.Scanner;

public class ArrayEx15 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int [][] apt = {
				{101, 102, 103},
				{201, 202, 203},
				{301, 302, 303},
		};
		int [][] pay = {
				{1000, 2100, 1300},
				{4100, 2000, 1000},
				{3000, 1600, 800},
		};
		
//		ans1
		int [] temp = new int[apt.length];
		for(int i = 0;i<apt.length;i++) {
			for(int j = 0;j<apt[i].length;j++) {
				temp[i] += pay[i][j];
			}
		}
		for(int i = 0;i<temp.length;i++) {
			System.out.println(temp[i]);
		}
		
//		ans2
		System.out.print("호 입력 : ");
		int ho = scan.nextInt();
		int idx1 = 0;
		int idx2 = 0;
		for(int i = 0;i<apt.length;i++) {
			for(int j = 0;j<apt[i].length;j++) {
				if(ho == apt[i][j]) {
					idx1 = i;
					idx2 = j;
				}
			}
		}
		System.out.println("관리비 : " + pay[idx1][idx2]);
		
		
//		ans3
		int max = 0;
		int maxIdx1 = 0;
		int maxIdx2 = 0;
		int min = 10000;
		int minIdx1 = 0;
		int minIdx2 = 0;
		for(int i = 0;i<apt.length;i++) {
			for(int j = 0;j<apt[i].length;j++) {
				if(max < pay[i][j]) {
					max = pay[i][j];
					maxIdx1 = i;
					maxIdx2 = j;
				}
				if(min > pay[i][j]) {
					min = pay[i][j];
					minIdx1 = i;
					minIdx2 = j;
				}
			}
		}
		System.out.println("많이 나온 집(" + apt[maxIdx1][maxIdx2] + ") 적게 나온 집(" + apt[minIdx1][minIdx2] + ")");
	}
}
