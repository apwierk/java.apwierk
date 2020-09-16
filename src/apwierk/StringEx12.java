package apwierk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StringEx12 {

	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
		
		String[] ids = {"qwer", "javaking", "abcd"};
		String[] pws = {"1111",   "2222", "3333"};
		String[] items = {"���", "�ٳ���", "����"};
		
		final int MAX_SIZE = 100;
		int[][] jang = new int[MAX_SIZE][2];

		String fileName = "jang.txt";
		
		int count = 0;
		int log = -1;
		
		while(true) {
			
			System.out.println("[MEGA SHOP]");
			System.out.println("[1]�α���");
			System.out.println("[2]�α׾ƿ�");
			System.out.println("[3]����");
			System.out.println("[4]��ٱ���");
			System.out.println("[5]����");
			System.out.println("[6]�ε�");
			System.out.println("[0]����");
			
			System.out.print("�޴� ���� : ");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				if(log != -1) {
					System.out.println("�α׾ƿ� ���¿��� �̿밡��");
					continue;
				}else {
					System.out.println("���̵� �Է��Ͻÿ�");
					String id = scan.next();
					int check = -1;
					int ididx = 0;
					for(int i = 0 ; i < ids.length ; i++) {
						if(ids[i].equals(id)) {
							check = 0;
							ididx = i;
						}
					}
					if(check == 0) {
						System.out.println("��й�ȣ�� �Է��Ͻÿ�.");
						String pw = scan.next();
						if(pws[ididx].equals(pw)) {
							log = ididx;
							System.out.println(ids[ididx] + "�� ȯ���մϴ�.");
						}
					}
				}
			}
			else if(sel == 2) {
				if(log == -1) {
					System.out.println("�α��� ���¿����� �̿밡��");
					continue;
				}else {
					log = -1;
					System.out.println("�α׾ƿ� �Ϸ�");
				}
			}
			else if(sel == 3) {
				if(log == -1) {
					System.out.println("�α��� ���¿����� �̿밡��");
					continue;
				}else {
					for(int i = 0 ; i < items.length ; i++) {
						System.out.println("item : "+ i + " " + items[i]);
					}
					System.out.println("��ǰ ��ȣ�� �Է��Ͻÿ�.");
					int num = scan.nextInt();
					jang[count][0] = log;
					jang[count][1] = num;
					
					count += 1;
				}
			}
			else if(sel == 4) {
				if(log == -1) {
					System.out.println("�α��� ���¿����� �̿밡��");
					continue;
				}else {
					System.out.println("===== ��ٱ��� ��� =====");
					for(int i = 0 ; i < count - 1; i++) {
						if(jang[i][0] == log) {
							System.out.print(jang[i][0] + " : ");
							if(jang[i][1] == 0) {
								System.out.println("���");
							}else if(jang[i][1] == 1) {
								System.out.println("�ٳ���");
							}else if(jang[i][1] == 2) {
								System.out.println("����");
							}
						}
					}
				}
			}
			else if(sel == 5) {
				String data = "";
				
				for(int i = 0 ; i < count; i++) {
					data += jang[i][0];
					data += "/";
					data += jang[i][1];
					data += "\n";
				}
				data = data.substring(0, data.length()-1);
				System.out.println(data);
				
				FileWriter fw = null;
				try {
					fw = new FileWriter(fileName);
					fw.write(data);
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					if(fw != null) {try {fw.close();} catch(IOException e) {}}
				}
				System.out.println("���� �Ϸ�");
			}
			else if(sel == 6) {
				File file = new File(fileName);
				if(file.exists()) {
					FileReader fr = null;
					BufferedReader br = null;
					try {
						fr = new FileReader(file);
						br = new BufferedReader(fr);
						
						count = 0;
						String line = br.readLine();
						while(line != null) {
							String[] temp = line.split("/");
							jang[count][0] = Integer.parseInt(temp[0]);
							jang[count][1] = Integer.parseInt(temp[1]);
							
							count += 1;
							
							line = br.readLine();
						}
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						if(fr != null) {
							try {
								fr.close();
							}catch(IOException e) {}
						}
						if(br != null) {
							try {
								br.close();
							}catch(IOException e) {}
						}
					}
					System.out.println("������ �ҷ��Խ��ϴ�.");
				}
			}
			else if(sel == 0) {
				System.out.println("���α׷� ����");
				break;
			}
			
		}
		
	}
}
