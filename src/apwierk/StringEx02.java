package apwierk;

public class StringEx02 {

	public static void main(String[] args) {
		// 문제) 이름은 name배열에 성적은 score배열에 각각 저장 및 출력
		
				String str = "김철수/87,이만수/42,이영희/95";
				
				String[] name = new String[3];
				int[] score = new int[3];

				String [] temp1 = str.split(",");
				
				String [] temp2 = new String[temp1.length * 2];
				for(int i  = 0 ; i<temp1.length;i++) {
					temp2 = temp1[i].split("/");
					for(int j = 0 ; j<temp2.length;j++) {
						name[i] = temp2[0];
						score[i] = Integer.parseInt(temp2[1]);
					}
				}
				for(int i  = 0 ; i<name.length;i++) {
					System.out.println(name[i]);
					System.out.println(score[i]);
				}

	}

}
