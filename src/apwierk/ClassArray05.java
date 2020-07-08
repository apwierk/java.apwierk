package apwierk;

class Student1{
	String name;
	int score;
	void print() {
		System.out.println(name + " : " + score);
	}
}

public class ClassArray05 {

	public static void main(String[] args) {
		String data = "3\n";
		data += "±è¿µÈñ/30\n";
		data += "ÀÌ¸¸¼ö/40\n";
		data += "ÀÌÃ¶¹Î/60";

		Student1 st[];

		String[] temp = data.split("\n");
		int size = Integer.parseInt(temp[0]);

		st = new Student1[size];
		for(int i = 0;i<size;i++) {
			st[i] = new Student1();
		}
		for(int i = 0;i<size;i++) {
			String[] info = temp[i+1].split("/");
			st[i].name = info[0];
			st[i].score = Integer.parseInt(info[1]);

			st[i].print();
		}
		System.out.println();
		System.out.println();
		System.out.println();
		int min = st[0].score;
		int minIdx = 0;
		for(int i = 0;i<size;i++) {
			if(st[i].score < min) {
				min = st[i].score;
				minIdx = i;
			}
		}
		
		data += "\n";
		data += "\n";
		for(int i = 0;i<minIdx;i++) {
			data += st[i].name;
			data += "/";
			data += st[i].score;
			data += "\n";
		}
		for(int i = minIdx+1;i<size;i++) {
			data += st[i].name;
			data += "/";
			data += st[i].score;
			data += "\n";
		}
		System.out.println(data);


	}

}
