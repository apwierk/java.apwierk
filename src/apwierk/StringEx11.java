package apwierk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StringEx11 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int size = 5;
		int count = 0;
		int log = -1;

		String[] accs = new String[size];
		String[]  pws = new String[size];
		int[]  moneys = new int[size];

		String fileName = "atm.txt";

		while(true) {

			System.out.println("[MEGA ATM]");
			System.out.println("[1]ȸ������");
			System.out.println("[2]ȸ��Ż��");
			System.out.println("[3]�α���");
			System.out.println("[4]�α׾ƿ�");
			System.out.println("[5]�Ա�");
			System.out.println("[6]���");
			System.out.println("[7]��ü");
			System.out.println("[8]�ܾ���ȸ");
			System.out.println("[9]����");
			System.out.println("[10]�ε�");
			System.out.println("[0]����");

			System.out.print("�޴� ���� : ");
			int sel = scan.nextInt();

			if(sel == 1) {
				if(log == -1) {
					System.out.println("���̵� �Է��Ͻÿ�.");
					String id = scan.next();
					int check = -1;
					for(int i = 0 ; i < count; i++) {
						if(accs[i].equals(id)) {
							check = 1;
						}
					}
					if(check == -1) {
						accs[count] = id;
						System.out.println("��й�ȣ�� �Է��Ͻÿ�.");
						pws[count] = scan.next();
						moneys[count] += 1000;
						count += 1;
					}else if(check == 1){
						System.out.println("�ߺ��� ���̵� �Դϴ�.");
					}
				}
				else {
					System.out.println("�α׾ƿ� ���¿����� �̿밡��");
					continue;
				}
			}
			else if(sel == 2) {
				if(log != -1) {
					for(int i = log ; i < count-1; i++) {
						accs[i] = accs[i + 1];
						pws[i] = pws[i + 1];
						moneys[i] = moneys[i + 1];
					}
					count -= 1;
					log = -1;
					System.out.println("[�޼���]Ż��Ǿ����ϴ�.");
				}
				else {
					System.out.println("�α��� ���¿����� �̿� ����");
					continue;
				}
			}
			else if(sel == 3) {
				if(log != -1) {
					System.out.println("�α׾ƿ� ���¿����� �̿밡��");
					continue;
				}
				else {
					System.out.println("id : ");
					String id = scan.next();
					int check = 0;
					int ididx = 0;
					for(int i = 0 ; i < count-1; i++) {
						if(accs[i].equals(id)) {
							check = 1;
							ididx = i;
						}
					}
					if(check == 1) {
						System.out.println("pw : ");
						String pw = scan.next();
						if(pws[ididx].equals(pw)) {
							log = ididx;
							System.out.println(accs[log] + "�� ȯ���մϴ�.");
						}else {
							System.out.println("��й�ȣ�� Ʋ���ϴ�.");
							continue;
						}
					}else if(check == 0) {
						System.out.println("���̵� Ȯ���Ͻÿ�.");
						continue;
					}

				}
			}
			else if(sel == 4) {
				if(log == -1) {
					System.out.println("�α��� ���¿����� �̿밡��");
					continue;
				}else {
					log = -1;
					System.out.println("�α׾ƿ� �Ϸ�");
				}

			}
			else if(sel == 5) {
				if(log == -1) {
					System.out.println("�α��� ���¿����� �̿밡��");
					continue;
				}else {
					System.out.println("�Ա��Ͻ� �ݾ��� �Է��Ͻÿ�.");
					int money = scan.nextInt();
					moneys[log] += money;
					System.out.println("�Ա� �Ϸ�");
					System.out.println("�ܾ� : " + moneys[log]);
				}
			}
			else if(sel == 6) {
				if(log == -1) {
					System.out.println("�α��� ���¿����� �̿밡��");
					continue;
				}else {
					System.out.println("����Ͻ� �ݾ��� �Է��Ͻÿ�.");
					int money = scan.nextInt();
					if(money <= moneys[log]) {
						moneys[log] -= money;
						System.out.println("��� �Ϸ�");
						System.out.println("�ܾ� : " + moneys[log]);
					}else if(money > moneys[log]) {
						System.out.println("�ܾ׺���");
						continue;
					}
				}
			}
			else if(sel == 7) {
				if(log == -1) {
					System.out.println("�α��� ���¿����� �̿밡��");
					continue;
				}else {
					System.out.println("�Ա��Ͻ� ���¸� �Է��Ͻÿ�.");
					String id = scan.next();
					for(int i = 0; i < count; i++) {
						if(accs[i].equals(id)) {
							System.out.println("�Ա��Ͻ� �ݾ��� �Է��Ͻÿ�.");
							int money = scan.nextInt();
							if(moneys[log] >= money) {
								moneys[i] += money;
								moneys[log] -= money;
							}else {
								System.out.println("�ܾ� ����");
								continue;
							}

						}else {
							System.out.println("�ش� ���°� �����ϴ�.");
						}
					}
				}
			}
			else if(sel == 8) {
				if(log == -1) {
					System.out.println("�α��� ���¿����� �̿밡��");
					continue;
				}else {
					System.out.println(accs[log] + "���� �ܾ��� " + moneys[log] + "�� �Դϴ�.");
					continue;
				}
			}
			else if(sel == 9) {

				if(count == 0) {
					System.out.println("[�޼���]������ �����Ͱ� �����ϴ�.");
					continue;
				}
				String data = "";
				for(int i=0; i<count; i++) {
					data += accs[i];
					data += "/";
					data += pws[i];
					data += "/";
					data += moneys[i];
					data += "\n";
				}
				data = data.substring(0, data.length()-1);
				FileWriter fw = null;
				try {
					fw = new FileWriter(fileName);
					fw.write(data);
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					if(fw != null) {try {fw.close();} catch (IOException e) {}}
				}
			}
			else if(sel == 10) { File file = new File(fileName);
			if(file.exists()) {
				FileReader fr = null;
				BufferedReader br = null;
				try {
					fr = new FileReader(file);
					br = new BufferedReader(fr);
					String data = "";
					while(true) {
						String line = br.readLine();
						if(line == null) {
							break;
						}
						data += line;
						data += "\n";
					}
					data = data.substring(0, data.length()-1);

					String[] temp = data.split("\n");
					count = temp.length;
					for(int i=0; i<count; i++) {
						String[] info = temp[i].split("/");
						accs[i] = info[0];
						pws[i] = info[1];
						moneys[i] = Integer.parseInt(info[2]);
					}
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					if(fr != null) {try {fr.close();} catch (IOException e) {}}
					if(br != null) {try {br.close();} catch (IOException e) {}}
				}
			}
			}
			else if(sel == 0) {
				break;
			}

		}

	}
}
