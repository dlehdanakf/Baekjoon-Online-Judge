/**
 *	직사각형
 *	https://www.acmicpc.net/problem/1085
 *	2016-07-17
 */

package Rectangle;

import java.util.Scanner;

public class Main {
	public static int getMinimum(int a, int b, int c, int d){
		int ab = a < b ? a : b;
		int cd = c < d ? c : d;
		
		return ab < cd ? ab : cd;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		//	좌표로부터 위쪽까지 거리
		int up = Math.abs(y - h);
		
		//	좌표로부터 오른쪽까지 거리
		int right = Math.abs(x - w);
		
		//	가장 작은 수를 구한다.
		int min = Main.getMinimum(x, y, up, right);
		
		System.out.println(min);
	}
}
