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
			System.out.println("[�����ڸ��]");
			System.out.println("[1]ī�װ� ����");
			System.out.println("[2]��  ��  �� ����");
			System.out.println("[3]��üǰ�� ���");

			System.out.print(" : ");
			int sel = scan.nextInt();

			if(sel == 1) {
				System.out.println("�߰��Ͻ� ī�װ��� �Է��Ͻÿ�.");
				String ctg = scan.next();
				items[itemCount][0] = ctg;
				itemCount += 1;

			}else if(sel == 2) {
				int x = 0;
				for(int i = 0;i<itemCount;i++) {
					System.out.print(x +" : "+items[i][0] + "	");
					x += 1;
				}System.out.println();
				System.out.println("�߰��Ͻ� ī�װ��� �Է��Ͻÿ�. (idx)");
				int ctg = scan.nextInt();
				System.out.println("�߰��Ͻ� �������� �Է��Ͻÿ�.");
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
