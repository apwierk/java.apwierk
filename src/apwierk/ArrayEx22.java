package apwierk;

public class ArrayEx22 {

	public static void main(String[] args) {
		int jangCount = 5;
		String[][] jang = {
			{"Ã¶¼ö", "±è¹ä"},
			{"¿µÈñ", "°¨"},
			{"Ã¶¼ö", "»ç°ú"},
			{"¿µÈñ", "»ç°ú"},
			{"¿µÈñ", "±è¹ä"}
		};
		for(int i = 0;i<jang.length;i++) {
			String maxName = jang[i][0];
			int maxIdx = i;
			for(int j = i;j<jang.length;j++) {
				if(maxName.compareTo(jang[j][0]) > 0) {
					maxName = jang[j][0];
					maxIdx = j;
				}
			}
			String[] temp = jang[i];
			jang[i] = jang[maxIdx];
			jang[maxIdx] = temp;
		}
		for(int i=0; i<jang.length; i++) {
			System.out.println(jang[i][0] + " : " + jang[i][1]);
		}
		for(int i = 0;i<jang.length;i++) {
			String maxName = jang[i][1];
			int maxIdx = i;
			for(int j = i;j<jang.length;j++) {
				if(jang[i][0].equals(jang[j][0]))
				if(maxName.compareTo(jang[j][1]) > 0) {
					maxName = jang[j][1];
					maxIdx = j;
				}
			}
			String[] temp = jang[i];
			jang[i] = jang[maxIdx];
			jang[maxIdx] = temp;
		}
		
		for(int i=0; i<jang.length; i++) {
			System.out.println(jang[i][0] + " : " + jang[i][1]);
		}
		
	}
}
