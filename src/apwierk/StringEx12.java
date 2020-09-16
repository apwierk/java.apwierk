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
		String[] items = {"사과", "바나나", "딸기"};
		
		final int MAX_SIZE = 100;
		int[][] jang = new int[MAX_SIZE][2];

		String fileName = "jang.txt";
		
		int count = 0;
		int log = -1;
		
		while(true) {
			
			System.out.println("[MEGA SHOP]");
			System.out.println("[1]로그인");
			System.out.println("[2]로그아웃");
			System.out.println("[3]쇼핑");
			System.out.println("[4]장바구니");
			System.out.println("[5]저장");
			System.out.println("[6]로드");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				if(log != -1) {
					System.out.println("로그아웃 상태에서 이용가능");
					continue;
				}else {
					System.out.println("아이디를 입력하시오");
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
						System.out.println("비밀번호를 입력하시오.");
						String pw = scan.next();
						if(pws[ididx].equals(pw)) {
							log = ididx;
							System.out.println(ids[ididx] + "님 환영합니다.");
						}
					}
				}
			}
			else if(sel == 2) {
				if(log == -1) {
					System.out.println("로그인 상태에서만 이용가능");
					continue;
				}else {
					log = -1;
					System.out.println("로그아웃 완료");
				}
			}
			else if(sel == 3) {
				if(log == -1) {
					System.out.println("로그인 상태에서만 이용가능");
					continue;
				}else {
					for(int i = 0 ; i < items.length ; i++) {
						System.out.println("item : "+ i + " " + items[i]);
					}
					System.out.println("상품 번호를 입력하시오.");
					int num = scan.nextInt();
					jang[count][0] = log;
					jang[count][1] = num;
					
					count += 1;
				}
			}
			else if(sel == 4) {
				if(log == -1) {
					System.out.println("로그인 상태에서만 이용가능");
					continue;
				}else {
					System.out.println("===== 장바구니 목록 =====");
					for(int i = 0 ; i < count - 1; i++) {
						if(jang[i][0] == log) {
							System.out.print(jang[i][0] + " : ");
							if(jang[i][1] == 0) {
								System.out.println("사과");
							}else if(jang[i][1] == 1) {
								System.out.println("바나나");
							}else if(jang[i][1] == 2) {
								System.out.println("딸기");
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
				System.out.println("저장 완료");
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
					System.out.println("파일을 불러왔습니다.");
				}
			}
			else if(sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}
			
		}
		
	}
}
