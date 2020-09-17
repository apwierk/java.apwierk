package day0917_01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Console {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String fileName = "board.txt";

		String[][] board = null;
		int count = 0;				// 전체 게시글 수
		int pageSize = 5;			// 한 페이지에 보여줄 게시글 수
		int curPageNum = 1;			// 현재 페이지 번호
		int pageCount = 0;			// 전체 페이지		개수 게시글 / 5
		int startRow = 0;			// 현재 페이지의 게시글 시작 번호		
		int endRow = 0;				// 현재 페이지의 게시글 마지막 번호

		
		File file = new File(fileName);
		if(file.exists()) {
			FileReader fr = null;
			BufferedReader br = null;
			
			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				
				String size = br.readLine();
				count = Integer.parseInt(size);
				
				String data = "";
				for(int i = 0 ; i < count; i++) {
					data += br.readLine();
					if(i != count -1) {
						data += "\n";
					}
				}
				
				if(count > 0) {
					String[] info = data.split("\n");
					board = new String[count][2];
					
					for(int i = 0 ; i < info.length; i++) {
						String[] temp = info[i].split("/");
						board[i][0] = temp[0];
						board[i][1] = temp[1];
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(fr != null) {
					try {
						fr.close();
					}catch (IOException e){
						
					}
				}
				if(br != null) {
					try {
						br.close();
					}catch (IOException e){
						
					}
				}
			}
		}
		
		while(true) {
			
			
			pageCount = count / 5;
			if(count % pageSize > 0) {
				pageCount += 1;
			}
			
			startRow = (curPageNum - 1) * pageSize;
			endRow = startRow + pageSize;
			if(endRow > count) endRow = count;
			
			System.out.println("게시판 (" + count + ")개");
			System.out.println("현재 페이지 : " + curPageNum);
			for(int i=startRow; i<endRow; i++) {
				System.out.println("(" + (i+1) + ")" + board[i][0]);
			}
			System.out.println();

			
			System.out.println("[1]이전");
			System.out.println("[2]이후");
			System.out.println("[3]추가하기");
			System.out.println("[4]삭제하기");
			System.out.println("[5]내용확인");

			int choice = scan.nextInt();

			if(choice == 1) {
				if (curPageNum == 1) {
					continue;
				}
				curPageNum -= 1;
			}
			else if(choice == 2) {
				if(curPageNum >= pageCount) {
					continue;
				}
				curPageNum += 1;
			}
			else if(choice == 3) {
				if(count == 0) {
					board = new String[count+1][2];
				}else if(count > 0) {
					String temp[][] = board;
					
					board = new String[count + 1][2];
					for(int i = 0 ; i < count; i++) {
						board[i] = temp[i];
					}
					temp = null;
				}
				
				System.out.println("게시글 제목을 입력하세요 : ");
				board[count][0] = scan.next();
				System.out.println("게시글 내용을 입력하세요 : ");
				board[count][1] = scan.next();
				
				count += 1;
				
				String data = "";
				data += count;
				data += "\n";
				
				for(int i = 0; i < count; i++) {
					data += board[i][0];
					data += "/";
					data += board[i][1];
					if(i != count -1) {
						data += "\n";
					}
				}
				
				FileWriter fw = null;
				try {
					fw = new FileWriter(fileName);
					fw.write(data);
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if(fw != null) {
						try {
							fw.close();
						} catch(IOException e) {}
					}
				}
			}
			else if(choice == 4) {
				System.out.println("삭제할 번호를 입력하시오 : ");
				int num = scan.nextInt();
				num -= 1;
				if(count > num) {
					if(count == 1) {
						board = null;
					}else if(count > 1) {
						String [][] temp = board;
						
						board = new String[count-1][2];
						int j = 0 ;
						for(int i = 0 ; i < count ; i++) {
							if(i != num) {
								board[j] = temp[i];
								j += 1;
							}
						}
						temp = null;
					}
					count -= 1;
				}else if(num > 0 || count <= num) {
					System.out.println("해당 위치의 게시글은 삭제할 수 없습니다.");
					continue;
				}
				String data = "";
				data += count;
				data += "\n";
				
				for(int i=0; i<count; i++) {
					data += board[i][0];
					data += "/";
					data += board[i][1];
					if(i != count - 1) {
						data += "\n";
					}
				}
				
				FileWriter fw = null;
				try {
					fw = new FileWriter(fileName);
					fw.write(data);
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if(fw != null) { try { fw.close(); } catch (IOException e) { } }
				}		

			}
			else if(choice == 5) {
				System.out.println("게시글 번호를 입력하세요 : ");
				int num = scan.nextInt();
				num -= 1;
				
				if(count > num) {
					System.out.println("내용 = " + board[num][1]);
				}else if(num > 0 || count <= num) {
					System.out.println("해당 게시글의 내용은 확인할 수 없습니다.");
					continue;
				}
			}
		}
	}
}
