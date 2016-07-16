/**
 *	탄산음
 *	https://www.acmicpc.net/problem/5032
 *	2016-07-16
 */

package SparklingDrink;

import java.util.Scanner;

public class Main {
	public static int getCanNumber(int num, int per){
		/**
		 *	교환할 수 있는 캔을 계산한다.
		 *	재귀적 함수를 호출한다.
		 */
		int can_trade = num / per;
		int remain = num % per;
		
		if(can_trade + remain >= per){
			return Main.getCanNumber(can_trade + remain, per) + can_trade;
		}
		
		return can_trade;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int have = sc.nextInt();
		int today = sc.nextInt();
		int trade = sc.nextInt();
		
		int result = Main.getCanNumber(have + today, trade);
		System.out.println(result);
	}
}
