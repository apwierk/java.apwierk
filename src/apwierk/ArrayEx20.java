package apwierk;

public class ArrayEx20 {

	public static void main(String[] args) {
		int[] test1 = {1,2,3,2,1};
		int[] test2 = {1,3,4,4,2};
		int[] test3 = {1,1,1,2,1};

		int[] temp = new int[5];
		int count = 0;

		for(int i = 0;i<test1.length;i++) {
			temp[count] = test1[i];
			int check = 0;
			for(int n = 0; n < 5; n++) {
				if(i != n  && temp[count] == test1[n]) {
					check = 1;
				}
			}
			if(check == 1) {
				count += 1;
			}			

		}

		for(int i = 0; i < count; i++) {
			System.out.print(temp[i]);
		}
	}
}

