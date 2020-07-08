package apwierk;


import java.util.Scanner;
public class ArrayEx17 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String[][] items = new String[100][2];
		for(int i = 0;i<items.length;i++) {
			items[i][0] = "";
			items[i][1] = "";

		}
		int itemCount = 0;

		while(true){
			System.out.println("[관리자모드]");
			System.out.println("[1]카테고리 관리");
			System.out.println("[2]아  이  템 관리");
			System.out.println("[3]전체품목 출력");

			System.out.print(" : ");
			int sel = scan.nextInt();

			if(sel == 1) {
				System.out.println("추가하실 카테고리를 입력하시오.");
				String ctg = scan.next();
				items[itemCount][0] = ctg;
				itemCount += 1;

			}else if(sel == 2) {
				int x = 0;
				for(int i = 0;i<itemCount;i++) {
					System.out.print(x +" : "+items[i][0] + "	");
					x += 1;
				}System.out.println();
				System.out.println("추가하실 카테고리를 입력하시오. (idx)");
				int ctg = scan.nextInt();
				System.out.println("추가하실 아이템을 입력하시오.");
				String item = scan.next();
				items[ctg][1] = item;
				items[ctg][1] += "/";
			}else if(sel == 3) {
				for(int i = 0;i<itemCount;i++) {
					for(int j = 0;j<2;j++) {
						System.out.print(items[i][j] + " ");
					}System.out.println();
				}

			}
		}
	}

}
