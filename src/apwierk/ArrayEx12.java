package apwierk;

public class ArrayEx12 {
	
	public static void main(String[] args) {

		String [] name = {"È«±æµ¿", "±è¿µ", "ÀÚ¹ÙÅ·", "¹Îº´Ã¶", "¸Þ°¡¸Ç"};
		int [] score = {87, 42, 100, 11, 98};

		for(int i = 0;i<score.length;i++) {
			int max = 0;
			int maxIdx = 0;
			for(int j = i;j<score.length;j++) {
				if(max < score[j]) {
					max = score[j];
					maxIdx = j;
				}
			}
			int temp = score[i];
			score[i] = score[maxIdx];
			score[maxIdx] = temp;
			String temp1 = name[i];
			name[i] = name[maxIdx];
			name[maxIdx] = temp1;
		}
		for(int i = 0;i<score.length;i++) {
		System.out.println(name[i]);
		}
	}
}
