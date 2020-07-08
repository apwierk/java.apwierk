package apwierk;

import java.util.Random;

class Horse{
	String name = "";
	int pos = 0;
	int rank = 0;
	boolean win = false;
}
class Racing {
	Random ran = new Random();
	int size = 4;
	Horse[] horses = new Horse[size];
	int line = 20;
	int track[][] = new int[size][line]; 
	void setTrack() {
		for(int i = 0;i<size;i++) {
			horses[i] = new Horse();
		}
		for(int i = 0;i<size;i++) {
			track[i][0] = 1;
		}

	}
	void printTrack() {
		for(int i = 0;i<size;i++) {
			for(int j = 0;j<line;j++) {
				if(track[i][j] == 0) {
					System.out.print("¤Ñ");
				}else if(track[i][j] == 1) {
					System.out.print("¢ç");
				}
			}System.out.println();
		}
	}
	void raceHorse() {
		for(int i = 0;i<size;i++) {
			int race = ran.nextInt(5)+1;
			int idx = 0;
			for(int j = 0;j<line;j++) {
				if(track[i][j] == 1) {
					idx = j;
				}
			}
			if(idx+race < 19) {
				track[i][idx] = 0;
				track[i][idx+race] = 1;
			}if(idx + race >= 19) {
				track[i][idx] = 0;
				track[i][19] = 1;
				continue;
			}

		}
	}
	

	void run() {
		setTrack();
		boolean run = true;
		int cnt = 1;
		while(run) {
			printTrack();
			System.out.println();
			raceHorse();
			for(int i = 0;i<size;i++) {
				if(track[i][19] == 1) {
					if(horses[i].win == false) {
						horses[i].rank = cnt;
						horses[i].win = true;
						cnt += 1;
					}else if(horses[i].win == true) {
						continue;
					}
				}
				
			}
			if(cnt == 5) {
				for(int i = 0;i<size;i++) {
					System.out.println("µî¼ö : "+horses[i].rank);
				}
				run = false;
			}
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				
			}
		}
	}

}

public class ClassArray04 {

	public static void main(String[] args) {
		Racing race = new Racing();
		race.run();
	}

}
