package apwierk;

import java.util.Random;

class Lotto{
	int [] data = new int[8];
	boolean win = false;
	void print() {
		for(int i = 0;i<8;i++) {
			System.out.print(data[i]);
		}System.out.println();
	}
}

public class ClassArray01 {

	public static void main(String[] args) {
		Random ran = new Random();
		Lotto[] lotto = new Lotto[5];
		for(int i = 0;i<lotto.length;i++) {
			lotto[i] = new Lotto();
		}
		int check = 0;
		int index = 0;
		for(int i = 0;i<lotto.length;i++) {
			for(int j = 0;j<lotto.length;j++) {
				lotto[i].data[j] = ran.nextInt(2);
			}
			if(check == 0) {
				for(int j = 0;j<lotto.length;j++) {
					if(lotto[i].data[j] == 1) {
						if(lotto[i].data[j+1] == 1) {
							if(lotto[i].data[j+2] == 1) {
								check = 1;
								index = i;
							}	
						}
					}
				}
			}else if(check == 1) {
				for(int j = 0;j<lotto.length;j++) {
					if(lotto[i].data[j] == 1) {
						if(lotto[i].data[j+1] == 1) {
							if(lotto[i].data[j+2] == 1) {
								lotto[i].data[j+2] = 0;
							}	
						}
					}
				}
			}
		}
		for(int i = 0;i<lotto.length;i++) {
		lotto[i].print();
		}
		System.out.println("´çÃ· index : " + index);

	}

}