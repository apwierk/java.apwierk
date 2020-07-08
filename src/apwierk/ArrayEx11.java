package apwierk;

public class ArrayEx11 {

	public static void main(String[] args) {
		int [] score = {10, 50, 30, 40, 80, 7};
		int max = 0;
		for(int i = 0;i<score.length;i++) {
			for(int j = i;j<score.length;j++) {
				if(score[i] < score[j]) {
					int temp = score[i];
					score[i] = score[j];
					score[j] = temp;
				}
			}
		}
		for(int i = 0;i<score.length;i++) {
			System.out.println(score[i]);
		}
	}

}
