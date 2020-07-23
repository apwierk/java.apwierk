package apwierk;

import java.util.Scanner;

public class StringEx06 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		while(true) {
		System.out.print("입력 : ");
		String text = scan.next();
		int[] num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		
		int size = text.length();
		int cnt = 0;
		for(int j = 0; j < num.length;j++) {
			for(int i = 0 ;i < size;i++) {
				if(text.charAt(i) == num[j]) {
					cnt += 1;
				}
			}
		}
		
		if(cnt == size) {
			System.out.println("숫자만 있습니다.");
		}else if(cnt < size && cnt > 0) {
			System.out.println("숫자와 문자 둘 다 있습니다.");
		}else if(cnt == 0) {
			System.out.println("문자만 있습니다.");
		}
		
		
		}

	}

}
