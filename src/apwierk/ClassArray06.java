package apwierk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

class Student{
	String id = "";
	String pw = "";

	void set_data(String i , String p) {
		id = i;pw = p;
	}

	void print_data() {
		System.out.println("이름 : " + id + "\n비밀번호 : " + pw);
	}

}
class Manager{
	Student [] list = null;
	int count = 0;
	
	String out_data() {
		String data = "";
		if(count == 0) {
			return data;
		}
		data += count;
		data += "\n";
		for(int i = 0;i<count;i++) {
			data += list[i].id;
			data += ",";
			data += list[i].pw;
			if(count -1 != i) {
				data += "\n";
			}
		}
		return data;
	}
	void load_student(Student [] temp , int c) {
		count = c;
		list = temp;
	}
}


public class ClassArray06 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Manager mng = new Manager();

		boolean run = true;
		while(run) {
			System.out.println("1.가입 2.탈퇴 3.정렬 4.출력 5.저장 6.로드");
			int sel = scan.nextInt();

			if(sel == 1) {
				if(mng.count > 0) {
					int check = 0;
					Student [] temp = new Student[mng.count];
					for(int i = 0;i<mng.count;i++) {
						temp[i] = new Student();
						temp[i] = mng.list[i];
					}
					mng.list = new Student[mng.count+1];
					mng.list[mng.count] = new Student();
					for(int i = 0;i<mng.count;i++) {
						mng.list[i] = temp[i];
					}
					System.out.print("가입 id 입력 : ");
					String id = scan.next();
					for(int i = 0;i<mng.count;i++) {
						if(mng.list[i].id.equals(id)) {
							check = 1;
						}
					}
					if(check == 0) {
						System.out.print("가입 pw 입력 : ");
						String pw = scan.next();
						mng.list[mng.count].set_data(id, pw);
						mng.count += 1;	
					}else if(check == 1) {
						System.out.println("이미 가입되어있는 id입니다.");
						continue;
					}
				}else if(mng.count == 0) {
					mng.list = new Student[1];
					mng.list[0] = new Student();
					System.out.print("가입 id 입력 : ");
					String id = scan.next();
					System.out.print("가입 pw 입력 : ");
					String pw = scan.next();
					mng.list[0].set_data(id, pw);
					mng.count += 1;
				}
				for(int i = 0;i<mng.list.length;i++) {
					mng.list[i].print_data();
				}
			}else if(sel == 2) {
				System.out.print("탈퇴할 id를 입력하시오 : ");
				String id = scan.next();
				int index = 0;
				for(int i = 0;i<mng.count;i++) {
					if(mng.list[i].id.equals(id)) {
						index = i;
					}
				}
				Student [] temp = new Student[mng.count];
				for(int i = 0;i<mng.count;i++) {
					temp[i] = new Student();
					temp[i] = mng.list[i];
				}
				mng.count -= 1;
				mng.list = new Student[mng.count];
				for(int i = 0;i<index;i++) {
					mng.list[i] = new Student();
					mng.list[i] = temp[i];
				}
				for(int i = index+1;i<mng.count;i++) {
					mng.list[i] = new Student();
					mng.list[i] = temp[i];
				}

			}else if(sel == 3) {
				for(int i = 0;i<mng.count;i++) {
					for(int j = i;j<mng.count;j++) {
						if(mng.list[i].id.compareTo(mng.list[j].id) > 0) {
							Student temp = mng.list[i];
							mng.list[i] = mng.list[j];
							mng.list[j] = temp;
						}
					}
				}
				for(int i = 0;i<mng.count;i++) {
					mng.list[i].print_data();
				}
			}else if(sel == 4) {
				for(int i = 0;i<mng.count;i++) {
					mng.list[i].print_data();
				}
			}else if(sel == 5) {
				if(mng.count == 0) return;
				try {
					FileWriter fw = new FileWriter("student_manager.text");
					String data = mng.out_data();
					if(!data.equals("")) {
						fw.write(data);
						System.out.println(data);
					}
					fw.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}else if(sel == 6) {
				try {
					File file = new File("student_manager.text");
					if(file != null) {
						FileReader fr = new FileReader(file);
						BufferedReader br = new BufferedReader(fr);
						String line = br.readLine();
						int count = Integer.parseInt(line);
						Student [] temp = new Student[count];
						for(int i = 0; i < count; i++) {
							temp[i] = new Student();
							line = br.readLine();
							String value[] = line.split(",");
							temp[i].id = value[0];
							temp[i].pw = value[1];
						}
						fr.close();
						br.close();
						mng.load_student(temp , count);
					}
					for(int i = 0;i<mng.count;i++) {
						mng.list[i].print_data();
					}
				}
				catch (Exception e) {e.printStackTrace();}

			}
		}
	}

}