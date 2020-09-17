package day0917_01;

import java.util.Scanner;
import java.util.Random;

public class Arcade {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		final int SIZE = 7;
		final int WALL = 3;
		final int PLAYER = 2;
		final int BOMB = 9;
		final int ITEM = 4;

		boolean playerDead = false;
		int bombMaxCount = 3;
		int bombCount = bombMaxCount;
		int wallCount = 20;
		int itemCount = 0;
		int pX = 0;
		int pY = 0;

		int[] bombX = new int[bombMaxCount];
		int[] bombY = new int[bombMaxCount];
		int[][] map = new int[SIZE][SIZE];


		//		����ġ 6��
		for(int i = 0 ; i < wallCount; i++) {
			int rX = ran.nextInt(SIZE);
			int rY = ran.nextInt(SIZE);
			if(map[rY][rX] == 0) {
				map[rY][rX] = WALL;
			}else {
				i -= 1;
			}
		}
		//		ĳ���͹�ġ
		while(true) {
			pX = ran.nextInt(SIZE);
			pY = ran.nextInt(SIZE);

			if(map[pY][pX] == 0) {
				map[pY][pX] = PLAYER;
				break;
			}
		}
		//		��ź��ġ
		for(int i = 0 ; i < bombCount; i++) {
			int rX = ran.nextInt(SIZE);
			int rY = ran.nextInt(SIZE);
			if(map[rY][rX] == 0) {
				map[rY][rX] = BOMB;
				bombX[i] = rX;
				bombY[i] = rY;
			}else {
				i -= 1;
			}
		}
		//		���ӽ���
		while(true) {
			System.out.println("����������������������������������������������������������������������");
			System.out.println("            Crazy Arcade");
			System.out.println("����������������������������������������������������������������������");
			System.out.println("�� ��ġ���� ��ź ����\t " + bombMaxCount + "EA");
			System.out.println("�� �����ִ� ��ź ����\t " + bombCount + "EA");
			System.out.println("�� �����ִ� ���� ����\t " + wallCount + "EA");
			System.out.println("�� ȹ���� ������ ����\t " + itemCount + "EA");
			// ��ź ���
			System.out.println("����������������������������������������������������������������������");
			System.out.println("�� ��ġ�� ��ź�� ��ġ");
			for(int i=0;i <bombCount; i++) {
				System.out.println("[" + (i+1) + "] " + bombY[i] + " : " + bombX[i]);
			}
			System.out.println("����������������������������������������������������������������������");
			wallCount = 0;
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<SIZE; j++) {
					if(map[i][j] == WALL) {
						wallCount = wallCount + 1;
						System.out.print("�� ");
					}else if(map[i][j] == PLAYER) {
						System.out.print("�� ");
					}else if(map[i][j] == BOMB) {
						System.out.print("�� ");
					}else if(map[i][j] == ITEM) {
						System.out.print("�� ");
					}else {
						System.out.print(map[i][j] + " ");
					}
				}
				System.out.println();
			}


			if(playerDead) {
				System.out.println("[�޼���]ĳ���Ͱ� ��ź�� �¾� �׾����ϴ�. ������ �����մϴ�.");
				break;
			}

			// �̵� �Է¹ޱ�
			System.out.print("��(8)��(2)��(4)��(6)��ź��ġ(5)����(0) �Է� : ");
			int move = scan.nextInt();
			int tempX = pX;
			int tempY = pY;
			if(move == 8 || move == 2 || move == 4 || move == 6) {
				if(move == 8) {
					tempY -= 1; 
				}else if(move == 6) {
					tempX += 1;
				}else if(move == 2) {
					tempY += 1;
				}else if(move == 4) {
					tempX -= 1;
				}
				if(SIZE <= tempY || tempY < 0) continue;
				if(SIZE <= tempX || tempX < 0) continue;
				if(map[tempY][tempX] == WALL) continue;
				if(map[tempY][tempX] == BOMB) continue;

				if(map[tempY][tempX] == ITEM) {
					map[pY][pX] = 0;
					itemCount -= 1;

					int[] x = bombX;
					int[] y = bombY;

					bombX = new int[bombMaxCount + 1];
					bombY = new int[bombMaxCount + 1];

					for(int i = 0 ; i <	bombMaxCount ; i++) {
						bombX[i] = x[i];
						bombY[i] = y[i];
					}
					x=null;
					y=null;

					bombMaxCount += 1;
				}
				if(map[pY][pX] == 2) {
					map[pY][pX] = 0;
				}
				pY = tempY;
				pX = tempX;
				map[pY][pX] = PLAYER;
			}else if(move == 5) {
				if(bombMaxCount <= bombCount) {
					System.out.println("���̻� ��ź�� ��ġ�� �� �����ϴ�.");
					continue;
				}
				if(map[pY][pX] != 2 && map[pY][pX] != 0) {
					System.out.println("�ش� ��ġ���� ��ź�� ��ġ�� �� �����ϴ�.");
					continue;
				}
				bombX[bombCount] = pX;
				bombY[bombCount] = pY;
				map[bombY[bombCount]][bombX[bombCount]] = BOMB;
				bombCount += 1;
			}else if(move == 0) {
				if(bombCount == 0) {
					System.out.println("��ź�� ��ġ �Ǿ������ʽ��ϴ�.");
					continue;
				}
				int xx= bombX[0];
				int yy= bombY[0];
				for(int i=-1; i<=1; i++) {
					if(0 <= xx + i && xx + i < SIZE) {
						if(map[yy][xx + i] == PLAYER) playerDead = true;
						// ���϶����� ��������
						if(map[yy][xx + i] == WALL) {
							// 50������ Ȯ���� ��(0) �Ǵ� ������(4)�� ����
							if(ran.nextInt(2) == 0) {
								map[yy][xx + i] = 0;
							}else {

								map[yy][xx + i] = ITEM;
								itemCount = itemCount + 1;
							}
						}
					}
					if(0 <= yy + i && yy + i < SIZE) {
						if(map[yy + i][xx] == PLAYER) playerDead = true;
						if(map[yy + i][xx] == WALL) {
							if(ran.nextInt(2) == 0) {
								map[yy + i][xx] = 0;
							}else {
								map[yy + i][xx] = ITEM;
								itemCount = itemCount + 1;
							}
						}
					}
				}
				// ���� ������ġ �ʱ�ȭ
				map[yy][xx] = 0;
				for(int i=0; i<bombMaxCount-1; i++) {
					bombX[i] = bombX[i + 1];
					bombY[i] = bombY[i + 1];
				}
				bombCount = bombCount - 1;


			}else {
				System.out.println("�߸� �Է��Ͽ����ϴ�.");
				continue;
			}


		}
		//		��ź���
		//		�̵� �Է¹ޱ�
		//		�̵� ����ó��
		//		������ ȹ��
		//		ĳ���� ��ġ �̵�
		//		����ó��

	}

}
