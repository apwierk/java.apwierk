package apwierk;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;;


public class StringEx10 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] vector = null;
		int count = 0;

		String fileName = "vector.txt";

		while(true) {

			for(int i=0; i<count; i++) {
				System.out.print(vector[i] + " ");
			}
			System.out.println();

			System.out.println("[벡터 컨트롤러]");
			System.out.println("[1]추가하기");
			System.out.println("[2]삭제하기");
			System.out.println("[3]저장하기");
			System.out.println("[4]로드하기");
			System.out.println("[5]종료하기");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			if(sel == 1) {
				//				카운트가 0이면 백터배열 하나 만들기
				if(count == 0) {
					vector = new int[count + 1];
				}else if(count > 0) {
					int temp[] = vector;
					vector = new int[count + 1];
					for(int i = 0 ; i < count; i++) {
						vector[i] = temp[i];
					}
				}					
				System.out.println("추가 데이터 입력 : ");
				int data = scan.nextInt();
				vector[count] = data;
				count += 1;

			}
			else if(sel == 2) {
				System.out.println("삭제할 인덱스 입력 : ");
				int index = scan.nextInt();
				//				인덱스가 범위 밖일경우 메시지
				if(index > count || index < 0) {
					System.out.println("해당 index가 없습니다.");
					continue;
				}
				if(count == 1) {
					vector = null;
				}else if(count > 1) {
					int temp[] = vector;
					vector = new int[count - 1];
					int j = 0;
					for(int i=0; i<count; i++) {
						if(i != index) {
							vector[j] = temp[i];
							j += 1;
						}
					}
					temp = null;
					count -= 1;
				}


			}
			else if(sel == 3) {

				String data = "";
				if(count > 0) {
					for(int i=0; i<count; i++) {
						data += vector[i];
						data += "\n";
					}
					data = data.substring(0, data.length()-1);

					FileWriter fw = null;
					try {
						fw = new FileWriter(fileName);
						fw.write(data);
						fw.close();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}else {
					System.out.println("[메세지]저장할 데이터가 없습니다.");
				}

			}
			else if(sel == 4) {
				String data = "";
				File file = new File(fileName);
				if(file.exists()) {
					FileReader fr = null;
					BufferedReader br = null;
					try {
						fr = new FileReader(file);
						br = new BufferedReader(fr);

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

						vector = new int[count];

						for(int i=0; i<count; i++) {
							vector[i] = Integer.parseInt(temp[i]);
						}
						fr.close();
						br.close();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
			else if(sel == 5) {
				System.out.println("프로그램 종료");
				break;
			}

		}

	}
}
