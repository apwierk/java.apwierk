package apwierk;

import java.util.Scanner;

public class ArrayEx21 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		boolean run = true;
		while(run) {
			String [][] jang = {
					{"Ã¶¼ö", "¼Ò°í±â"},
					{"Ã¶¼ö", "±è¹ä"},
					{"¿µÈñ", "±èÄ¡"},
					{"Ã¶¼ö", "¹Ù³ª³ª"},
					{"Ã¶¼ö", "»õ¿ì±ø"},
					{"¿µÈñ", "¿ÀÂ¡¾î"},
					{"¿µÈñ", "¸À¹ã"}
			};
			System.out.println("»èÁ¦ÇÒ ÀÌ¸§ : ");
			String name = scan.next();
			System.out.println("»èÁ¦ÇÒ ¹øÈ£ : ");
			int num = scan.nextInt();

			int count = 0;
			String[] temp;
			for(int i = 0;i<jang.length;i++) {
				if(name.equals(jang[i][0])) {
					count += 1;
				}
			}
			int j = 0;
			temp = new String[count];
			for(int i = 0;i<jang.length;i++) {
				if(name.equals(jang[i][0])) {
					temp[j] = jang[i][1];
					j += 1;
				}
			}
			
			String idx = temp[num];
			
			for(int i = 0;i<jang.length;i++) {
				if(idx.equals(jang[i][1])) {
					jang[i][1] = "";
				}
			}
			for(int i = 0;i<jang.length;i++) {
				for(int k = 0;k<jang[i].length;k++) {
					System.out.print(jang[i][k] + " ");
				}System.out.println();
			}

		}
	}
}
