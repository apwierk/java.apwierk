package apwierk;

import java.util.Random;

class RanNum{
	int num;
}

public class ClassArray02 {

	public static void main(String[] args) {
		Random ran = new Random();

		RanNum[] arr = new RanNum[5];
		for(int i = 0;i<arr.length;i++) {
			arr[i] = new RanNum();
		}
		arr[0].num = ran.nextInt(5)+1;
		for(int i = 0;i<arr.length;i++) {
			int num1 = ran.nextInt(5)+1;
			int check = 1;
			for(int j = 0;j<i;j++) {
				if(arr[j].num == num1) {
					check = -1;
				}
			}
			if(check == 1) {
				arr[i].num = num1;
			}else {
				i -= 1;
			}
		}
		for(int i = 0;i<arr.length;i++) {
			System.out.println(arr[i].num);

		}
	}

}
